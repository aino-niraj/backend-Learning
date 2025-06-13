
package org.appops.teacherapp.storeimpl;

import java.util.List;
import java.util.stream.Collectors;

import org.appops.teacherapp.converter.TeacherConverter;
import org.appops.teacherapp.core.Teacher;
import org.appops.teacherapp.dao.TeacherDao;
import org.appops.teacherapp.pojo.TeacherPojo;
import org.appops.teacherapp.store.TeacherStoreApi;

import com.google.inject.Inject;
import com.google.inject.Singleton;

@Singleton
public class TeacherStore implements TeacherStoreApi{
	private final TeacherDao teacherDao;
	private final TeacherConverter teacherConverter;
	

	@Inject
	public TeacherStore(TeacherDao teacherDao, TeacherConverter teacherConverter) {
		this.teacherDao = teacherDao;
		this.teacherConverter = teacherConverter;
	}

	@Override
	public Integer addTeacher(String name, String subject, String email) {
		TeacherPojo pojo = new TeacherPojo(name, subject, email);
		return teacherDao.createTeacher(pojo);
	}

	@Override
	public Teacher viewTeacherById(Integer id) {
		return teacherConverter.convertToDomain(teacherDao.getTeacherById(id));
	}

	@Override
	public boolean deleteTeacherById(Integer id) {
		return teacherDao.deleteTeacher(id);
	}

	@Override
	public boolean updateTeacher(Integer id, String name, String subject, String email) {
		TeacherPojo pojo = new TeacherPojo(id, name, subject, email);
		return teacherDao.updateTeacher(pojo);
	}

	@Override
	public List<Teacher> getAllTeacher() {
		return teacherDao.getAllTeacher().stream().map(teacherConverter::convertToDomain).collect(Collectors.toList());
	}




}
