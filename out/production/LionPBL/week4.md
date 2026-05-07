# 1. Array와 ArrayList
배열(Array)은 초기에 크기를 반드시 지정해야한다. 
크기가 고정된 프로젝트를 설계하는 경우 배열을 사용해도 문제가 없지만, PBL의 멤버 관리 시스템에서는 몇 명이 등록될지 제한을 두지 않았다.
<br>그러므로 크기가 유동적인 자료구조가 필요한데, 이때 사용되는 것이 ArrayList이다.
<br><br>
제네릭 문법을 사용하며, `ArrayList<Role>`일 경우 Role 타입만 저장이 가능하다는 뜻이 된다.
<br>
### 제네릭을 사용하는 이유
제네릭은 어떤 타입의 데이터를 저장할 것인지를 지정해주는 문법이다.
제네릭을 사용하지 않는다면 어떤 타입이든 저장될 수 있기 때문에 타입 안정성이 떨어진다.
<br><br>
예를 들어 제네릭 없이 리스트를 만들면:
```
ArrayList list = new ArrayList();
```
문자열, 숫자, 객체 등이 모두 섞여 들어갈 수 있다.
```
list.add("hello")
list.add(10)
list.add(new Lion(...));
```
이 경우 데이터를 꺼낼 때 어떤 타입인지 알 수 없어 오류가 발생할 가능성이 커진다.
반면 제네릭을 사용하면 지정한 타입으로만 저장할 수 있으므로 컴파일 단계에서 타입 오류를 방지할 수 있다.

### `List<Role>`이 의미하는 것
위에서 언급했듯 `ArrayList<Role>`은 Role 타입만 저장이 가능하다는 뜻이다.
<br><br>
여기서 `Lion`과 `Staff`가 모두 `Role`을 상속하고 있기 때문에,
<br>부모 타입인 `Role` 리스트 안에 자식 객체들을 함께 저장할 수 있다.
```
// Role 타입으로 제네릭 설정하여 배열리스트 생성
ArrayList<Role> members = new ArrayList<>();

// 추후 roleType이 아기사자일 경우 lion 객체가 생성되지만, Role 리스트 안에 저장된다.
members.add(lion);

// 마찬가지로 운영진 객체를 등록할 경우 리스트가 따로 만들어지는 게 아닌 Role 리스트 안에 저장된다.
members.add(staff);
```
이처럼 하나의 리스트 안에서 서로 다른 객체들을 공통 부모 타입으로 관리할 수 있는 것이 객체지향의 장점이다.
# 2. Map
Map은 key-value 형태로 데이터를 저장하는 컬렉션이다.
<br>4주차 과제에서는 파트별 멤버를 관리하기 위해 사용하였다.
<br><br>
예를 들어:
```
"백엔드" -> [member1, member2]
"프론트엔드" -> [member3]
```
와 같은 형태로 저장된다.
여기서 key는 파트명(String), value는 해당 파트에 속한 멤버 리스트(ArrayList<Role>)이다.
Map은 다음과 같이 생성한다.
```
Map<String, ArrayList<Role>> partMap = new HashMap<>();
```
이번 주차 과제에서 Map과 관련된 메서드로는 `put()`, `get()`, `constainsKey()`, `keySet()`을 중심적으로 사용하였는데,
<br><br>우선 `put()`은 Map에 새로운 key-value 쌍을 저장할 때 사용하고, `get()`은 특정 key에 연결된 value를 가져올 때 사용한다.
<br>`containsKey()`는 특정 key가 이미 존재하는지 확인할 때 사용한다.
```
// 1. partMap에 해당 파트가 이미 있는지 확인
          if (!partMap.containsKey(part)) {
            // 2. 없으면 새 ArrayList 생성
            partMap.put(part, new ArrayList<>());
          }
          // 3. 그 파트의 리스트에 멤버 추가
          partMap.get(part).add(lion);

          System.out.println("아기사자 등록 완료!");
```
과제에서 lion 객체를 추가할 때 입력한 파트를 처리하는 부분을 보면 해당 메서드의 쓰임새를 이해할 수 있다.
<br>마지막으로 `keySet()`은 Map에 저장된 모든 key를 가져오는 메서드이다.
```
else if (menu == 4) {
        System.out.print("\n===== 파트별 조회 =====");
        System.out.print("\n등록된 파트: " + partMap.keySet());

        System.out.print("\n조회할 파트: ");
        String searchPart = sc.nextLine();
```
과제의 파트별 조회 기능에서 등록된 파트를 보여주는 데에 사용되었다.