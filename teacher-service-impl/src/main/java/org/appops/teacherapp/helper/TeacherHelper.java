
package org.appops.teacherapp.helper;


import java.util.List;
import java.util.stream.Collectors;

import org.appops.teacherapp.converter.TeacherConverter;
import org.appops.teacherapp.core.Teacher;
import org.appops.teacherapp.dao.TeacherDao;
import org.appops.teacherapp.pojo.TeacherPojo;

import com.google.inject.Inject;

public class TeacherHelper {

	private final TeacherDao teacherDao;
	private final TeacherConverter teacherConverter;

	@Inject
	public TeacherHelper(TeacherDao teacherDao, TeacherConverter teacherConverter) {
		this.teacherDao = teacherDao;
		this.teacherConverter = teacherConverter;
	}

	public Integer addTeacher(Integer id, String name, String subject, String email) {
		Teacher teacher = new Teacher(id,name, subject, email);
		TeacherPojo Teacherpojo = teacherConverter.convertToPojo(teacher);
		return teacherDao.createTeacher(Teacherpojo);
	}

	public boolean updateStudent(Integer id, String name, String subject, String email) {
		Teacher teacher = new Teacher(id, name, subject, email);
		TeacherPojo teacherPojo = teacherConverter.convertToPojo(teacher);
		return teacherDao.updateTeacher(teacherPojo);
	}

	public boolean deleteTeacherById(Integer id) {
		return teacherDao.deleteTeacher(id);
	}

	public Teacher viewTeacherById(Integer id) {
		TeacherPojo teacherpojo = teacherDao.getTeacherById(id);
		return teacherConverter.convertToDomain(teacherpojo);
	}

	public List<Teacher> getAllTeachers() {
		List<TeacherPojo> teachersPojo = teacherDao.getAllTeacher();
		return teachersPojo.stream().map(teacherConverter::convertToDomain).collect(Collectors.toList());
	}
}
