package com.ohgiraffers.perfmanagementsystem.controller;

import com.ohgiraffers.perfmanagementsystem.model.Category;
import com.ohgiraffers.perfmanagementsystem.model.Performance;
import com.ohgiraffers.perfmanagementsystem.repository.PerfRepository;
import com.ohgiraffers.perfmanagementsystem.view.PerfView;

import java.util.List;

public class PerfController {

    // Controller가 Repository와 View를 여러 메서드에서 사용할 수 있도록 필드로 보관한다.
    private final PerfRepository perfRepository;
    private final PerfView perfView;

    // Application에서 만든 Repository와 View 객체를 전달받아 위 필드에 저장한다.
    public PerfController(PerfRepository perfRepository, PerfView perfView) {
        this.perfRepository = perfRepository;
        this.perfView = perfView;
    }

    // 프로그램의 시작 메서드이며, 사용자가 9번을 선택할 때까지 메인 메뉴를 반복한다.
    public void run(){
        boolean isRunning = true;

        while (isRunning) {
            int menuNumber = perfView.inputMenuNumber();

            // View가 반환한 메뉴 번호에 따라 실행할 기능을 결정한다.
            switch (menuNumber) {
                case 1:
                    handleSearchMenu();
                break;
            case 2:
                // 공연 등록
                break;

            case 3:
                // 공연 수정
                break;
            case 4:
                // 공연 삭제
                break;
            case 9:
                isRunning = false;
                break;
        }

        }
    }

    // 조회 방법을 선택하고 각 조회 기능으로 연결한다.
    private void handleSearchMenu(){
        boolean isSearchRunning = true;

        while (isSearchRunning) {
            int searchMenuNumber = perfView.inputSearchMenuNumber();

            switch (searchMenuNumber) {
                case 1:
                    findAllPerformance();
                    break;
                case 2:
                    categorySearchMenu();
                    return;
                case 3:
                    findTitle();
                    break;
                case 4:
                    findById();
                    break;
                case 9:
                    isSearchRunning = false;
                    break;
            }
                }
    }




    // 카테고리 조회 선택 메뉴
    private void categorySearchMenu(){
            // View는 사용자가 선택한 번호만 int로 반환한다.
            int categoryMenuNumber = perfView.inputCategoryMenuNumber();

            // Controller가 숫자를 실제 Category enum 값으로 변환해 저장한다.
            Category selectedCategory;

            switch (categoryMenuNumber) {
                case 1:
                    selectedCategory = Category.MUSICAL;
                    break;
                case 2:
                    selectedCategory = Category.CONCERT;
                    break;
                case 3:
                    selectedCategory = Category.PLAY;
                    break;
                case 4:
                    selectedCategory = Category.CLASSICAL_DANCE;
                    break;
                case 5:
                    selectedCategory = Category.KIDS_FAMILY;
                    break;
                case 6:
                    selectedCategory = Category.EXHIBITION;
                    break;
                case 9:
                    return;
                default:
                    perfView.displayError("없는 번호입니다. 다시 입력해주세요.");
                    return;
            }
            // 선택된 enum 값을 카테고리 조회 메서드에 전달한다.
            findByCategory(selectedCategory);
        }

    // Repository에서 전체 공연 목록을 받은 뒤 View에 출력을 요청한다.
    private void findAllPerformance(){
        List<Performance> allPerformances = perfRepository.findAll();
        perfView.displayPerformanceList(allPerformances);
    }

    // 선택된 카테고리에 해당하는 목록을 받은 뒤 View에 출력을 요청한다.
    private void findByCategory(Category selectedCategory){
        List<Performance> matchedPerformances = perfRepository.findAllByCategory(selectedCategory);
        perfView.displayPerformanceList(matchedPerformances);
    }
    // View에서 제목 검색어를 받아 Repository에 전달하고 결과 목록을 출력한다.
    private void findTitle(){
        String title = perfView.inputTitleKeyword();

        List<Performance> perftitles = perfRepository.findByTitle(title);
        perfView.displayPerformanceList(perftitles);
    }
    // View에서 공연 번호를 받아 공연 한 개를 조회하고, null 여부에 따라 결과를 출력한다.
    private void findById(){
        int performanceId = perfView.inputPerfId();

        Performance performance = perfRepository.findById(performanceId);

        if(performance != null){
            perfView.displayPerformanceMenu(performance);
        }else
            perfView.displayError("입력하신 번호와 일치하는 공연이 없습니다.");
    }
    // 신규 공연 등록에 필요한 정보를 View에서 하나씩 입력받는다.
    private void createPerformance(){
        // Repository가 기존 번호와 중복되지 않는 공연 번호를 생성한다.
        int performanceId = perfRepository.generatePerformanceId();

        // 아래 변수들은 View가 반환한 사용자 입력값을 저장하는 지역변수이다.
        String title = perfView.inputPerfNewTitle();

        int categoryNumber = perfView.inputNewCategory();

        Category selectedCategory;

        switch (categoryNumber) {
            case 1:
                selectedCategory = Category.MUSICAL;
                break;
            case 2:
                createPerformance();
                selectedCategory = Category.CONCERT;
                break;
            case 3:
                selectedCategory = Category.PLAY;
                break;
            case 4:
                selectedCategory = Category.CLASSICAL_DANCE;
                break;
            case 5:
                selectedCategory = Category.KIDS_FAMILY;
                break;
            case 6:
                selectedCategory = Category.EXHIBITION;
                break;
            default:
                perfView.displayError("잘못된 카테고리 번호입니다.");
                return;
        }

        String period = perfView.inputNewPeriod();
        String place = perfView.inputNewPlace();
        int runningTime =  perfView.inputNewRunningTime();
        int intermissionTime =  perfView.inputNewIntermissionTime();
        String ageRating =  perfView.inputNewAgeRating();
        int price = perfView.inputNewPrice();

        Performance newPerformance = new Performance(performanceId, title, selectedCategory, period, place,
                runningTime, intermissionTime, ageRating, price);

        perfRepository.save(newPerformance);
        perfView.displayMessage("공연이 등록되었습니다.");
        perfView.displayPerformanceMenu(newPerformance);
    }

    }
