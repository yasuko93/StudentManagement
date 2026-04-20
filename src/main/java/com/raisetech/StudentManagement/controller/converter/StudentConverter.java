package com.raisetech.StudentManagement.controller.converter;

import com.raisetech.StudentManagement.data.Student;
import com.raisetech.StudentManagement.data.StudentCourse;
import com.raisetech.StudentManagement.domain.StudentDetail;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public class StudentConverter {

  public List<StudentDetail> convertStudentDetails(List<Student> students,
      List<StudentCourse> studentCourses) {
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

}
