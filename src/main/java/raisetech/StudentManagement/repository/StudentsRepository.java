package raisetech.StudentManagement.repository;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import raisetech.StudentManagement.data.Students;
import raisetech.StudentManagement.data.StudentsCourses;

@Mapper
public interface StudentsRepository {

  @Select("SELECT * FROM students")
  List<Students> searchStudents(); //nameに合致するstudentsをリストで返す

  @Select("SELECT * FROM students_courses")
  List<StudentsCourses> searchStudentsCourses();
}
