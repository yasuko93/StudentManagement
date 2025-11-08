package raisetech.StudentManagement.controller;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import raisetech.StudentManagement.data.Students;
import raisetech.StudentManagement.data.StudentsCourses;
import raisetech.StudentManagement.domain.StudentDetail;
import raisetech.StudentManagement.service.StudentService;

@RestController

public class StudentController {

  private StudentService service;

  @Autowired
  public StudentController(StudentService service) {
    this.service = service;
  }


  @GetMapping("/studentsList")
  public List<StudentDetail> getStudentList() {

    List<Students> students = service.searchStudentList(); //②Serviceから取れたリストをstudentsに入れる
    List<StudentsCourses> studentsCourses = service.searchStudentCoursesList(); //⑥Serviceから取れたリストをstudentsCoursesに入れる
    List<StudentDetail> studentDetails = new ArrayList<>(); //①ループの結果を入れるリストを準備

    for (Students s : students){ //③studentsを全件ループで回す（まず1人目の「田中太郎」がsに入ってくる）
      StudentDetail studentDetail = new StudentDetail(); //④studentDetailのインスタンスを生成
      studentDetail.setStudents(s); //⑤studentDetailにStudentsを順に設定（「田中太郎」～）

      List<StudentsCourses> convertStudentCourses = new ArrayList<>(); //⑦ループ（⑧）の結果を入れるリストを準備
      for (StudentsCourses c : studentsCourses){ //⑧studentsCoursesを全件ループで回す（ループの中でループ）
        if (s.getId() == c.getStudentId()){
          convertStudentCourses.add(c); //⑨受講生idと一致するコース情報（1:N）を⑦で用意したリストに順に追加
        }
      }

      studentDetail.setStudentsCourses(convertStudentCourses); //⑩studentDetailにコース⑨を設定）
      studentDetails.add(studentDetail); //⑪リスト①に、Students⑤とコースリスト⑩の入ったstudentDetailを追加
    }
    return studentDetails;
  }

  @GetMapping("/studentsCoursesList")
  public List<StudentsCourses> getStudentCoursesList() {
    return service.searchStudentCoursesList();
  }

}
