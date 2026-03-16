import java.time.LocalDate;
public class Main {
    public static void main(String[] args) {
        Date birthday = new Date(2006, 10, 19);
        System.out.println("1. 생년월일 : "+ birthday);

        LocalDate today = LocalDate.now();
        Date todayDate = new Date(today.getYear(), today.getMonthValue(), today.getDayOfMonth());
        System.out.println("2. 오늘 날짜: " + todayDate);

        Date Year1 = new Date(2025, 2, 29);
        System.out.println("3. 날짜: " + Year1);

        Year1.setYear(2023);
        System.out.println("4. 년도 수정 후: " + Year1);
    }
}