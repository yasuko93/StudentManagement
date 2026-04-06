package com.raisetech.StudentManagement.service;

import com.raisetech.StudentManagement.data.Student;
import com.raisetech.StudentManagement.data.StudentCourse;
import com.raisetech.StudentManagement.repository.StudentRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
  private StudentRepository repository;

  @Autowired
  public StudentService(StudentRepository repository) {
    this.repository = repository;
  }

  public List<Student> searchStudentList(){
    List<Student> studentList = new ArrayList<>();
    for (Student s : repository.search()){
      if (s.getAge()>=30){
        studentList.add(s);
      }
    }
    return studentList;
  }

  public List<StudentCourse> searchStudentCourseList(){
    List<StudentCourse> studentCourses = new ArrayList<>();
    for (StudentCourse c : repository.searchCourse()){
      if (c.getCourseName().equals("Java")){
        studentCourses.add(c);
      }
    }
    return  studentCourses;
  }



}
