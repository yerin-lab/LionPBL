package secondPackage;

import firstPackage.Lion;

public class Step3 {
  public static void main(String[] args) {
    Lion newLion = new Lion("예린", "소프트웨어학과", 14);

    System.out.println("객체가 생성되었습니다!");

    // 1. public 필드 접근
    newLion.name = "차예린";
    System.out.println("name 수정 완료: " + newLion.name);

    // 2. default 필드 접근
    // newLion.major = "컴퓨터공학과";
    // System.out.println("major 수정 완료: " + newLion.major);

    // 3. private 필드 접근 (without getter/setter)
    // newLion.generation = 13;
    // System.out.println("generation 수정 완료: " + newLion.generation);

    // 3. private 필드 접근 (with getter/setter)
    newLion.setGeneration(13);
    System.out.println("generation 수정 완료: " + newLion.getGeneration());
  }
}
