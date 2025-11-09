package raisetech.StudentManagement.domain;

import java.util.List;
import lombok.Getter;
import lombok.Setter;
import raisetech.StudentManagement.data.Students;
import raisetech.StudentManagement.data.StudentsCourses;

@Getter
@Setter
public class StudentDetail {
  private Students students;
  private List<StudentsCourses> studentsCourses; //単一の生徒に対し、コースは複数
}
