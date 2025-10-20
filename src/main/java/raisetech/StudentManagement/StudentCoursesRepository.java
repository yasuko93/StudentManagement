package raisetech.StudentManagement;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface StudentCoursesRepository {

  @Select("SELECT * FROM students_courses WHERE id =#{id}")
  StudentCourses searchById(int id);

}
