package com.ohgiraffers.perfmanagementsystem.model;


/* Performance 클래스
 * 공연 정보를 저장하는 모델 클래스이다.
 * 공연 번호, 공연명, 카테고리, 공연 기간, 공연장,
 * 관람 시간, 인터미션 시간, 관람 등급, 가격 정보를 하나의 객체로 관리한다.
 */

public class Performance {
    private int performanceId;     // 공연 번호
    private String title;          // 공연명
    private Category category;     // 카테고리
    private String period;         // 공연 기간
    private String place;          // 공연장
    private int runningTime;       // 관람 시간(분)
    private int intermissionTime;  // 인터미션 시간(분)
    private String ageRating;      // 관람 등급
    private int price;             // 가격


    /* Performance 객체를 생성하고 공연 정보를 초기화한다.
    * 인터미션 여부에 따라 생성자를 오버로딩하여 사용한다. */

    // 기본 생성자
    public Performance() {
    }

    // 전체 필드 생성자 (인터미션 포함)
    public Performance(int performanceId, String title, Category category, String period, String place,
                       int runningTime, int intermissionTime, String ageRating, int price) {
        this.performanceId = performanceId;
        this.title = title;
        this.category = category;
        this.period = period;
        this.place = place;
        this.runningTime = runningTime;
        this.intermissionTime = intermissionTime;
        this.ageRating = ageRating;
        this.price = price;
    }

    // 인터미션이 없는 공연을 위한 생성자
    public Performance(int performanceId, String title, Category category, String period,
                       String place, int runningTime, String ageRating, int price) {
        this.performanceId = performanceId;
        this.title = title;
        this.category = category;
        this.period = period;
        this.place = place;
        this.runningTime = runningTime;
        this.ageRating = ageRating;
        this.price = price;
    }

    /* 필드 값 조회 및 수정을 위한 Getter & Setter
    * 공연번호는 발급 후 변경하지 않으므로 Getter만 제공 */

    public int getPerformanceId() {
        return performanceId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getPeriod() {
        return period;
    }

    public void setPeriod(String period) {
        this.period = period;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public int getRunningTime() {
        return runningTime;
    }

    public void setRunningTime(int runningTime) {
        this.runningTime = runningTime;
    }

    public int getIntermissionTime() {
        return intermissionTime;
    }

    public void setIntermissionTime(int intermissionTime) {
        this.intermissionTime = intermissionTime;
    }

    public String getAgeRating() {
        return ageRating;
    }

    public void setAgeRating(String ageRating) {
        this.ageRating = ageRating;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    // Performance 객체에 저장된 공연 정보를 문자열로 반환한다.

    @Override
    public String toString() {
        return "Performance{" +
                "performanceId=" + performanceId +
                ", title='" + title + '\'' +
                ", category=" + category +
                ", period='" + period + '\'' +
                ", place='" + place + '\'' +
                ", runningTime=" + runningTime +
                ", intermissionTime=" + intermissionTime +
                ", ageRating='" + ageRating + '\'' +
                ", price=" + price +
                '}';
    }
}
