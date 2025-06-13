package org.appops.teacherapp.core;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import org.appops.core.service.annotation.Service;

import com.google.inject.BindingAnnotation;

@Service
@BindingAnnotation
@Retention(RetentionPolicy.RUNTIME)
public @interface TeacherService {

}
