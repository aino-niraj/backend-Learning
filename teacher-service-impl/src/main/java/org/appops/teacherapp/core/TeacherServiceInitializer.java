package org.appops.teacherapp.core;

import java.lang.annotation.Annotation;

import org.appops.core.deployment.ServiceConfiguration;
import org.appops.entity.meta.core.Schema;
import org.appops.entitystore.hibernate.SchemaDefinitionGenerator;
import org.appops.entitystore.hibernate.SessionFactoryStore;
import org.appops.entitystore.hibernate.configuration.SessionFactoryGenerator;
import org.appops.service.ServiceInitializer;
import org.appops.service.generator.ServiceMetaGenerator;
import org.appops.slim.base.api.ServiceMetaManager;
import org.appops.teacherapp.core.TeacherService;
import org.hibernate.SessionFactory;

import com.google.inject.Inject;
import com.google.inject.Provider;

@TeacherService
public class TeacherServiceInitializer extends ServiceInitializer {
	private Provider<SchemaDefinitionGenerator> schemaDefGenerator;
	private Provider<SessionFactoryGenerator> sessionFactoryGenerator;
	private SessionFactoryStore sessionFactoryStore;
	
	
	@Inject
	public TeacherServiceInitializer(
	Provider<ServiceMetaGenerator> serviceMetaGenerator,
			Provider<ServiceMetaManager> serviceMetaManager, Provider<SchemaDefinitionGenerator> schemaDefGenerator,
			Provider<SessionFactoryGenerator> sessionFactoryGenerator, SessionFactoryStore sessionFactoryStore
		) {
		super(serviceMetaGenerator, serviceMetaManager);
		this.schemaDefGenerator = schemaDefGenerator;
		this.sessionFactoryStore = sessionFactoryStore;
		this.sessionFactoryGenerator = sessionFactoryGenerator;
	}
	
	public void registerSchemaDefinition(Class<? extends Annotation> serviceAnnotation) {
		Schema schema = schemaDefGenerator.get().generatateSchemaDefinition(serviceAnnotation);
		SessionFactory sessionFactory = sessionFactoryGenerator.get().generateSessionFactory(schema);
		sessionFactoryStore.addSessionFactory(schema.getName(), sessionFactory);
	}
	
	@Override
	public String initialize(String serviceName, ServiceConfiguration config,
			Class<? extends Annotation> serviceAnnotation) {
		addServiceMeta(serviceName, config, serviceAnnotation);
		registerSchemaDefinition(serviceAnnotation);
		return serviceName;
		
	}

}
