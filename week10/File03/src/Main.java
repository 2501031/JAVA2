import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws IOException {
        String filePath = ".\\data\\kbu.jpg";  // 상대주소
        String outputPath = ".\\data\\kbu_copy.jpg";
        int count = 0;

        File file = new File(filePath);
        if (file.exists()) {
            System.out.printf("%s File이 존재합니다. \n",filePath);
            try {
                FileInputStream inputStream = new FileInputStream(file);
                FileOutputStream outputStream = new FileOutputStream(outputPath);
                byte[] buffer = new byte[8192];
                int data;
                while ((data = inputStream.read(buffer)) != -1) {
                    outputStream.write(buffer, 0, buffer.length);
                    count += data;
                }
                System.out.printf("%,d KByte Copy 완료",count / 1024);
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