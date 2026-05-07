package role;

import policy.SubmitPolicy;

public class Lion extends Role {

  private String studentId;

  public Lion(String name, String major, int generation,
              String part, String studentId,
              SubmitPolicy policy) {

    super(name, major, generation, part, policy);
    this.studentId = studentId;
  }

  @Override
  public void showInfo() {

    System.out.println("이름: " + name);
    System.out.println("전공: " + major);
    System.out.println("기수: " + generation);
    System.out.println("파트: " + part);
    System.out.println("학번: " + studentId);

    if (canSubmitAssignment()) {
      System.out.println("과제 제출 가능");
    } else {
      System.out.println("과제 제출 불가능");
    }
  }
}