import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        String filePath = ".\\data\\sample.txt";
        String outputPath = ".\\data\\sample_copy.txt";
        int count = 0;

        File file = new File(filePath);
        if (file.exists()) {
            try {
                FileReader fileReader = new FileReader(file, Charset.defaultCharset());
                FileWriter fileWriter = new FileWriter(outputPath, Charset.defaultCharset());
                char[] buffer = new char[8192];  // 8K
                int ch;
                while ((ch = fileReader.read(buffer)) != -1) {
                    count += ch;
                    fileWriter.write(buffer, 0, ch);
                }
                System.out.printf("%,d Bytes 복사 \n", count);
                fileReader.close();
                fileWriter.close();
                Runtime.getRuntime().exec("notepad.exe " + outputPath);
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
            System.out.printf("%s File이 존재합니다. \n", filePath);
        } else {
            System.out.printf("%s File이 존재하지 않습니다. \n", filePath);
        }
    }
}