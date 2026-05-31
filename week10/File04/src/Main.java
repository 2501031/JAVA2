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
            System.out.printf("%s File이 존재합니다. \n",filePath);
            try {
                FileInputStream inputStream = new FileInputStream(file);
                BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
                FileOutputStream outputStream = new FileOutputStream(outputPath);
                BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(outputStream);
                byte[] buffer = new byte[8192];
                int data;
                while ((data = bufferedInputStream.read(buffer)) != -1) {
                    bufferedOutputStream.write(buffer, 0, data);
                    count += data;
                }
                System.out.printf("%,d KByte Copy 완료",count / 1024);
                bufferedInputStream.close();
                bufferedOutputStream.close();
                ProcessBuilder builder = new ProcessBuilder("mspaint",
                        new File(outputPath).getAbsolutePath());
                builder.start();
            }catch (IOException e) {
                System.err.println(e.getMessage());
            }
        } else {
            System.out.printf("%s File이 존재하지 않습니다.",filePath);
        }
    }
}