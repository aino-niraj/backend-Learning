
package org.appops.teacherapp.converter;

import org.appops.teacherapp.core.Teacher;
import org.appops.teacherapp.pojo.TeacherPojo;

public class TeacherConverter {

    
    public TeacherPojo convertToPojo(Teacher teacher) {
        TeacherPojo pojo = new TeacherPojo();
        pojo.setId(teacher.getId());
        pojo.setName(teacher.getName());
        pojo.setSubject(teacher.getSubject());
        pojo.setEmail(teacher.getEmail());
        return pojo;
    }

 
    public Teacher convertToDomain(TeacherPojo pojo) {
    	Teacher teacher = new Teacher();
    	teacher.setId(pojo.getId());
    	teacher.setName(pojo.getName());
    	teacher.setSubject(pojo.getSubject());
    	teacher.setEmail(pojo.getEmail());
        return teacher;
    }
}
