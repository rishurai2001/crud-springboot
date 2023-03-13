package com.example.crud.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.crud.models.Student;

public interface StudentRepo extends JpaRepository<Student, Long> {

}
