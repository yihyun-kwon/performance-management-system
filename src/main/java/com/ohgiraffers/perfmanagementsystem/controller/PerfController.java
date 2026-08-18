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

    // 전체 조회
    public void findAllPerfList() {
        perfView.displayPerformance(perfRepository.findAll());
    }

    // 공연 번호로 조회
    public void findPerfById(int performanceId) {

        Performance performance = perfRepository.findById(performanceId);

        if (performance == null) {
            perfView.displayError("해당 번호의 공연을 찾을 수 없습니다.");
            return;
        }
        perfView.displayPerf(performance);

        }

        // 제목 검색
    public void searchPerf(String title) {

        List<Performance> performances = perfRepository.findByTitle(title);

        perfView.displayMessage(" " + title + " 검색 결과입니다.");
        perfView.displayPerfList(performances);
    }
    public void findByCategory(Category category){

        perfView.displayMessage(category.getDescription() + " 종류의 공연입니다.");
        perfView.displayPerfList(perfRepository.findAllByCategory(category));
    }
    }
