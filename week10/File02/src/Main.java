import java.io.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws IOException {
        String filePath = ".\\data\\kbu.jpg";  // 상대주소
        String outputPath = ".\\data\\kbu_copy.jpg";
        int count = 0;

        File file = new File(filePath);
        if (file.exists()) {
            System.out.printf("%s File이 존재합니다.",filePath);
            try {
                FileInputStream inputStream = new FileInputStream(file);
                FileOutputStream outputStream = new FileOutputStream(outputPath);
                int data;
                while ((data = inputStream.read()) != -1) {
                    count++;
                    outputStream.write(data);
                }
                System.out.printf("%,d Byte Copy 완료",count);
                inputStream.close();
                outputStream.close();
            }catch (IOException e) {
                System.err.println(e.getMessage());
            }
        } else {
            System.out.printf("%s File이 존재하지 않습니다.",filePath);
        }
    }
}