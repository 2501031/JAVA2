import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = 10;
        ElectricCustomer[] customers = new ElectricCustomer[n];
        String[] nums  = {"12345","92345","12346","12347","92346",
                "12348","12349","92347","12350","92348"};
        String[] names = {"정상진","일본인","홍길동","한국인","고길동",
                "이대한","이기동","박종호","이니나","윤상열"};

        for (int i = 0; i < n; i++) {
            System.out.printf("%s 고객의 사용량 입력 : ", names[i]);
            int usage = sc.nextInt(); // 0 ~ 9999 kWh

            if (nums[i].charAt(0) == '9') {
                customers[i] = new SupportedCustomer(nums[i], names[i], usage);
            } else {
                customers[i] = new NormalCustomer(nums[i], names[i], usage);
            }
        }

        PowerOffice office = new PowerOffice(customers);
        office.display();

        sc.close();
    }
}