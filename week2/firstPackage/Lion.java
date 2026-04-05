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

    public void setGeneration() {
      this.generation = generation;
    }
}