
package org.appops.teacherapp.dao;

import org.appops.teacherapp.core.TeacherService;
import org.appops.teacherapp.pojo.TeacherPojo;
import org.appops.entitystore.hibernate.dao.SingleEntityDaoBase;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.google.inject.Inject;
import com.google.inject.Provider;

import java.util.List;
import java.util.logging.Logger;

public class TeacherDao extends SingleEntityDaoBase {
	private Logger logger = Logger.getLogger(this.getClass().getSimpleName());

	@Inject
	public TeacherDao(@TeacherService Provider<Session> sessionFactory) {
		super(sessionFactory);
	}

	public Integer createTeacher(TeacherPojo teacherPojo) {
		return savePojo(teacherPojo);
	}

	public boolean updateTeacher(TeacherPojo teacherPojo) {
		Session session = null;
		Transaction transaction = null;
		try {
			session = getPojoSession();
			transaction = session.beginTransaction();
			session.update(teacherPojo);
			transaction.commit();
			return true;
		} catch (Exception e) {
			if (transaction != null)
				transaction.rollback();
			e.printStackTrace();
			return false;
		} finally {
			if (session != null)
				session.close();
		}
	}

	public boolean deleteTeacher(Integer id) {
		Session session = null;
		Transaction transaction = null;
		try {
			session = getPojoSession();
			transaction = session.beginTransaction();
			TeacherPojo student = session.get(TeacherPojo.class, id);
			if (student != null) {
				session.delete(student);
				transaction.commit();
				return true;
			}
			return false;
		} catch (Exception e) {
			if (transaction != null)
				transaction.rollback();
			e.printStackTrace();
			return false;
		} finally {
			if (session != null)
				session.close();
		}
	}

	public TeacherPojo getTeacherById(Integer id) {
		Session session = null;
		try {
			session = getPojoSession();
			return session.get(TeacherPojo.class, id);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			if (session != null)
				session.close();
		}
	}

	public List<TeacherPojo> getAllTeacher() {
		Session session = null;
		try {
			session = getPojoSession();
			return session.createQuery("from TeacherPojo", TeacherPojo.class).list();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			if (session != null)
				session.close();
		}
	}
}
