package com.ohgiraffers.perfmanagementsystem.controller;

import com.ohgiraffers.perfmanagementsystem.model.Category;
import com.ohgiraffers.perfmanagementsystem.model.Performance;
import com.ohgiraffers.perfmanagementsystem.repository.PerfRepository;
import com.ohgiraffers.perfmanagementsystem.view.PerfView;

import java.util.List;

public class PerfController {

    private final PerfRepository perfRepository;
    private final PerfView perfView;

    public PerfController(PerfRepository perfRepository, PerfView perfView) {
        this.perfRepository = perfRepository;
        this.perfView = perfView;
    }

    public void run(){
        boolean isRunning = true;

        while (isRunning) {
            int menuNumber = perfView.inputMenuNumber();

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
                    break;
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
        boolean isCateegoryRunning = true;

        while (isCateegoryRunning) {
            int categoryMenuNumber = perfView.inputCategoryMenuNumber();

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
                    continue;
            }
            findByCategory(selectedCategory);
        }
    }

    private void findAllPerformance(){
        List<Performance> allPerformances = perfRepository.findAll();
        perfView.displayPerformanceList(allPerformances);
    }

    private void findByCategory(Category selectedCategory){
        List<Performance> matchedPerformances = perfRepository.findAllByCategory(selectedCategory);
        perfView.displayPerformanceList(matchedPerformances);
    }
    private void findTitle(){
        String title = perfView.inputTitleKeyword();

        List<Performance> perftitles = perfRepository.findByTitle(title);
        perfView.displayPerformanceList(perftitles);
    }
    private void findById(){
        int performanceId = perfView.inputPerfId();

        Performance performance = perfRepository.findById(performanceId);

        if(performance != null){
            perfView.displayPerformanceMenu(performance);
        }else
            perfView.displayError("입력하신 번호와 일치하는 공연이 없습니다.");
    }

    }
