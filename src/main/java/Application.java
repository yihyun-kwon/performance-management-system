import com.ohgiraffers.perfmanagementsystem.model.Category;
import com.ohgiraffers.perfmanagementsystem.repository.PerfRepository;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {

//        Scanner scanner = new Scanner(System.in);

        PerfRepository pe = new PerfRepository();

//        System.out.println(pe.getPerfs());
        System.out.println(pe.findAll());
    }
}