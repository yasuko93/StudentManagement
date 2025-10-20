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
	@Autowired
	private StudentCoursesRepository repository2;


	private String name;
	private String age;

	public static void main(String[] args) {
		SpringApplication.run(StudentManagementApplication.class, args);
	}

	@GetMapping("/studentList")
	public List<Student> getStudentList(){
	return repository.search();
	}

	@GetMapping("/studentCourses")
	public String getStudentCourses(){
		StudentCourses studentCourses = repository2.searchById(6);
		return studentCourses.getCourse();
	}
}
