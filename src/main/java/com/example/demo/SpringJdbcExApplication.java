package com.example.demo;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.example.demo.model.Student;
import com.example.demo.service.StudentService;

@SpringBootApplication
public class SpringJdbcExApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(SpringJdbcExApplication.class, args);
		
		Student st = context.getBean(Student.class);
		st.setRoll_no(1);
		st.setName("John");
		st.setMarks(80);
		
		StudentService service = context.getBean(StudentService.class);
		
		service.addStudent(st);
		
		
		List<Student> students = service.getStudents();
		
		System.out.println(students);
	}

}
