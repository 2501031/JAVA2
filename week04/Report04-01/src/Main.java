import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Department[] departments = new Department[] {
                new Department(1, "경리과", 250000),
                new Department(2, "인사과", 250000),
                new Department(3, "영업팀", 350000),
                new Department(4, "생산과", 350000),
                new Department(5, "A/S 팀", 300000)
        };

        System.out.print("사원 수를 입력하세요: ");
        int n = sc.nextInt();
        sc.nextLine();

        Employee[] employees = new Employee[n];

        for (int i = 0; i < n; i++) {
            System.out.println("\n[" + (i + 1) + "번째 사원 정보 입력]");

            System.out.print("이름(한글): ");
            String name = sc.nextLine();

            System.out.print("사번(5자리 숫자): ");
            int id = sc.nextInt();

            System.out.print("부서코드 (1:경리과, 2:인사과, 3:영업팀, 4:생산과, 5:A/S팀): ");
            int deptCode = sc.nextInt();

            System.out.print("급 (1~3): ");
            int grade = sc.nextInt();

            System.out.print("호 (1~5): ");
            int step = sc.nextInt();

            System.out.print("보훈 대상자 여부(true/false): ");
            boolean special = sc.nextBoolean();

            System.out.print("개인 공제금(개인 저축, 최대 300000): ");
            int aid = sc.nextInt();
            sc.nextLine();

            Department dept = null;
            for (Department d : departments) {
                if (d.getCode() == deptCode) {
                    dept = d;
                    break;
                }
            }

            if (dept == null) {
                System.out.println("부서코드 오류, 기본 경리과로 설정합니다.");
                dept = departments[0];
            }

            Grade g = new Grade(grade, step);

            employees[i] = new Employee(
                    id,
                    name,
                    dept,
                    g,
                    special,
                    aid
            );
        }

        Company company = new Company(employees);
        company.display();

        sc.close();
    }
}