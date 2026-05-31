import java.io.*;
import java.nio.charset.Charset;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        String filePath = ".\\data\\sample.txt";
        String outputPath = ".\\data\\sample_copy.txt";
        int count = 0;
        int lineCount = 0;

        File file = new File(filePath);
        if (file.exists()) {
            try {
                FileReader fileReader = new FileReader(file, Charset.defaultCharset());
                BufferedReader bufferedReader = new BufferedReader(fileReader);

                FileWriter fileWriter = new FileWriter(outputPath, Charset.defaultCharset());
                BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

                String line;
                while ((line = bufferedReader.readLine()) != null) {
                    bufferedWriter.write(line);
                    bufferedWriter.newLine();
                    lineCount++;
                    count += line.length() + 1;
                }
                System.out.printf("%,d Bytes 복사 (%d Lines) \n", count, lineCount);
                bufferedReader.close();
                bufferedWriter.close();
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