package com.raisetech.StudentManagement.controller;

import com.raisetech.StudentManagement.controller.converter.StudentConverter;
import com.raisetech.StudentManagement.data.Student;
import com.raisetech.StudentManagement.data.StudentCourse;
import com.raisetech.StudentManagement.domain.StudentDetail;
import com.raisetech.StudentManagement.service.StudentService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller

public class StudentController {

  private StudentService service;
  private StudentConverter converter;

  @Autowired
  public StudentController(StudentService service, StudentConverter converter) {
    this.service = service;
    this.converter = converter;
  }

  @GetMapping("/studentList")
  public String getStudentList(Model model){ //①戻り値を文字列に　②model（HTMLとControllerの間にいるヤツ）を受け取る
    List<Student> students = service.searchStudentList();
    List<StudentCourse> studentCourses = service.searchStudentCourseList();

    model.addAttribute
        ("studentList",converter.convertStudentDetails(
        students, studentCourses)); //③「HTMLの${studentList}イコール"converter.~略"ですよ」と定義
    return "studentList"; //④HTMLファイルを返却
  }



  @GetMapping("/studentCourseList")
  public List<StudentCourse> getStudentCourseList(){
    return service.searchStudentCourseList();
  }

}
