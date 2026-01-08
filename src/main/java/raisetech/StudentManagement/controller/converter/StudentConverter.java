package raisetech.StudentManagement.controller.converter;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;
import raisetech.StudentManagement.data.Student;
import raisetech.StudentManagement.data.StudentCourse;
import raisetech.StudentManagement.domain.StudentDetail;

@Component
public class StudentConverter {
  public List<StudentDetail> convertStudentDetails(List<Student> students,
      List<StudentCourse> studentCourses) {
    List<StudentDetail> studentDetailList = new ArrayList<>();

    for (Student stu : students){
      StudentDetail studentDetail = new StudentDetail();
      studentDetail.setStudent(stu);

      List<StudentCourse> convertCourses = new ArrayList<>();

      for (StudentCourse course : studentCourses){
        if (course.getStudentId()==stu.getId()){
          convertCourses.add(course);
          studentDetail.setStudentCourse(convertCourses);
        }
      }
      studentDetailList.add(studentDetail);
    }
    return studentDetailList;
  }


}
