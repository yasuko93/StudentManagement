package raisetech.StudentManagement;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface StudentsRepository {

  @Select("SELECT * FROM students")
  List<Students> searchStudents(); //nameに合致するstudentsをリストで返す

  @Select("SELECT * FROM students_courses")
  List<StudentsCourses> searchStudentsCourses();
}
