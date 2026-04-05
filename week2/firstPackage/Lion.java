package firstPackage;

public class Lion {
  public String name; // 어디서든 직접 접근 가능
  String major; // default - 같은 패키지 내에서만 직접 접근 가능
  private int generation; // Lion 클래스 내부에서만 직접 접근 가능

    public Lion(String name, String major, int generation) {
      this.name = name;
      this.major = major;
      this.generation = generation;
    }

    public int getGeneration() {
      return generation;
    }

    public void setGeneration(int generation) {
      this.generation = generation;
    }

    public boolean isValid() {
      System.out.println("검증을 시작합니다...🔍");

      boolean isValid = true;

      if (name.isBlank()) {
        System.out.println("⚠️ 이름은 비어있을 수 없습니다.");
        isValid = false;
      }
      if (major.isBlank()) {
        System.out.println("⚠️ 전공이 비어있을 수 없습니다.");
        isValid = false;
      }
      if (generation < 1) {
        System.out.println("⚠️ 기수는 1보다 작을 수 없습니다.");
        isValid = false;
      }

      return isValid;
    }
}