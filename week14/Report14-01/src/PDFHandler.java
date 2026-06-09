import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;
import java.io.FileOutputStream;
import java.util.ArrayList;

public class PDFHandler {
    private String[] headers = {
            "학번", "이름", "성별",
            "국어 점수", "국어 학점",
            "영어 점수", "영어 학점",
            "수학 점수", "수학 학점",
            "선택 점수", "선택 학점",
            "총점", "평균", "반 석차", "학년 석차"
    };

    public void makePDF(String filename, ArrayList<Student> students) {
        Document document = new Document(PageSize.A4.rotate());

        try {
            PdfWriter.getInstance(document, new FileOutputStream(filename));
            document.open();

            BaseFont bf = BaseFont.createFont("c:/Windows/Fonts/malgun.ttf", BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
            Font font = new Font(bf, 9);
            Font titleFont = new Font(bf, 18, Font.BOLD, BaseColor.RED);
            Font avgFont = new Font(bf, 11, Font.BOLD, BaseColor.BLUE);
            Font blueFont = new Font(bf, 10, Font.BOLD, BaseColor.BLUE);

            Paragraph title = new Paragraph("1학년 A반 성적표", titleFont);
            title.setAlignment(Element.ALIGN_CENTER);
            document.add(title);

            double totalSumOfAvg = 0;
            for(Student s : students) totalSumOfAvg += s.average();
            double classAvg = totalSumOfAvg / students.size();

            Paragraph avgInfo = new Paragraph();
            avgInfo.add(new Chunk("반 평균 : " + String.format("%.2f", classAvg) + "\n", avgFont));
            avgInfo.add(new Chunk("학년 평균 : " + String.format("%.2f", classAvg), avgFont));
            avgInfo.setAlignment(Element.ALIGN_RIGHT);
            document.add(avgInfo);
            document.add(new Paragraph("\n"));

            PdfPTable table = new PdfPTable(headers.length);
            table.setWidthPercentage(100);
            float[] widths = {9f, 7f, 4f, 6f, 6f, 6f, 6f, 6f, 6f, 6f, 6f, 6f, 8f, 5f, 5f};
            table.setWidths(widths);

            for (String h : headers) {
                PdfPCell cell = new PdfPCell(new Phrase(h, font));
                cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
                cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                cell.setPadding(5);
                table.addCell(cell);
            }

            Grade gradeEval = new Grade();
            ClassRoom classRoom = new ClassRoom(students);
            BaseColor lightYellow = new BaseColor(255, 255, 180);

            for (int i = 0; i < students.size(); i++) {
                Student s = students.get(i);

                table.addCell(createCell(s.getStudentID(), font, null));
                table.addCell(createCell(s.getName(), font, null));
                table.addCell(createCell(s.getGender(), font, null));

                int kor = s.getSubject(0).getScore();
                table.addCell(createCell(String.valueOf(kor), font, null));
                table.addCell(createCell(gradeEval.getKorGrade(kor), font, null));

                int eng = s.getSubject(1).getScore();
                table.addCell(createCell(String.valueOf(eng), font, null));
                table.addCell(createCell(gradeEval.getEngMathGrade(eng), font, null));

                int mat = s.getSubject(2).getScore();
                table.addCell(createCell(String.valueOf(mat), font, null));
                table.addCell(createCell(gradeEval.getEngMathGrade(mat), font, null));

                int opt = s.getSubject(3).getScore();
                table.addCell(createCell(String.valueOf(opt), font, null));
                table.addCell(createCell(gradeEval.getOptionGrade(opt), font, null));

                table.addCell(createCell(String.valueOf(s.sum()), font, null));
                table.addCell(createCell(String.format("%.2f", s.average()), font, null));

                table.addCell(createCell(String.valueOf(classRoom.getRank(i)), blueFont, lightYellow));
                table.addCell(createCell(String.valueOf(classRoom.getGradeRank(i)), blueFont, lightYellow));
            }

            document.add(table);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (document != null && document.isOpen()) {
                document.close();
            }
        }
    }

    private PdfPCell createCell(String text, Font font, BaseColor bgColor) {
        PdfPCell cell = new PdfPCell(new Phrase(text, font));
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        cell.setPadding(4);
        if (bgColor != null) {
            cell.setBackgroundColor(bgColor);
        }
        return cell;
    }
}