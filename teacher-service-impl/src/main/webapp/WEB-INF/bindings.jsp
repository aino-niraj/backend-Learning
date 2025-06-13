
<%@ page import="com.google.inject.*"%>
<%@ page import="java.util.*"%>
<%@ page import="org.appops.service.entrypoint.ServiceEntryPoint"%>
<%@ page import="org.appops.teacherapp.core.*"%>
<%@ page import="org.appops.teacherapp.helper.*"%>
<%@ page import="org.appops.teacherapp.dao.*"%>
<%@ page import="org.appops.teacherapp.converter.*"%>
<%@ page import="org.appops.teacherapp.store.*"%>
<%@ page import="org.appops.teacherapp.storeimpl.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Teacher Service Bindings</title>
<style>
body {
	font-family: Arial, sans-serif;
	margin: 20px;
}

.container {
	max-width: 1200px;
	margin: 0 auto;
}

.binding {
	background: #f5f5f5;
	padding: 10px;
	margin: 10px 0;
	border-radius: 4px;
}

.key {
	color: #2c3e50;
	font-weight: bold;
}

.value {
	color: #34495e;
}

.section {
	margin-top: 20px;
	border-bottom: 1px solid #ddd;
	padding-bottom: 10px;
}

.error {
	color: #e74c3c;
	padding: 10px;
	background: #fde8e8;
	border-radius: 4px;
}
</style>
</head>
<body>
	<div class="container">
		<h1>Teacher Service Bindings</h1>

		<%
            Injector injector = null;
            try {
                TeacherServiceEntryPoint serviceEntryPoint = (TeacherServiceEntryPoint) ServiceEntryPoint.getCurrentServiceInstance();
                injector = serviceEntryPoint.getServiceInjector();

                if (injector != null) {
                    Map<Key<?>, Binding<?>> bindings = injector.getAllBindings();
        %>
		<div class="section">
			<h2>Core Components</h2>
			<%
                            displayBinding(injector, TeacherService.class);
                            displayBinding(injector, TeacherStoreApi.class);
                            displayBinding(injector, TeacherStore.class);
                        %>
		</div>

		<div class="section">
			<h2>Helper Classes</h2>
			<%
                            displayBinding(injector, TeacherHelper.class);
                            displayBinding(injector, TeacherConverter.class);
                            displayBinding(injector, TeacherDao.class);
                        %>
		</div>

		<div class="section">
			<h2>All Bindings</h2>
			<%
                            for (Map.Entry<Key<?>, Binding<?>> entry : bindings.entrySet()) {
                        %>
			<div class="binding">
				<div class="key">
					Key:
					<%= entry.getKey().toString().replaceAll("<", "&lt;").replaceAll(">", "&gt;") %></div>
				<div class="value">
					Implementation:
					<%= entry.getValue().getProvider().get().getClass().getName() %></div>
			</div>
			<%
                            }
                        %>
		</div>
		<%
                } else {
        %>
		<div class="error">Injector not available</div>
		<%
                }
            } catch (Exception e) {
        %>
		<div class="error">
			Error:
			<%= e.getMessage() %></div>
		<%
            }
        %>
	</div>

	<%!
        private void displayBinding(Injector injector, Class<?> clazz) {
            try {
                Object instance = injector.getInstance(clazz);
    %>
	<div class="binding">
		<div class="key">
			Interface:
			<%= clazz.getName() %></div>
		<div class="value">
			Implementation:
			<%= instance.getClass().getName() %></div>
	</div>
	<%
            } catch (Exception e) {
    %>
	<div class="error">
		Failed to get binding for
		<%= clazz.getName() %>:
		<%= e.getMessage() %></div>
	<%
            }
        }
    %>
</body>
</html>
