package com.raisetech.StudentManagement.domain;

import com.raisetech.StudentManagement.data.Student;
import com.raisetech.StudentManagement.data.StudentCourse;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StudentDetail {

  private Student student;
  private List<StudentCourse> studentCourses;

}
