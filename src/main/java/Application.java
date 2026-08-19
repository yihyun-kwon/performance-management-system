import com.ohgiraffers.perfmanagementsystem.controller.PerfController;
import com.ohgiraffers.perfmanagementsystem.model.Category;
import com.ohgiraffers.perfmanagementsystem.repository.PerfRepository;
import com.ohgiraffers.perfmanagementsystem.view.PerfView;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        PerfRepository repository = new PerfRepository();

        PerfView view = new PerfView();

        PerfController controller = new PerfController(repository, view);

        controller.run();
    }
}