
package org.appops.teacherapp.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.appops.teacherapp.core.TeacherService;

@Entity
@Table(name = "teachers")
@TeacherService
public class TeacherPojo implements java.io.Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private Integer id;

	@Column(name = "name", nullable = false)
	private String name;

	@Column(name = "subject", nullable = false)
	private String subject;

	@Column(name = "email", nullable = false)
	private String email;


	public TeacherPojo() {
	}

	public TeacherPojo(String name, String subject, String email) {
		super();
		this.name = name;
		this.subject= subject;
		this.email = email;
	}

	public TeacherPojo(Integer id, String name, String subject, String email) {
		this.id = id;
		this.name = name;
		this.subject= subject;
		this.email = email;
	}

	// Getters and Setters
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
