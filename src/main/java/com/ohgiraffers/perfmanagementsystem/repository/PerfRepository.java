package com.ohgiraffers.perfmanagementsystem.repository;

import com.ohgiraffers.perfmanagementsystem.model.Category;
import com.ohgiraffers.perfmanagementsystem.model.Performance;

import java.time.LocalDate;
import java.time.LocalTime;

import java.util.ArrayList;
import java.util.List;

public class PerfRepository {

    List<Performance> perfs = new ArrayList<>();

  public PerfRepository () {
      save(new Performance("이익준", "뮤지컬 드라큘라 (Dracula : The Musical)", Category.MUSICAL,
              LocalDate.parse("2026-09-13"), LocalTime.parse("13:00"), 14, 180000));
      save(new Performance("안정원", "뮤지컬 <겨울왕국> 한국 초연 (FROZEN The Musical)", Category.MUSICAL,
              LocalDate.parse("2026-10-03"), LocalTime.parse("19:00"), 8, 160000));
      save(new Performance("김준완", "뮤지컬 <디어 에번 핸슨> (Musical Dear Evan Hansen)", Category.MUSICAL,
              LocalDate.parse("2026-10-11"), LocalTime.parse("15:00"), 14, 144000));
      save(new Performance("양석형", "마룬5 내한공연", Category.CONCERT,
              LocalDate.parse("2027-01-27"), LocalTime.parse("20:00"), 13, 350000));
      save(new Performance("채송화", "2026 KIM JAE JOONG CONCERT [THE WAVE] in Seoul", Category.CONCERT,
              LocalDate.parse("2026-08-30"), LocalTime.parse("16:00"), 8, 165000));
      save(new Performance("장겨울", "2026 YENA ENCORE LIVE 네모로부터 시작된, 잡힐 듯 말 듯 한 이세계 : 극장판", Category.CONCERT,
              LocalDate.parse("2026-08-23"), LocalTime.parse("18:00"), 8, 154000));
      save(new Performance("추민하", "죽은 시인의 사회", Category.PLAY,
              LocalDate.parse("2026-08-30"), LocalTime.parse("14:00"), 8, 90000));
      save(new Performance("도재학", "연극 <타인의 삶>", Category.PLAY,
              LocalDate.parse("2026-09-01"), LocalTime.parse("19:30"), 14, 77000));
      save(new Performance("용석민", "연극 <꽃, 별이 지나>", Category.PLAY,
              LocalDate.parse("2026-09-23"), LocalTime.parse("16:00"), 14, 70000));
      save(new Performance("허선빈", "2026 예술의전당 & 유니버설발레단 <백조의 호수>", Category.CLASSICAL_DANCE,
              LocalDate.parse("2026-08-20"), LocalTime.parse("19:30"), 8, 120000));
      save(new Performance("오이영", "조수미 세계무대 데뷔 40주년 기념 공연 [Continuum] - 안양", Category.CLASSICAL_DANCE,
              LocalDate.parse("2026-09-11"), LocalTime.parse("19:30"), 7, 100000));
      save(new Performance("표남경", "지브리 & 디즈니 오케스트라 콘서트 (10.4)", Category.CLASSICAL_DANCE,
              LocalDate.parse("2026-10-04"), LocalTime.parse("19:30"), 8, 130000));
      save(new Performance("김사비", "키자니아GO - 현대백화점 충청점", Category.KIDS_FAMILY,
              LocalDate.parse("2026-09-09"), LocalTime.parse("11:00"), 4, 5000));
      save(new Performance("엄재일", "시간을 파는 상점", Category.KIDS_FAMILY,
              LocalDate.parse("2026-08-28"), LocalTime.parse("17:00"), 8, 45000));
      save(new Performance("구도원", "AI세계에서 살아남기", Category.KIDS_FAMILY,
              LocalDate.parse("2026-10-03"), LocalTime.parse("11:00"), 2, 66000));
      save(new Performance("서정민", "스튜디오 지브리展 in Jeju", Category.EXHIBITION,
              LocalDate.parse("2026-10-31"), LocalTime.parse("14:00"), 1, 22000));
      save(new Performance("공기선", "2027 논산세계딸기산업엑스포", Category.EXHIBITION,
              LocalDate.parse("2027-02-26"), LocalTime.parse("12:00"), 1, 9000));
      save(new Performance("류재휘", "2026 서울카페쇼", Category.EXHIBITION,
              LocalDate.parse("2026-11-11"), LocalTime.parse("10:00"), 1, 30000));
  }


    private void save(Performance perf){

      int randomId = (int)(Math.random()*1000)+1000;
//      findById(randomId) != null;
        perf.setReservationId(randomId);
        perfs.add(perf);

        System.out.println(perf);
  }

    public List<Performance> getPerfs() {
        return perfs;
    }

    public void setPerfs(List<Performance> perfs) {
        this.perfs = perfs;
    }
}
