package com.ohgiraffers.perfmanagementsystem.model;

import java.time.LocalDate;
import java.time.LocalTime;

/* Performance 클래스
 * 공연 예매 정보를 저장하는 모델 클래스이다.
 * 예매 번호, 예매자 이름, 공연 제목, 카테고리, 관람 날짜와 시간,
 * 관람 등급, 가격 정보를 하나의 객체로 관리한다.
 */

public class Performance {
    private int reservationId;      // 예매 번호
    private String customerName;    // 예매자 이름
    private String prefTitle;       // 공연 제목
    private Category category;      // 공연 카테고리
    private LocalDate viewDate;     // 관람 날짜
    private LocalTime viewTime;     // 관람 시간
    private int ageRating;          // 관람 가능 연령 등급
    private int price;              // 예매 가격

    public Performance() {
    }

    // 모든 필드를 전달받아 공연 예매 객체를 생성하는 생성자이다.
    public Performance(int reservationId, String customerName, String prefTitle, Category category, LocalDate viewDate, LocalTime viewTime, int ageRating, int price) {
        this.reservationId = reservationId;
        this.customerName = customerName;
        this.prefTitle = prefTitle;
        this.category = category;
        this.viewDate = viewDate;
        this.viewTime = viewTime;
        this.ageRating = ageRating;
        this.price = price;
    }

    // 예매 번호를 반환한다.
    public int getReservationId() {
        return reservationId;
    }

    // 예매자 이름을 반환한다.
    public String getCustomerName() {
        return customerName;
    }

    // 예매자 이름을 수정한다.
    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    // 공연 제목을 반환한다.
    public String getPrefTitle() {
        return prefTitle;
    }

    // 공연 제목을 수정한다.
    public void setPrefTitle(String prefTitle) {
        this.prefTitle = prefTitle;
    }

    // 공연 카테고리를 반환한다.
    public Category getCategory() {
        return category;
    }

    // 공연 카테고리를 수정한다.
    public void setCategory(Category category) {
        this.category = category;
    }

    // 관람 날짜를 반환한다.
    public LocalDate getViewDate() {
        return viewDate;
    }

    // 관람 날짜를 수정한다.
    public void setViewDate(LocalDate viewDate) {
        this.viewDate = viewDate;
    }

    // 관람 시간을 반환한다.
    public LocalTime getViewTime() {
        return viewTime;
    }

    // 관람 시간을 수정한다.
    public void setViewTime(LocalTime viewTime) {
        this.viewTime = viewTime;
    }

    // 관람 가능 연령 등급을 반환한다.
    public int getAgeRating() {
        return ageRating;
    }

    // 관람 가능 연령 등급을 수정한다.
    public void setAgeRating(int ageRating) {
        this.ageRating = ageRating;
    }

    // 예매 가격을 반환한다.
    public int getPrice() {
        return price;
    }

    // 예매 가격을 수정한다.
    public void setPrice(int price) {
        this.price = price;
    }

    // 객체에 저장된 공연 예매 정보를 문자열 형태로 반환한다.
    @Override
    public String toString() {
        return "Performance{" +
                "reservationId=" + reservationId +
                ", customerName='" + customerName + '\'' +
                ", prefTitle='" + prefTitle + '\'' +
                ", category=" + category +
                ", viewDate=" + viewDate +
                ", viewTime=" + viewTime +
                ", ageRating=" + ageRating +
                ", price=" + price +
                '}';
    }
}
