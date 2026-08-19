package com.ohgiraffers.perfmanagementsystem.view;

import com.ohgiraffers.perfmanagementsystem.model.Category;
import com.ohgiraffers.perfmanagementsystem.model.Performance;

import java.util.List;
import java.util.Scanner;

public class PerfView {

    Scanner scanner = new Scanner(System.in);

    // 메인 메뉴 선택
    public int inputMenuNumber() {
        while (true) {
            try {
                displayMainMenu();

                System.out.println();
                System.out.print(" 메뉴 번호를 입력하세요 : ");
                String menuNumber = scanner.nextLine();

                return Integer.parseInt(menuNumber);

            } catch (NumberFormatException e) {
                System.out.println("숫자만 입력해주세요.");
            }
        }
    }

    // 조회 메뉴 선택
    public int inputSearchMenuNumber() {
        while (true) {
            try {
                displaySearchMenu();

                System.out.print(" 조회할 방법의 번호를 입력해주세요 : ");
                String searchMenuNumber = scanner.nextLine();

                return Integer.parseInt(searchMenuNumber);

            } catch (NumberFormatException e) {
                System.out.println("숫자만 입력해주세요.");
            }
        }
    }

    // 카테고리 메뉴 선택
    public int inputCategoryMenuNumber() {
        while (true) {
            try {
                displayCategoryMenu();

                System.out.println("조회할 카테고리의 번호를 입력하세요 : ");
                String categoryMenuNumber = scanner.nextLine();

                return Integer.parseInt(categoryMenuNumber);

            } catch (NumberFormatException e) {
                System.out.println("숫자만 입력해주세요.");
            }
        }
    }

    // 공연 제목으로 조회
    public String inputTitleKeyword() {
        System.out.print("조회할 제목을 입력하세요 : ");
        String titleKeyword = scanner.nextLine();

        return titleKeyword;
    }

    // 공연 번호로 조회
    public int inputPerfId() {
        while (true) {
            try {
                System.out.print("조회할 공연 번호를 입력하세요 : ");
                String performanceId = scanner.nextLine();

                return Integer.parseInt(performanceId);

            } catch (NumberFormatException e) {
                System.out.println("숫자만 입력해주세요.");
            }
        }
    }

    // 메인 메뉴 출력
    public void displayMainMenu() {
        System.out.println();
        System.out.println("===== 공연 관리 시스템 =====");
        System.out.println("1. 공연 조회");
        System.out.println("2. 공연 등록");
        System.out.println("3. 공연 수정");
        System.out.println("4. 공연 삭제");
        System.out.println("9. 프로그램 종료");
    }

    // 조회 메뉴 출력
    public void displaySearchMenu() {
        System.out.println();
        System.out.println(" ===== 공연 조회 메뉴 =====");
        System.out.println("1. 전체 조회");
        System.out.println("2. 카테고리별 조회");
        System.out.println("3. 공연 제목으로 조회");
        System.out.println("4. 공연 번호로 조회");
        System.out.println("9. 이전 메뉴로 돌아가기");
    }

    // 카테고리 메뉴 출력
    public void displayCategoryMenu() {
        System.out.println();
        System.out.println(" ===== 카테고리 선택 =====");
        System.out.println("1. 뮤지컬 ");
        System.out.println("2. 콘서트 ");
        System.out.println("3. 연극 ");
        System.out.println("4. 클래식·무용 ");
        System.out.println("5. 아동·가족 ");
        System.out.println("6. 전시 ");
        System.out.println("9. 이전 메뉴로 돌아가기");
    }

    // 공연 상세 정보 출력
    public void displayPerformanceMenu(Performance performance) {

        System.out.println();
        System.out.println("------- 공연 상세 정보 -------");
        System.out.println("공연 번호 : " + performance.getPerformanceId());
        System.out.println("공연 명 : " + performance.getTitle());
        System.out.println("카테고리 : " + performance.getCategory());
        System.out.println("공연 기간 : " + performance.getPeriod());
        System.out.println("공연장 : " + performance.getPlace());

        if (performance.getIntermissionTime() > 0) {
            System.out.println("관람 시간 : " + performance.getRunningTime() + "분" +
                    "(인터미션 포함 " + performance.getIntermissionTime() + "분)");
        } else if (performance.getIntermissionTime() <= 0) {
            System.out.println("관람 시간: " + performance.getRunningTime() + "분");
        }
        System.out.println("관람 등급 : " + performance.getAgeRating());
        System.out.println("관람 가격 : " + performance.getPrice() + "원");
    }

    // 전체 공연 출력
    public void displayPerformanceList(List<Performance> performanceList) {
        if (performanceList.isEmpty()) {
            System.out.println("조회 가능한 공연이 없습니다.");
            return;
        } else
            performanceList.forEach(performance -> displayPerformanceMenu(performance));
    }

    // 카테고리 출력
    public void displayCategoryList(List<Category> categoryList) {
        categoryList.forEach(category -> System.out.println(category.getDescription()));
    }

    public String inputPerfNewTitle() {
        System.out.print("추가할 공연의 제목을 입력해주세요 : ");
        String newTitle = scanner.nextLine();

        return newTitle;
    }

    public int inputNewCategory() {
        while (true) {
            try {

                System.out.print("추가할 카테고리의 번호를 입력해주세요 " +
                        "[1. 뮤지컬, 2. 콘서트, 3. 연극, 4.클래식·무용, 5. 아동·가족, 6. 전시] : ");

                String category = scanner.nextLine();

                int categoryNumber = Integer.parseInt(category.trim());

                if (categoryNumber >= 1 && categoryNumber <= 6) {
                    return categoryNumber;
                } else
                    System.out.println("잘못 입력하셨습니다.");

            } catch (NumberFormatException e) {
                System.out.println("1 ~ 6 사이의 숫자를 입력해주세요.");
            }
        }
    }

    public String inputNewPeriod() {
        System.out.print("추가할 공연의 기간을 입력해주세요 : ");
        String newPeriod = scanner.nextLine();

        return newPeriod;
    }

    public String inputNewPlace() {
        System.out.print("추가할 공연의 장소를 입력해주세요 : ");
        String newPlace = scanner.nextLine();

        return newPlace;
    }

    public int inputNewRunningTime() {
        while (true) {
            try {
                System.out.print("추가할 공연의 관람 시간을 입력해주세요 : ");
                String newRunningTime = scanner.nextLine();

                int runningTime = Integer.parseInt(newRunningTime.trim());

                if (runningTime > 0 && runningTime != 0) {
                    return runningTime;
                } else
                    System.out.println("관람 시간은 1 이상이어야 합니다.");

            } catch (NumberFormatException e) {
                System.out.println("숫자를 입력해주세요.");
            }
        }
    }

    public int inputNewIntermissionTime() {
        while (true) {
            try {
                System.out.print("추가할 공연의 인터 미션을 입력해주세요 (없을 경우 0 입력) : ");
                String newIntermissionTime = scanner.nextLine();

                int intermissionTime = Integer.parseInt(newIntermissionTime.trim());

                if(intermissionTime >= 0) {
                    return intermissionTime;
                } else
                    System.out.println("인터미션은 음수일 수 없습니다.");

            } catch (NumberFormatException e) {
                System.out.println("0이상의 숫자를 입력해주세요.");
            }
        }
    }

    public String inputNewAgeRating() {
        System.out.print("추가할 공연의 관람 등급(최소 관람 나이)을/(를) 입력해주세요 : ");
        String newAgeRating = scanner.nextLine();

        return newAgeRating;
    }


    public int inputNewPrice() {
        while (true) {
            try {
            System.out.print("추가할 공연의 가격을 입력해주세요 : ");
            String newPrice = scanner.nextLine();

            int price = Integer.parseInt(newPrice.trim());

            if (price > 0) {
             return price;
            } else
                System.out.println("가격은 음수일 수 없습니다.");

        } catch (NumberFormatException e) {
                System.out.println("0이상의 숫자를 입력해주세요.");
            }
    }
}

    public void displayError(String message){
        System.out.println(message);
    }

    public void displayMessage(String message){
        System.out.println(message);
    }

    public void displayPerf(Performance performance){
        System.out.println(performance);
    }


}
