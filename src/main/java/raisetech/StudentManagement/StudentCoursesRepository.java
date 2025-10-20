package raisetech.StudentManagement;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface StudentCoursesRepository {

  @Select("SELECT * FROM students_courses WHERE id = #{id}")
  List<StudentCourses> searchById(int id);

}
