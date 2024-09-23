package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Student;
import com.example.demo.repository.StudentRepo;


@Service
public class StudentService {

	private StudentRepo repo;
	
	public StudentRepo getRepo() {
		return repo;
	}

	@Autowired
	public void setRepo(StudentRepo repo) {
		this.repo = repo;
	}

	public void addStudent(Student st) {
	
		repo.save(st);
	}
	
	public List<Student> getStudents() {
		
		return repo.findAll();
	}
}
