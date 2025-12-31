package raisetech.StudentManagement;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class StudentManagementApplication {

	@Autowired
	private StudentRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(StudentManagementApplication.class, args);
	}

	@GetMapping("/studentList")
	public List<Student> getStudentList(){
		return repository.searchStudent();
	}

	@GetMapping("/studentCourseList")
	public List<StudentCourse> getStudentCourseList(){
		return repository.searchStudentCourse();
	}




	/*
	@PostMapping("/student")
	public void registerStudent(String name,int age){
		repository.registerStudent(name, age);
	}

	@PatchMapping("/student")
	public void updateStudentAge(String name, int age){
		repository.updateStudentAge(name, age);
	}

	@DeleteMapping("/student")
	public void deleteStudent(String name){
		repository.deleteStudent(name);
	}

	 */



}
