package raisetech.StudentManagement;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StudentsCourses {

  private int id;
  private int studentId;
  private String courseName;
  private String courseStartAt;
  private String courseEndAt;

}
