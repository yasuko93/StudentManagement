package raisetech.StudentManagement.repository;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import raisetech.StudentManagement.data.Student;
import raisetech.StudentManagement.data.StudentCourse;

@Mapper
public interface StudentRepository {

  @Select("SELECT * FROM students")
  List<Student> searchStudent();

  @Select("SELECT * FROM students_courses")
  List<StudentCourse> searchStudentCourse();


  /*
  @Insert("INSERT INTO student VALUES(#{name}, #{age})")
  void registerStudent(String name, int age);

  @Update("UPDATE student SET age = #{age} WHERE name = #{name}")
  void updateStudentAge(String name, int age);

  @Delete("DELETE FROM student WHERE name = #{name}")
  void deleteStudent(String name);

   */
}

