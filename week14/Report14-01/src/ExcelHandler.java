import org.apache.poi.xssf.usermodel.*;
import java.io.*;
import java.util.ArrayList;
public class ExcelHandler {
    public ArrayList<Student> readExcel(File file) {
        ArrayList<Student> students = new ArrayList<>();
        try (InputStream stream = new FileInputStream(file);
             XSSFWorkbook workbook = new XSSFWorkbook(stream)) {
            XSSFSheet sheet = workbook.getSheetAt(0);
            for (int i = 1; i <= sheet.getLastRowNum(); i++) {
                XSSFRow row = sheet.getRow(i);
                if (row == null) continue;

                String id = row.getCell(0).toString();
                String name = row.getCell(1).toString();
                String gender = row.getCell(2).toString();

                Student student = new Student(name, gender);
                student.setStudentID(id);
                for (int j = 0; j < 4; j++) {
                    student.getSubject(j).setScore((int)row.getCell(j+3).getNumericCellValue());
                }
                students.add(student);
            }
        } catch (Exception e) { e.printStackTrace(); }
        return students;
    }
}