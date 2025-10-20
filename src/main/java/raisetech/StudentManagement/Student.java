package raisetech.StudentManagement;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter //ランボックが自動でゲッターセッターを生成してくれる(下にずらずら書かなくていい)
public class Student {

  private int id;
  private String name;
  private String kanaName;
  private String nickname;
  private String email;
  private String area;
  private int age;
  private String sex;

}
