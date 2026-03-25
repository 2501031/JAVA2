import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        Employee[] employees = new Employee[] {
                new Employee("홍길동", "1234",
                        new Date(2003, 3,25), '1','1'),
                new Employee("이나라", "1345",
                        new Date(2001, 12,25), '3','2'),
                new Employee("나정산", "2234",
                        new Date(1995, 5,4), '5','5'),
                new Employee("박정환", "1422",
                        new Date(2006, 10,19), '2','4'),
                new Employee("김대한", "4352",
                        new Date(2000, 1,25), '4','3'),
                new Employee("황정민", "5678",
                        new Date(1998, 7,6), '5','2')
        };

        Company company = new Company(employees);
        company.inputData();
        company.display();
    }
}