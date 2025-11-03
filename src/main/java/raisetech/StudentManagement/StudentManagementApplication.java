package raisetech.StudentManagement;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import raisetech.StudentManagement.data.Students;
import raisetech.StudentManagement.data.StudentsCourses;
import raisetech.StudentManagement.repository.StudentsRepository;

@SpringBootApplication
@RestController
public class StudentManagementApplication {

  @Autowired
  private StudentsRepository studentsRepository;

  public static void main(String[] args) {
    SpringApplication.run(StudentManagementApplication.class, args);
  }

  @GetMapping("/studentsList")
  public List<Students> getStudentList() {
    return studentsRepository.searchStudents();
  }

  @GetMapping("/studentsCoursesList")
  public List<StudentsCourses> getStudentCoursesList() {
    return studentsRepository.searchStudentsCourses();
  }
}
