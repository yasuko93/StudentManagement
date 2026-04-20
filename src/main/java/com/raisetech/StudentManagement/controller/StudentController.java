package com.raisetech.StudentManagement.controller;

import com.raisetech.StudentManagement.controller.converter.StudentConverter;
import com.raisetech.StudentManagement.data.Student;
import com.raisetech.StudentManagement.data.StudentCourse;
import com.raisetech.StudentManagement.domain.StudentDetail;
import com.raisetech.StudentManagement.service.StudentService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class StudentController {

  private StudentService service;
  private StudentConverter converter;

  @Autowired
  public StudentController(StudentService service, StudentConverter converter) {
    this.service = service;
    this.converter = converter;
  }

  @GetMapping("/studentList")
  public List<StudentDetail> getStudentDetail(){
    List<Student> students = service.searchStudentList();
    List<StudentCourse> studentCourses = service.searchStudentCourseList();

    return converter.convertStudentDetails(
        students, studentCourses);
  }



  @GetMapping("/studentCourseList")
  public List<StudentCourse> getStudentCourseList(){
    return service.searchStudentCourseList();
  }

}
