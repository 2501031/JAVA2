import java.util.Arrays;
import java.util.Comparator;

public class PowerOffice {
    private ElectricCustomer[] customers;

    public PowerOffice(ElectricCustomer[] customers) {
        this.customers = customers;
    }

    private void sortByTotalPayDesc() {
        Arrays.sort(customers, new Comparator<ElectricCustomer>() {
            @Override
            public int compare(ElectricCustomer o1, ElectricCustomer o2) {
                return Integer.compare(o2.totalPay(), o1.totalPay());
            }
        });
    }

    public void display() {
        sortByTotalPayDesc();
        line();
        System.out.println("번호   이름   사용량   사용요금      세금     납부금액   기타");
        line();
        for (ElectricCustomer c : customers) {
            System.out.println(c);
        }
        line();
    }

    private void line() {
        for (int i = 0; i < 80; i++) {
            System.out.print("*");
        }
        System.out.println();
    }
}