// 추상 클래스 Role: Lion/Staff 각 역할의 공통적인 특징만 추린 클래스.
// 구체적인 객체라기보다는, 역할이라는 개념만 정의한 설계도.
package role;

import policy.SubmitPolicy;

public abstract class Role {

  protected String name;
  protected String major;
  protected int generation;
  protected String part;

  protected SubmitPolicy policy;

  public Role(String name, String major, int generation,
              String part, SubmitPolicy policy) {

    this.name = name;
    this.major = major;
    this.generation = generation;
    this.part = part;
    this.policy = policy;
  }

  public String getName() {
    return name;
  }

  public String getPart() {
    return part;
  }

  public boolean canSubmitAssignment() {
    return policy.canSubmit();
  }

  public abstract void showInfo();
}