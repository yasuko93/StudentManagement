package raisetech.StudentManagement.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import raisetech.StudentManagement.data.Student;
import raisetech.StudentManagement.data.StudentCourse;
import raisetech.StudentManagement.repository.StudentRepository;

@Service
public class StudentService {

  private StudentRepository repository; //空の箱

  @Autowired //Springさん、ここを経由してね
  public StudentService(StudentRepository repository) { //Repositoryの実体1人を受け取る
    this.repository = repository; //受け取った実体を箱に入れる
  }

  public List<Student> searchStudentList(){
    return repository.searchStudent();
  }

  public List<StudentCourse> searchStudentCourseList(){
    return repository.searchStudentCourse();
  }
}
