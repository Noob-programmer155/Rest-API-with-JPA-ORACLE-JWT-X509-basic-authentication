package com.amrTm.restApiJpaJwtX509Authentication.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="Student")
public class Student {
	@Id
	@NotNull
	@GeneratedValue
	private Long id;
	@NotBlank(message="first name must be included")
	private String first;
	@NotBlank(message="last name must be included")
	private String last;
	@Enumerated
	@NotNull(message="gender must be included")
	private GenderType gender;
	@NotBlank(message="email must be included")
//	@Email(message="Must be a valid email", regexp="{email}")
	private String email;
	@NotBlank(message="student code must be included")
	private String studentCode;
	@ManyToMany(mappedBy="studentLesson")
	private Set<StudentLesson> studentLes;
	@ManyToMany(mappedBy="studentArrive")
	private Set<ArrivalStudent> studentArr;
	@ManyToMany(mappedBy="students")
	private Set<Teacher> teachers;
	public Student() {
		super();
		this.studentLes = new HashSet<>();
		this.studentArr = new HashSet<>();
		this.teachers = new HashSet<>();
		// TODO Auto-generated constructor stub
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getFirst() {
		return first;
	}
	public void setFirst(String first) {
		this.first = first;
	}
	public String getLast() {
		return last;
	}
	public void setLast(String last) {
		this.last = last;
	}
	public GenderType getGender() {
		return gender;
	}
	public void setGender(GenderType gender) {
		this.gender = gender;
	}
	public String getStudentCode() {
		return studentCode;
	}
	public void setStudentCode(String studentCode) {
		this.studentCode = studentCode;
	}
	public Set<Teacher> getTeachers() {
		return teachers;
	}
//	public void addTeacher(Teacher teachers) {
//		if(this.teachers.contains(teachers)) {return ;}
//		this.teachers.add(teachers);
//		teachers.addStudents(this);
//	}
//	public void removeTeacher(Teacher teachers) {
//		if(!this.teachers.contains(teachers)) {return ;}
//		this.teachers.remove(teachers);
//		teachers.removeStudents(this);
//	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Set<StudentLesson> getStudentsLesson() {
		return studentLes;
	}
//	public void addLesson(Lesson lesson) {
//		if(this.studentsLesson.contains(lesson)) {return ;}
//		this.studentsLesson.add(lesson);
//		lesson.addLesson(this);
//	}
//	public void removeLesson(Lesson lesson) {
//		if(!this.studentsLesson.contains(lesson)) {return ;}
//		this.studentsLesson.remove(lesson);
//		lesson.removeLesson(this);
//	}
	public Set<ArrivalStudent> getStudentsArrive() {
		return studentArr;
	}
//	public void addArrive(ArrivalStudent arrive) {
//		if(this.studentArr.contains(arrive)) {return ;}
//		this.studentArr.add(arrive);
//		arrive.addArrive(this);
//	}
//	public void removeArrive(ArrivalStudent arrive) {
//		if(!this.studentArr.contains(arrive)) {return ;}
//		this.studentArr.remove(arrive);
//		arrive.removeArrive(this);
//	}
	public void setStudentsLesson(Set<StudentLesson> studentsLesson) {
		this.studentLes = studentsLesson;
	}
	public void setStudentsArrive(Set<ArrivalStudent> studentsArrive) {
		this.studentArr = studentsArrive;
	}
	public void setTeachers(Set<Teacher> teachers) {
		this.teachers = teachers;
	}
}