import java.io.File;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        String filePath = ".\\data\\sample.txt";

        File file = new File(filePath);
        if (file.exists()) {
            System.out.printf("%s File이 존재합니다. \n", filePath);
        } else {
            System.out.printf("%s File이 존재하지 않습니다. \n", filePath);
        }
    }
}