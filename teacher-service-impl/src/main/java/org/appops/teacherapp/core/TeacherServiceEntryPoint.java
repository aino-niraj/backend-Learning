package org.appops.teacherapp.core;

import java.io.IOException;

import org.appops.core.ServiceException;
import org.appops.service.entrypoint.ServiceEntryPoint;


public class TeacherServiceEntryPoint extends ServiceEntryPoint{
	public static void main(String[] args) throws IOException, ServiceException {
		new TeacherServiceEntryPoint().startService(args);
	}
}
