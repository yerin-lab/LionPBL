package package2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import role.Role;
import role.Lion;
import role.Staff;

import policy.LionPolicy;
import policy.StaffPolicy;

public class Main {

  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);
    ArrayList<Role> members = new ArrayList<>();
    Map<String, ArrayList<Role>> partMap = new HashMap<>();

    while (true) {
      System.out.println("\n===== 멋사 멤버 관리 시스템 =====");
      System.out.println("1. 멤버 등록");
      System.out.println("2. 전체 멤버 조회");
      System.out.println("3. 이름으로 검색");
      System.out.println("4. 파트별 조회");
      System.out.println("0. 종료");
      System.out.print("메뉴 선택: ");

      int menu = sc.nextInt();
      sc.nextLine();

      if (menu == 1) {
        System.out.print("역할 선택 (1. 아기사자 / 2. 운영진): ");
        int roleType = sc.nextInt();
        sc.nextLine();

        System.out.print("이름: ");
        String name = sc.nextLine();

        boolean isDuplicate = false;

        // for-each문: members 리스트 안의 Role 객체들을 하나씩 꺼내서 member 변수에 저장하며 반복한다.
        for (Role member : members) {
          if (member.getName().equals(name)) {
            isDuplicate = true;
            break;
          }
        }

        if (isDuplicate) {
          System.out.println("이미 등록된 이름입니다. 등록 실패!");
          continue;
        }

        System.out.print("전공: ");
        String major = sc.nextLine();

        System.out.print("기수: ");
        int generation = sc.nextInt();
        sc.nextLine();

        System.out.print("파트: ");
        String part = sc.nextLine();

        if (roleType == 1) {
          System.out.print("학번: ");
          String studentId = sc.nextLine();

          Role lion = new Lion(
                name, major, generation, part, studentId,
                new LionPolicy()
          );

          members.add(lion);

          // 1. partMap에 해당 파트가 이미 있는지 확인
          if (!partMap.containsKey(part)) {
            // 2. 없으면 새 ArrayList 생성
            partMap.put(part, new ArrayList<>());
          }
          // 3. 그 파트의 리스트에 멤버 추가
          partMap.get(part).add(lion);

          System.out.println("아기사자 등록 완료!");

        } else if (roleType == 2) {
          System.out.print("직책: ");
          String position = sc.nextLine();

          Role staff = new Staff(
                name, major, generation, part, position,
                new StaffPolicy()
          );

          members.add(staff);

          // 1. partMap에 해당 파트가 이미 있는지 확인
          if (!partMap.containsKey(part)) {
            // 2. 없으면 새 ArrayList 생성
            partMap.put(part, new ArrayList<>());
          }
          // 3. 그 파트의 리스트에 멤버 추가
          partMap.get(part).add(staff);

          System.out.println("운영진 등록 완료!");

        } else {
          System.out.println("잘못된 역할 선택입니다.");
        }

      } else if (menu == 2) {
        if (members.isEmpty()) {
          System.out.println("등록된 멤버가 없습니다.");
        } else {
          System.out.println("\n===== 전체 멤버 조회 =====");

          for (Role member : members) {
            member.showInfo();
            System.out.println("--------------------");
          }
        }

      } else if (menu == 3) {
        System.out.print("검색할 이름: ");
        String searchName = sc.nextLine();

        boolean found = false;

        for (Role member : members) {
          if (member.getName().equals(searchName)) {
            member.showInfo();
            found = true;
          }
        }

        if (!found) {
          System.out.println("해당 이름의 멤버를 찾을 수 없습니다.");
        }

      } else if (menu == 4) {
        System.out.print("\n===== 파트별 조회 =====");
        System.out.print("\n등록된 파트: " + partMap.keySet());

        System.out.print("\n조회할 파트: ");
        String searchPart = sc.nextLine();

        if (partMap.containsKey(searchPart)) {
          System.out.println("\n===== " + searchPart + " 파트 멤버 목록 =====");

          for (Role member : partMap.get(searchPart)) {
            member.showInfo();
            System.out.println("--------------------");
          }
        } else {
          System.out.println("해당 파트에 속한 멤버가 없습니다.");
        }

      } else if (menu == 0) {
        System.out.println("프로그램을 종료합니다.");
        break;

      } else {
        System.out.println("잘못된 메뉴 선택입니다.");
      }
    }

    sc.close();
  }
}