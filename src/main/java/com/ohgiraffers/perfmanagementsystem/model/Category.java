package com.ohgiraffers.perfmanagementsystem.model;

/* 공연의 카테고리를 표현하는 enum이다.
 * 화면에 출력할 한글 이름(description)을 final로 선언하여
 * 생성 이후 변경되지 않도록 한다. */

public enum Category {
     MUSICAL("뮤지컬"),           // 뮤지컬
    CONCERT("콘서트"),            // 콘서트
    PLAY("연극"),               // 연극
    CLASSICAL_DANCE("클래식·무용"),    // 클래식·무용
    KIDS_FAMILY("아동·가족"),        // 아동·가족
    EXHIBITION("전시");          // 전시

    // 화면에 표시할 카테고리의 한글 이름을 저장한다.
    private final String description;

    // 각 enum 상수에 전달된 한글 이름을 초기화한다.
    Category(String description) {
        this.description = description;
    }

    // 카테고리의 한글 이름을 반환한다.
    public String getDescription() {
        return description;
    }
}
