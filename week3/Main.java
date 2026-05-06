import java.util.Scanner;

import policy.SubmitPolicy;
import policy.SubmitPolicy;
import policy.LionPolicy;
import policy.StaffPolicy;
import role.Lion;
import role.Staff;
import role.Staff;

public class Main {

  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);

    // 아기사자 정보 입력
    System.out.println("===== 아기사자 정보 입력 =====");

    System.out.print("이름: ");
    String lionName = sc.nextLine();

    System.out.print("전공: ");
    String lionMajor = sc.nextLine();

    System.out.print("기수: ");
    int lionGeneration = sc.nextInt();
    sc.nextLine();

    System.out.print("파트: ");
    String lionPart = sc.nextLine();

    System.out.print("학번: ");
    String studentId = sc.nextLine();

    SubmitPolicy lionPolicy = new LionPolicy();

    Lion lion = new Lion(
          lionName,
          lionMajor,
          lionGeneration,
          lionPart,
          studentId,
          lionPolicy
    );

    System.out.println();


    // -------------------------
    // 운영진 정보 입력
    // -------------------------
    System.out.println("===== 운영진 정보 입력 =====");

    System.out.print("이름: ");
    String staffName = sc.nextLine();

    System.out.print("전공: ");
    String staffMajor = sc.nextLine();

    System.out.print("기수: ");
    int staffGeneration = sc.nextInt();
    sc.nextLine();

    System.out.print("파트: ");
    String staffPart = sc.nextLine();

    System.out.print("직책: ");
    String position = sc.nextLine();

    SubmitPolicy staffPolicy = new StaffPolicy();

    Staff staff = new Staff(
          staffName,
          staffMajor,
          staffGeneration,
          staffPart,
          position,
          staffPolicy
    );

    System.out.println();


    // 역할별 정보 출력
    System.out.println("===== 아기사자 정보 =====");
    lion.showInfo();

    System.out.println();

    System.out.println("===== 운영진 정보 =====");
    staff.showInfo();

    sc.close();
  }
}