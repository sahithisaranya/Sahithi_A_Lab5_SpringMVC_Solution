package com.greatlearning.lab5.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.greatlearning.lab5.entity.Student;
import com.greatlearning.lab5.service.DebateService;

@Controller
public class DebateController {
	@Autowired
	private DebateService debateService;

	@RequestMapping("/")
	public String testStr(Model m) {
		List<Student> students=debateService.getAllStudents();
		m.addAttribute("Students", students);
		return "allstudents-view";
	}
	
	@RequestMapping("/printAllStudents")
	public String showStudentsForm(Model m) {
		List<Student> students=debateService.getAllStudents();
		m.addAttribute("Students", students);
		return "allstudents-view";
	}
	
	@RequestMapping("/registerStudent")
	public String addNewStudentForm(Model m) {
		Student newStudent=new Student();
		m.addAttribute("Student",newStudent);
		return "student-form-view";
	}
	
	@RequestMapping("/updateStudent")
	public String updateStudentForm(@RequestParam("studentId")int id,Model m) {
		Student student=debateService.findById(id);
		m.addAttribute("Student", student);
		return "student-form-view";
	}
	
	@RequestMapping("/deleteStudent")
	public String deleteStudentFromDebateForm(@RequestParam("studentId")int id) {
		debateService.deleteStudent(id);
		return "redirect:/printAllStudents";
	}
	
	@PostMapping("/save")
	public String saveStudentRegistration(@RequestParam("studentId")int id,
			@RequestParam("name")String _name,
			@RequestParam("department")String _department,
			@RequestParam("country")String _country) {
		
		Student newStudent;
		if(id!=0) {
			newStudent=debateService.findById(id);
			newStudent.setName(_name);
			newStudent.setDepartment(_department);
			newStudent.setCountry(_country);
		}
		else
			newStudent=new Student(_name,_department,_country);
		
		debateService.registerStudent(newStudent);
		return "redirect:/printAllStudents";
	}
	
	
}
