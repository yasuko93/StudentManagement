package raisetech.StudentManagement.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import raisetech.StudentManagement.data.Students;
import raisetech.StudentManagement.data.StudentsCourses;
import raisetech.StudentManagement.repository.StudentsRepository;

//Serviceがrepositoryを呼び出す

@Service
public class StudentService {

  private StudentsRepository repository;

  @Autowired
  public StudentService(StudentsRepository repository) {
    this.repository = repository;
  }

  //controllerに書いていたメソッドを移動（責務を分ける）

  public List<Students> searchStudentList() {

    List<Students> filterStudentList = repository.searchStudents();

    List<Students> ageFilterList = new ArrayList<>();

    for (Students s : filterStudentList){
      if (s.getAge() >= 30 && s.getAge() <40){
        ageFilterList.add(s);
      }
    }
    return ageFilterList;
  }

  public List<StudentsCourses> searchStudentCoursesList() {
    return repository.searchStudentsCourses();
  }
}
