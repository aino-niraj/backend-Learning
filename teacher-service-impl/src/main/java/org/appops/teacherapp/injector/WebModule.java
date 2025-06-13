
package org.appops.teacherapp.injector;


import org.appops.teacherapp.helper.ViewBindingsServlet;
import org.eclipse.jetty.servlet.DefaultServlet;

import com.google.inject.servlet.ServletModule;


public class WebModule extends ServletModule {
    @Override
    protected void configureServlets() {
        serve("/TeacherService/teacher/viewBindings").with(ViewBindingsServlet.class);
        serveRegex(".*\\.jsp").with(DefaultServlet.class);
    }
}

