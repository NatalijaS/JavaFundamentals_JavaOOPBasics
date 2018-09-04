package exams._2018_08_29_MyExam;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {

        ProvinceManager provinceManager = new ProvinceManager();
        Engine engine = new Engine(provinceManager);
        engine.run();
    }
}
