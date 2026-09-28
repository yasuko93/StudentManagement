package raisetech.StudentManagement.controller.converter;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;
import raisetech.StudentManagement.data.Student;
import raisetech.StudentManagement.data.StudentsCourses;
import raisetech.StudentManagement.domain.StudentDetail;

@Component
public class StudentConverter {
  public List<StudentDetail> convertStudentDetails(List<Student> students,
      List<StudentsCourses> studentsCourses) {
    List<StudentDetail> studentDetailList = new ArrayList<>();

    for (Student s : students){
      StudentDetail studentDetail = new StudentDetail();
      studentDetail.setStudent(s); //studentDetailに1人目のstudentを設定

      List<StudentsCourses> eachStudentsCoursesList = new ArrayList<>();
      for(StudentsCourses c : studentsCourses){
        if(s.getId()==c.getStudentId()){
          eachStudentsCoursesList.add(c); //コースリストに1人目のコース全てが順番に入ってくる
        }
      }
      studentDetail.setStudentsCourses(eachStudentsCoursesList); //studentDetailに1人目のコースリストを設定
      studentDetailList.add(studentDetail); //studentDetailリストに1人目のstudentDetailを追加
    }
    return studentDetailList;
  }

}
