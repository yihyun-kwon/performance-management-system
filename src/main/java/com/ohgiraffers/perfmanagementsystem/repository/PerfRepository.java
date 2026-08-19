package com.ohgiraffers.perfmanagementsystem.repository;

import com.ohgiraffers.perfmanagementsystem.model.Category;
import com.ohgiraffers.perfmanagementsystem.model.Performance;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/* 공연 정보를 메모리(List)에 보관하고, 조회/등록/삭제 기능을 제공하는 저장소 클래스이다.*/
public class PerfRepository {

    // 등록된 공연 정보를 저장하는 내부 목록
    private final List<Performance> performanceList = new ArrayList<>();

    // 저장소가 생성될 때 기본으로 사용할 샘플 공연 데이터를 등록한다.
  public PerfRepository () {
      save(new Performance(583214, "뮤지컬 드라큘라 (Dracula : The Musical)", Category.MUSICAL,
              "2026.07.10 ~ 2026.10.18", " LG아트센터 서울 LG SIGNATURE 홀", 165,
              20, "14세", 180000));
      save(new Performance(741926, "뮤지컬 <겨울왕국> 한국 초연 (FROZEN The Musical)", Category.MUSICAL,
              "2026.08.13 ~ 2027.03.01", "샤롯데씨어터", 135,
              20, "8세", 160000));
      save(new Performance(315847, "뮤지컬 <디어 에반 핸슨> (Musical Dear Evan Hansen)", Category.MUSICAL,
              "2026.08.01 ~ 2026.11.01", "충무아트센터 대극장",
              160, 20, "14세", 160000));
      save(new Performance(862451, "2026 YENA ENCORE LIVE 네모로부터 시작된, 잡힐 듯 말 듯 한 이세계 : 극장판",
              Category.CONCERT, "2026.08.22 ~ 2026.08.23", "장충체육관",
              120, 0, "8세", 154000));
      save(new Performance(429673, "NCT DREAM 10TH ANNIVERSARY PARTY <THE SWEET DREAM HOTEL>",
              Category.CONCERT, "2026.08.22 ~ 2026.08.23", "인스파이어 아레나",
              180, 0, "7세", 121000));
      save(new Performance(156928, "[서울] 2026 이승철 40주년 콘서트 [THE VOICE: LEE SEUNG CHUL]",
              Category.CONCERT, "2026.12.04 ~ 2026.12.06", "KSPO DOME(올림픽체조경기장)",
              120, 20, "8세", 198000));
      save(new Performance(937514, "<죽은 시인의 사회>", Category.PLAY,
              "2026.07.18 ~ 2026.09.13", "NOL 씨어터 대학로 우리카드홀",
              125, 0, "8세", 120000));
      save(new Performance(624381, "연극 <꽃, 별이 지나>", Category.PLAY,
              "2026.06.16 ~ 2026.08.23", "NOL 서경스퀘어 스콘 1관",
              100, 0, "14세", 70000));
      save(new Performance(278645, "연극 <타인의 삶>", Category.PLAY,
              "2026.07.01 ~ 2026.09.13", "LG아트센터 서울 U+ 스테이지",
              110, 0, "14세", 77000));
      save(new Performance(513792, "2026 예술의전당＆유니버설발레단 <백조의 호수>", Category.CLASSICAL_DANCE,
              "2026.08.14 ~ 2026.08.23", "예술의전당 오페라극장",
              150, 20, "8세", 140000));
      save(new Performance(846237, "지브리＆디즈니 영화음악 FESTA", Category.CLASSICAL_DANCE,
              "2026.08.30", "예술의전당 콘서트홀",
              120, 15, "8세", 12000));
      save(new Performance(391568, "손열음 피아노 리사이틀", Category.CLASSICAL_DANCE,
              "2026.10.18", "예술의전당 콘서트홀",
              90, 20, "8세", 120000));
      save(new Performance(725143, "시간을 파는 상점", Category.KIDS_FAMILY,
              "2024.03.15 ~ 오픈런", "파랑씨어터",
              90, 0, "8세", 45000));
      save(new Performance(468219, "키자니아GO - 현대백화점 충청점", Category.KIDS_FAMILY,
              "2026.08.14 ~ 2026.09.06", "현대백화점 충청점 7층 문화홀",
              13, 0, "36개월", 5000));
      save(new Performance(193754, "[서울(영등포)] 2026 명작동화 가족뮤지컬 [백설공주]", Category.KIDS_FAMILY,
              "2026.09.19 ~ 2026.09.20", "롯데백화점 영등포점 10F 문화홀",
              55, 0, "24개월", 40000));
      save(new Performance(657821, "앤디 워홀: 예술을 팔다 - 대구", Category.EXHIBITION,
              "2026.07.03 ~ 2026.10.25", "대구문화예술회관 미술관",
              60, 0, "전체관람가", 20000));
      save(new Performance(284936, "[창원] 엘리자베스 랭그리터 - 매일이 휴가", Category.EXHIBITION,
              "2026.07.16 ~ 2026.10.11", "3.15아트홀 전시장",
              60, 0, "전체관람가", 10000));
      save(new Performance(971362, "[상시관람] 진격의 거인展 FINAL", Category.EXHIBITION,
              "2026.06.22 ~ 2026.11.01", "덕스(DUEX) 홍대",
              60, 0, "8세", 26000));

  }

  // 전달받은 공연 정보를 내부 목록에 추가한다.
  public void save(Performance performance){
      performanceList.add(performance);
  }

   /*
    * 새로 등록할 공연의 6자리 공연번호(100000 ~ 999999)를 난수로 생성한다.
    * 기존 공연번호와 중복될 경우 중복되지 않을 때까지 다시 생성한다.
    */
  private int generatePerformanceId() {
      int performanceId;
        do {
            performanceId = (int)(Math.random() * 900000) + 100000;
        } while (findById(performanceId) != null);

        return performanceId;
  }

    /*
     * 공연 데이터 조회 방법
     * 1. 전체 공연 조회: findAll()
     * 2. 공연 번호로 단일 조회: findById()
     * 3. 카테고리별 공연 목록 조회: findAllByCategory()
     * 4. 제목 키워드로 공연 목록 조회: findByTitle()
     */

  // 전체 공연 목록 - 원본 목록 보호를 위해 새로운 ArrayList로 복사해서 반환한다.
  public List<Performance> findAll(){
      return new ArrayList<>(performanceList);
  }

    // 공연 번호가 일치하는 공연을 조회하고, 없으면 null을 반환한다.
    public Performance findById(int performanceId){

        return performanceList.stream()
                .filter(performance -> performance.getPerformanceId() == performanceId)
                .findFirst()
                .orElse(null);
    }

    // 전달받은 카테고리와 일치하는 공연 목록을 조회한다.
    public List<Performance> findAllByCategory(Category category){

        return performanceList.stream()
                .filter(performance -> performance.getCategory().equals(category))
                .collect(Collectors.toList());
    }

    // 제목에 검색어가 포함된 공연 목록을 대소문자 구분 없이 조회한다.
    public List<Performance> findByTitle(String title){
        String titleKeyword = title.trim().toLowerCase();

        return performanceList.stream()
                .filter(performance -> performance.getTitle().toLowerCase().contains(titleKeyword))
                .collect(Collectors.toList());
    }

    // 공연 번호가 일치하는 공연을 삭제하고, 삭제 성공 여부를 반환한다.
    public boolean deleteById(int performanceid){

      return performanceList.removeIf(performance -> performance.getPerformanceId() == performanceid);
    }

}

