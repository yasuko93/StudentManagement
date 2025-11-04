package raisetech.StudentManagement.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import raisetech.StudentManagement.data.Students;
import raisetech.StudentManagement.data.StudentsCourses;
import raisetech.StudentManagement.service.StudentService;

@RestController

public class StudentController {

  private StudentService service;

  @Autowired
  public StudentController(StudentService service) {
    this.service = service;
  }


  @GetMapping("/studentsList")
  public List<Students> getStudentList() {
    return service.searchStudentList();
  }

  @GetMapping("/studentsCoursesList")
  public List<StudentsCourses> getStudentCoursesList() {
    return service.searchStudentCoursesList();
  }

}
