import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class Student {
    private String name;
    private String rollno;
    private String depart;
    private LocalDate birthday;
    public Student(String name, String rollno, String depart, int birthYear, int birthMonth, int birthDay) {
        this.name = name;
        this.rollno = rollno;
        this.depart = depart;
        this.birthday = LocalDate.of(birthYear, birthMonth, birthDay);
    }
    public int getAge() {
        LocalDate today = LocalDate.now();
        return Period.between(birthday, today).getYears();
    }
    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return String.format("이름: %s, 학번: %s, 학과: %s, 생년월일: %s, 나이: %d세",
                name, rollno, depart, birthday.format(formatter), getAge());
    }
}
