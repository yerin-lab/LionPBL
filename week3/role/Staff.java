package role;

import policy.SubmitPolicy;

// 추상화 클래스 Role을 상속받음으로써
// Role 안에 있는 공통 속성과 메서드를 그대로 사용할 수 있다.
public class Staff extends Role {

  private String position;

  public Staff(String name, String major, int generation,
               String part, String position,
               SubmitPolicy policy) {

    super(name, major, generation, part, policy);
    this.position = position;
  }

  @Override
  public void showInfo() {

    System.out.println("이름: " + name);
    System.out.println("전공: " + major);
    System.out.println("기수: " + generation);
    System.out.println("파트: " + part);
    System.out.println("직책: " + position);

    if (canSubmitAssignment()) {
      System.out.println("과제 제출 가능");
    } else {
      System.out.println("과제 제출 불가능");
    }
  }
}