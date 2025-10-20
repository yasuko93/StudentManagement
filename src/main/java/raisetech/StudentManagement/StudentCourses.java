package raisetech.StudentManagement;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StudentCourses {

  private int id;
  private int studentId;
  private String course;
  private String startDatetime;
  private String completionDatetime;



}
