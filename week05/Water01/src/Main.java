import java.io.IOException;

public class Main {
    public static void main() throws IOException {
        Customer[] customers = new Customer[]{
                new Customer("홍길동", "1234", '1'),
                new Customer("홍길동", "2234", '2'),
                new Customer("홍길동", "3234", '3'),
                new Customer("홍길동", "5678", '4'),
                new Customer("홍길동", "9999", '5'),
        };

        WaterOffice office = new WaterOffice(customers);
        office.inputData();
        office.display();
    }
}