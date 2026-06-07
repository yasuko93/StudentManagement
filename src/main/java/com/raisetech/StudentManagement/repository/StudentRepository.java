package com.raisetech.StudentManagement.repository;

import com.raisetech.StudentManagement.data.Student;
import com.raisetech.StudentManagement.data.StudentCourse;
import com.raisetech.StudentManagement.domain.StudentDetail;
import java.util.List;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface StudentRepository {

  @Select("SELECT * FROM students")
  List<Student> search();

  @Select("SELECT * FROM students_courses")
  List<StudentCourse> searchCourse();

  @Insert("INSERT INTO students(id,name,kana_name,nickname,email,area,age,sex,remark,is_deleted) VALUES(#{student.id}, #{student.name}, #{student.kanaName}, #{student.nickname}, #{student.email}, #{student.area}, #{student.age}, #{student.sex}, #{student.remark}, #{student.deleted})")
  void register(StudentDetail studentDetail);

}
