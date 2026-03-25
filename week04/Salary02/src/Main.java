import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        Department[] departments = new Department[] {
                new Department('0', ""),
                new Department('1', "인사팀"),
                new Department('2', "재무팀"),
                new Department('3', "영업팀"),
                new Department('4', "개발팀"),
                new Department('5', "생산팀")};
        Grade[] grades = new Grade[]{
                new Grade('0', 0),
                new Grade('1', 1650000),
                new Grade('2', 1680000),
                new Grade('3', 1700000),
                new Grade('4', 1720000),
                new Grade('5', 1750000)
        };

        Employee[] employees = new Employee[] {
                new Employee("홍길동", "1234",
                        new Date(2003, 3,25), departments[1],grades[1]),
                new Employee("이나라", "1345",
                        new Date(2001, 12,25), departments[3],grades[2]),
                new Employee("나정산", "2234",
                        new Date(1995, 5,4), departments[5],grades[3]),
                new Employee("박정환", "1422",
                        new Date(2006, 10,19), departments[2],grades[2]),
                new Employee("김대한", "4352",
                        new Date(2000, 1,25), departments[4],grades[3]),
                new Employee("황정민", "5678",
                        new Date(1998, 7,6), departments[5],grades[1])
        };

        Company company = new Company(employees);
        company.inputData();
        company.display();
    }
}