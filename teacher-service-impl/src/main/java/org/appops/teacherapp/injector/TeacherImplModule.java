package org.appops.teacherapp.injector;

import org.appops.core.annotation.ImplModule;
import org.appops.entitystore.hibernate.SessionFactoryProvider;
import org.appops.service.injection.ServiceModule;
import org.appops.teacherapp.core.TeacherService;
import org.appops.teacherapp.store.TeacherStoreApi;
import org.appops.teacherapp.storeimpl.TeacherStore;
import org.hibernate.Session;
import com.google.inject.Inject;
import com.google.inject.Provides;
import com.google.inject.Singleton;


@ImplModule(serviceName = TeacherService.class)
public class TeacherImplModule extends ServiceModule {
	@Override
	public void configureModule() {
		bind(TeacherStoreApi.class).to(TeacherStore.class).in(Singleton.class);
	}
	@Inject
	@Provides
	@TeacherService
	public Session provideSession(SessionFactoryProvider sessionFactoryProvider) {
		return sessionFactoryProvider.getSessionFactory(TeacherService.class.getSimpleName()).openSession();
	}
}
