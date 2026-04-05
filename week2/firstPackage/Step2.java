package firstPackage;

import java.util.Scanner;

public class Step2 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    // 입력
    System.out.println("🦁 안녕하세요, 아기사자님!");

    System.out.println("1. 아기사자님의 이름을 입력해주세요.");
    String name = sc.nextLine();
    System.out.println("2. 아기사자님의 전공을 입력해주세요.");
    String major = sc.nextLine();
    System.out.println("3. 마지막으로 아기사자님의 활동 기수를 입력해주세요.");
    int generation = sc.nextInt();

    System.out.println("입력이 완료되었습니다!");

    Lion newLion = new Lion(name, major, generation);

    if (newLion.isValid()) {
      System.out.println("유효성 검사를 통과하였습니다!");
      System.out.println("🥳 아기사자 객체가 생성되었습니다!");

      // 출력
      System.out.println("🦁 아기사자 정보를 출력합니다.");
      System.out.println("이름: " + newLion.name);
      System.out.println("전공: " + newLion.major);
      System.out.println("기수: " + newLion.getGeneration());
    }
    else {
      // issue: 이미 객체가 생성된 상황.
      // 유효하지 않은 부분만 setter 함수 써서 다시 입력을 받을까?
      System.out.println("❌ 유효하지 않은 입력입니다.");
    }
  }
}
