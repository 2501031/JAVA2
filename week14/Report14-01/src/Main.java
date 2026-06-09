import java.io.File;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        String path = ".\\data\\";
        String excelName = "student1.xlsx";
        String pdfName = "student1.pdf";

        File file = new File(path + excelName);

        if (file.exists()) {
            ExcelHandler excelHandler = new ExcelHandler();
            ArrayList<Student> students = excelHandler.readExcel(file);

            if (!students.isEmpty()) {
                PDFHandler pdfHandler = new PDFHandler();
                pdfHandler.makePDF(path + pdfName, students);
                System.out.println("성공: PDF 파일이 생성되었습니다.");
            }
        } else {
            System.out.println("오류: 엑셀 파일을 찾을 수 없습니다. 경로: " + file.getAbsolutePath());
        }
    }
}