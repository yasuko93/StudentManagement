package raisetech.StudentManagement.controller;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import raisetech.StudentManagement.controller.converter.StudentConverter;
import raisetech.StudentManagement.data.Student;
import raisetech.StudentManagement.data.StudentCourse;
import raisetech.StudentManagement.domain.StudentDetail;
import raisetech.StudentManagement.service.StudentService;

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
  public String getStudentList(Model model){ //①戻り値をStringに　②Springからmodel（View用の入れ物）をもらう

  List<Student> students = service.searchStudentList();
  List<StudentCourse> studentCourses = service.searchStudentCourseList();

  //③modelにView用のデータを書き込む（「変数htmlStudentList（中身：studentDetailList）を定義します」）
  model.addAttribute("htmlStudentList", converter.convertStudentDetails(students, studentCourses));
  return "studentList"; //④SpringにView名（studentList.html）を返す
  }



  @GetMapping("/studentCourseList")
  public List<StudentCourse> getStudentCourseList(){
    return service.searchStudentCourseList();
  }

}
