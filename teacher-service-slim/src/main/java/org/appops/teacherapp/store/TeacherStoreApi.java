
package org.appops.teacherapp.store;

import org.appops.core.service.RequestMethod;
import org.appops.core.service.annotation.ServiceOp;
import org.appops.teacherapp.core.Teacher;
import org.appops.teacherapp.core.TeacherService;

import java.util.List;
import java.util.Optional;

@TeacherService
public interface TeacherStoreApi {

	@ServiceOp(method = RequestMethod.POST, path = "teacher/add")
	Integer addTeacher(String name, String subject, String email);

	@ServiceOp(method = RequestMethod.GET, path = "teacher/all")
	List<Teacher> getAllTeacher();

    @ServiceOp(method = RequestMethod.GET, path = "teacher/view/{id}")
    Teacher viewTeacherById(Integer id);


    @ServiceOp(method = RequestMethod.DELETE, path = "teacher/delete/{id}")
    boolean deleteTeacherById(Integer id);
    
    @ServiceOp(method = RequestMethod.PUT, path = "teacher/update")
    boolean updateTeacher(Integer id, String name, String subject, String email);

}
