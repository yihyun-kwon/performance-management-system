import com.ohgiraffers.perfmanagementsystem.controller.PerfController;
import com.ohgiraffers.perfmanagementsystem.model.Category;
import com.ohgiraffers.perfmanagementsystem.repository.PerfRepository;
import com.ohgiraffers.perfmanagementsystem.view.PerfView;

import java.util.Scanner;

public class Application {
    // 프로그램 실행에 필요한 Repository, View, Controller를 생성하고 Controller를 실행한다.
    public static void main(String[] args) {

        // 공연 데이터를 보관하고 관리할 Repository 객체를 생성한다.
        PerfRepository repository = new PerfRepository();

        // 사용자 입력과 출력을 담당할 View 객체를 생성한다.
        PerfView view = new PerfView();

        // Repository와 View를 연결하여 프로그램 흐름을 제어할 Controller 객체를 생성한다.
        PerfController controller = new PerfController(repository, view);

        // 공연 관리 프로그램의 메인 메뉴 반복을 시작한다.
        controller.run();
    }
}
