package com.ohgiraffers.perfmanagementsystem.model;

/*
* 공연의 종류(장르)를 표현하는 enum이다.
* 화면에 출력될 한글 이름(description)을 final로 지정하여 변경되지 않도록 설정 한다. */

public enum Category {
     MUSICAL("뮤지컬"),           // 뮤지컬
    CONCERT("콘서트"),            // 콘서트
    PLAY("연극"),               // 연극
    CLASSICAL_DANCE("클래식·댄스"),    // 클래식·댄스
    KIDS_FAMILY("아동·가족"),        // 아동·가족
    EXHIBITION("전시");          // 전시

    private final String description;

    Category(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
