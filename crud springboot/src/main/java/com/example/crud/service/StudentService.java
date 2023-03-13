package com.example.crud.service;

import java.awt.print.Pageable;
import java.util.ArrayList;
import java.util.List;

import com.example.crud.repo.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.example.crud.models.Student;

@Service
public class StudentService {
	@Autowired
	public StudentRepo studentRepo;
	H8hj@#fgKO3
	public List<Student> getAllStudents() {
		
	    List<Student> students = new ArrayList<>();
		System.out.println("printing all students List");
	    studentRepo.findAll()
	    .forEach(students::add);
		
	    return students;		
	}
	public void addStudent(Student student) {
	     studentRepo.save(student);
	}
	
	public Student getStudent(Long id) {
	     return studentRepo.findById(id).orElse(null);
	}
	public void updateStudent(Long id, Student student) {
		
	 
		Student existingStudent = getStudent(id);
        existingStudent.setStudentName(student.getStudentName());
         
        studentRepo.save(existingStudent);
	      
	}
	public List<Student> get5students(int pageNo){
		PageRequest paging = PageRequest.of(pageNo,5);
		Page<Student> pagedResult = studentRepo.findAll( paging);
		return pagedResult.toList();

	}
	public void deleteStudent(Long id) {
	     studentRepo.deleteById(id);
	}
}
