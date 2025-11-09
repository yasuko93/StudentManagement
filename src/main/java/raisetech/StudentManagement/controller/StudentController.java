package raisetech.StudentManagement.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import raisetech.StudentManagement.controller.converter.StudentConverter;
import raisetech.StudentManagement.data.Students;
import raisetech.StudentManagement.data.StudentsCourses;
import raisetech.StudentManagement.domain.StudentDetail;
import raisetech.StudentManagement.service.StudentService;

@RestController

public class StudentController {

  private StudentService service;
  private StudentConverter converter;

  @Autowired
  public StudentController(StudentService service, StudentConverter converter) {
    this.service = service;
    this.converter = converter;
  }


  @GetMapping("/studentsList")
  public List<StudentDetail> getStudentList() {

    List<Students> students = service.searchStudentList();
    List<StudentsCourses> studentsCourses = service.searchStudentCoursesList();

    return convertStudentDetails(students, studentsCourses);
  }

  private List<StudentDetail> convertStudentDetails(List<Students> students,
      List<StudentsCourses> studentsCourses) {
    List<StudentDetail> studentDetails = new ArrayList<>();
    students.forEach(s -> {
      StudentDetail studentDetail = new StudentDetail();
      studentDetail.setStudents(s);

      List<StudentsCourses> convertStudentCourses = studentsCourses.stream()
          .filter(c -> s.getId() == c.getStudentId())
          .collect(Collectors.toList());

      studentDetail.setStudentsCourses(convertStudentCourses);
      studentDetails.add(studentDetail);
    });
    return studentDetails;
  }

  @GetMapping("/studentsCoursesList")
  public List<StudentsCourses> getStudentCoursesList() {
    return service.searchStudentCoursesList();
  }

}
