package com.raisetech.StudentManagement.controller;

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

  @Autowired
  public StudentController(StudentService service) {
    this.service = service;
  }

  @GetMapping("/studentList")
  public List<StudentDetail> getStudentDetail(){
    List<Student> students = service.searchStudentList();
    List<StudentCourse> studentCourses = service.searchStudentCourseList();

    List<StudentDetail> studentDetailList = new ArrayList<>();

    //studentの１人目スタート
    for (Student student : students){

      //studentDetailListのstudentに１人目セット
      StudentDetail studentDetail = new StudentDetail();
      studentDetail.setStudent(student);

      List<StudentCourse> eachStudentCourses = new ArrayList<>();

      //student１人目の、studentCourseスタート
        for (StudentCourse studentCourse : studentCourses){
        if (studentCourse.getStudentId().equals(student.getId())){
          eachStudentCourses.add(studentCourse);
        }
        // student１人目の、studentCourseのループ終わり⇒student２人目へ
      }

      //student５人目まで見たところでループ終了

      studentDetail.setStudentCourses(eachStudentCourses);
      studentDetailList.add(studentDetail);
    }

    return studentDetailList;
  }

  @GetMapping("/studentCourseList")
  public List<StudentCourse> getStudentCourseList(){
    return service.searchStudentCourseList();
  }

}
