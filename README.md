# 🎭 공연 관리 시스템

MVC(Model-View-Controller) 구조를 적용하여 공연 정보를 등록, 조회, 수정, 삭제할 수 있도록 구현한 Java 프로젝트입니다.
# ✅ 필수 요구사항 구현

본 프로젝트는 다음 필수 요구사항을 기준으로 구현하였습니다.

| 번호 | 필수 요구사항 | 구현 내용 | 관련 클래스 및 메서드 |
|:---:|---|---|---|
| 1 | 콘솔 메뉴 반복 및 정상 종료 | `while` 반복문으로 메인 메뉴를 출력하고 `9`를 선택하면 종료 | `PerfController.run()` |
| 2 | 데이터를 표현하는 Model 클래스 | 공연 정보를 저장하는 `Performance` 클래스 구현 | `Performance` |
| 3 | 컬렉션을 이용한 데이터 관리 | `List<Performance>`를 이용하여 여러 공연 관리 | `PerfRepository` |
| 4 | CRUD 기능 구현 | 공연 등록, 조회, 수정, 삭제 기능 구현 | `save()`, `findAll()`, `update()`, `deleteById()` |
| 5 | Enum 사용 | 공연 카테고리를 `Category` Enum으로 관리 | `Category` |
| 6 | Stream API 검색·필터 2개 이상 | 공연번호, 카테고리, 제목을 기준으로 검색 | `findById()`, `findAllByCategory()`, `findByTitle()` |
| 7 | 역할별 클래스 분리 | 화면 출력, 흐름 제어, 데이터 처리, Model의 역할 분리 | `PerfView`, `PerfController`, `PerfRepository`, `Performance` |
| 8 | 잘못된 입력 예외 처리 | 문자 및 존재하지 않는 공연번호를 입력해도 프로그램이 종료되지 않도록 처리 | `try-catch`, `null` 확인, 범위 검사 |

---

# 🏗 프로젝트 구조

```text
src/main/java
├── Application.java
└── com/ohgiraffers/perfmanagementsystem
    ├── controller
    │   └── PerfController.java
    ├── model
    │   ├── Performance.java
    │   └── Category.java
    ├── repository
    │   └── PerfRepository.java
    └── view
        └── PerfView.java
```

## 클래스별 역할

| 클래스 | 역할 |
|---|---|
| `Application` | 필요한 객체를 생성하고 프로그램 실행 |
| `Performance` | 공연 정보를 저장하는 Model |
| `Category` | 공연 카테고리를 정해진 값으로 관리하는 Enum |
| `PerfRepository` | `List`를 이용한 공연 데이터 저장 및 CRUD 처리 |
| `PerfController` | 메뉴 선택과 프로그램 흐름 제어 |
| `PerfView` | 사용자 입력 및 콘솔 출력 |

---

# 🎭 공연 정보

`Performance` 클래스는 다음 공연 정보를 관리합니다.

| 공연 정보 | 변수명 | 자료형 |
|---|---|---|
| 공연번호 | `performanceId` | `int` |
| 제목 | `title` | `String` |
| 카테고리 | `category` | `Category` |
| 공연 기간 | `period` | `String` |
| 공연 장소 | `place` | `String` |
| 관람시간 | `runningTime` | `int` |
| 인터미션 | `intermissionTime` | `int` |
| 관람등급 | `ageRating` | `String` |
| 가격 | `price` | `int` |

모든 필드는 `private`으로 선언하고 필요한 값은 Getter와 Setter를 통해 접근하도록 구현하였습니다.

#### 🔒 공연번호 변경 제한

공연번호인 `performanceId`는 각 공연을 구분하는 고유한 식별값으로,
공연이 등록된 이후 공연번호가 임의로 변경되지 않도록 `Getter`만 제공하고 `Setter`는 작성하지 않았습니다.


---

# 🗂 카테고리 Enum

공연 카테고리는 `Category` Enum으로 관리합니다.

- 카테고리 (`category`, `Category`)
    - 뮤지컬 (`MUSICAL`)
    - 콘서트 (`CONCERT`)
    - 연극 (`PLAY`)
    - 클래식·무용 (`CLASSICAL_DANCE`)
    - 아동·가족 (`KIDS_FAMILY`)
    - 전시 (`EXHIBITION`)

각 Enum 상수는 화면 출력에 사용할 한글 설명인 `description`을 가지고 있습니다.

---

# 🚀 주요 기능

## 📖 공연 조회 (Read)

다음 조건으로 공연을 조회할 수 있습니다.

- 전체 공연 조회
- 카테고리별 조회
- 공연 제목 검색
- 공연번호 조회

조회 결과가 없거나 존재하지 않는 공연번호를 입력하면 안내 메시지를 출력하고 프로그램을 계속 실행합니다.

## ➕ 공연 등록 (Create)

다음 공연 정보를 입력받아 Repository에 저장합니다.

- 제목 (`title`)
- 카테고리 (`category`)
- 공연 기간 (`period`)
- 공연 장소 (`place`)
- 관람시간 (`runningTime`)
- 인터미션 (`intermissionTime`)
- 관람등급 (`ageRating`)
- 가격 (`price`)

공연번호인 `performanceId`는 사용자가 입력하지 않습니다.

Repository에서 기존 공연번호와 중복되지 않는 `100000~999999` 범위의 6자리 번호를 자동으로 생성합니다.

## ✏ 공연 수정 (Update)

수정할 공연번호를 입력하면 기존 공연 정보를 먼저 출력합니다.

공연번호는 고유 식별값이므로 유지하고, 나머지 공연 정보를 새로 입력받아 Repository의 기존 공연과 교체합니다.

존재하지 않는 공연번호를 입력하면 수정하지 않고 안내 메시지를 출력합니다.

## ❌ 공연 삭제 (Delete)

삭제할 공연번호를 입력하면 삭제 대상 공연 정보를 출력합니다.

실수로 삭제하는 것을 방지하기 위해 `Y/N` 확인 과정을 거치며, `Y`를 입력한 경우에만 삭제합니다.

---

# 🔍 Stream API 활용

Repository의 검색 및 필터 기능에 Stream API를 사용하였습니다.

| 기능 | Repository 메서드 | 사용 기능 |
|---|---|---|
| 공연번호 조회 | `findById()` | `filter()`, `findFirst()` |
| 카테고리별 조회 | `findAllByCategory()` | `filter()`, `collect()` |
| 제목 검색 | `findByTitle()` | `filter()`, `contains()`, `collect()` |

## 공연번호 검색

공연번호가 일치하는 첫 번째 공연을 반환합니다. 일치하는 공연이 없으면 `null`을 반환합니다.

```java
performanceList.stream()
        .filter(performance ->
                performance.getPerformanceId() == performanceId)
        .findFirst()
        .orElse(null);
```

## 카테고리 필터링

선택한 카테고리와 일치하는 공연을 새로운 목록으로 반환합니다.

```java
performanceList.stream()
        .filter(performance ->
                performance.getCategory().equals(category))
        .collect(Collectors.toList());
```

## 제목 검색

입력한 검색어가 제목에 포함된 공연을 대소문자 구분 없이 조회합니다.

```java
performanceList.stream()
        .filter(performance ->
                performance.getTitle()
                        .toLowerCase()
                        .contains(titleKeyword))
        .collect(Collectors.toList());
```

---

# ✅ 입력값 검증 및 예외 처리

잘못된 입력으로 프로그램이 종료되지 않도록 다음과 같이 처리하였습니다.

| 입력 상황 | 처리 방법 |
|---|---|
| 숫자 입력란에 문자 입력 | `NumberFormatException` 처리 후 재입력 |
| 존재하지 않는 공연번호 입력 | 조회 결과의 `null` 여부 확인 |
| 잘못된 카테고리 번호 입력 | `1~6` 범위 검사 후 재입력 |
| 관람시간에 0 이하의 값 입력 | 1 이상의 숫자를 입력하도록 안내 |
| 인터미션에 음수 입력 | 0 이상의 숫자를 입력하도록 안내 |
| 가격에 0 이하의 값 입력 | 1 이상의 숫자를 입력하도록 안내 |
| 삭제 확인에 Y/N 이외의 값 입력 | Y 또는 N을 다시 입력하도록 안내 |

## 잘못된 숫자 입력 예시

```text
메뉴 번호를 입력하세요 : 공연
숫자만 입력해주세요.
```

```text
추가할 공연의 관람 시간을 입력해주세요 : 120분
0 이하의 숫자 또는 문자가 입력되었습니다.
1 이상의 숫자만 다시 입력해주세요.
```

## 존재하지 않는 공연번호 입력 예시

```text
조회할 공연 번호를 입력하세요 : 999999
입력하신 번호와 일치하는 공연이 없습니다.
```

---

# 📋 메인 메뉴

프로그램은 사용자가 종료 메뉴를 선택할 때까지 메인 메뉴를 반복하여 출력합니다.

```text
===== 공연 관리 시스템 =====
1. 공연 조회
2. 공연 등록
3. 공연 수정
4. 공연 삭제
9. 프로그램 종료

메뉴 번호를 입력하세요 :
```

`9`를 선택하면 메인 반복문이 종료되고 프로그램이 정상적으로 끝납니다.

---

# 🔢 공연번호 자동 생성

새로운 공연을 등록할 때 공연번호를 자동으로 생성합니다.

```text
100000~999999 범위의 6자리 번호 생성
                    ↓
        기존 공연번호와 중복 확인
                    ↓
       중복됨 ──→ 새로운 번호 재생성
                    ↓
             중복되지 않음
                    ↓
          새로운 공연번호로 사용
```

- 생성 범위: `100000~999999`
- 기존 공연번호와 중복 여부 확인
- 중복된 경우 새로운 번호 생성
- 중복되지 않은 번호를 공연번호로 사용

---
## ⏱️ 인터미션 정보 처리

공연마다 인터미션 유무가 다르기 때문에 **입력된 인터미션 시간에 따라 출력 여부를 다르게 처리**하였습니다.

- 인터미션 시간에 `0`을 입력한 경우  
  → 인터미션 정보를 출력하지 않고 **관람시간만 출력**

```text
관람시간 : 160분
```

- 인터미션 시간에 `양수(1 이상)`를 입력한 경우  
  → **관람시간과 인터미션 시간을 함께 출력**

```text
관람시간 : 160분 (인터미션 20분 포함)
```

### 구현 이유

인터미션이 없는 공연은 `0`을 입력하여 인터미션 정보가 출력되지 않도록 하고,  
인터미션이 있는 공연은 실제 인터미션 시간을 입력하여 관람시간과 함께 확인할 수 있도록 구현하였습니다.

이를 통해 공연별 인터미션 유무에 따라 **필요한 정보만 출력되도록 설계**하였습니다.

