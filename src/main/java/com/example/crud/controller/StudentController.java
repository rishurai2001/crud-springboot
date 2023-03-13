package com.example.crud.controller;


import java.awt.print.Pageable;
import java.util.List;


import com.example.crud.repo.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.crud.models.Student;
import com.example.crud.service.StudentService;


 

@RestController
public class StudentController {
	@Autowired
	public StudentService studentService;


	@PostMapping("/studentSave")
	public String addStudent(@RequestBody Student student) {
		System.out.print("student");
		studentService.addStudent(student);
		
		return "Data saved successfully";
	}
	
	
	@RequestMapping("/students")
	public List<Student> getAllStudents()
	{
		 
		return studentService.getAllStudents();
		 
	}
	@RequestMapping("/students/{pageNo}")
	public List<Student> getAllStudents(@PathVariable int pageNo)
	{



		return studentService.get5students(pageNo);


	}
	
	@PutMapping("/students/{id}")
	public void updateStudent(@PathVariable Long id, @RequestBody Student student)
	{
		
		
		studentService.updateStudent(id,student);
	 }
	
	@DeleteMapping("/students/{id}")
	public void DeleteStudent(@PathVariable Long id)
	{
		studentService.deleteStudent(id);
		System.out.print("student deleted");
		
	}
}
