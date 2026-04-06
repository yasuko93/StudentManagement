package com.raisetech.StudentManagement;

import com.raisetech.StudentManagement.data.Student;
import com.raisetech.StudentManagement.data.StudentCourse;
import com.raisetech.StudentManagement.repository.StudentRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication

public class StudentManagementApplication {


		public static void main(String[] args) {
		SpringApplication.run(StudentManagementApplication.class, args);
	}


}
