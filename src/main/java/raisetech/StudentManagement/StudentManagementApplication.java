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
  private StudentsRepository studentsRepository;
  @Autowired
  private StudentsCoursesRepository studentsCoursesRepository;



  public static void main(String[] args) {
    SpringApplication.run(StudentManagementApplication.class, args);
  }

  @GetMapping("/studentsList")
  public List<Students> getStudentList() {
    return studentsRepository.searchStudents();
  }

  @GetMapping("/studentsCoursesList")
  public List<StudentsCourses> getStudentCoursesList() {
    return studentsCoursesRepository.searchStudentsCourses();
  }
}
