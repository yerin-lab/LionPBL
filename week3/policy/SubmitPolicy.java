package policy;

// Interface: 무엇을 해야 하는지만 정의하고, 어떻게 하는지는 구현 클래스에게 맡김.
// 과제 제출 가능 여부를 판단하는 규칙만 정의해둔 것.
public interface SubmitPolicy {

  // 메서드 선언만 존재하고 실제 내용은 없다.
  // LionPolicy, StaffPolicy에서 해당 함수를 오버라이딩하여 어떻게 하는지를 정의한다.
  boolean canSubmit();
}