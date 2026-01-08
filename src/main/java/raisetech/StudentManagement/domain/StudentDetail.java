package raisetech.StudentManagement.domain;

import java.util.List;
import lombok.Getter;
import lombok.Setter;
import raisetech.StudentManagement.data.Student;
import raisetech.StudentManagement.data.StudentCourse;

@Getter
@Setter
public class StudentDetail {

  private Student student; //佐藤花子（１人）
  public List<StudentCourse> studentCourse; //aws、Java（複数）

}
