package com.greatlearning.lab5.service;

import java.util.List;

import com.greatlearning.lab5.entity.Student;

public interface DebateService {
	public List<Student> getAllStudents();
	//public Student getStudentById(int stuId);
	public void registerStudent(Student newStudent);
	public void deleteStudent(int stuId);
	public void updateStudent(Student theStudent);
	public Student findById(int theId);
}
