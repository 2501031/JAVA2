import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        Customer[] customers = new Customer[]{
                new Customer("홍길동", new Date(1999,4,8),
                        "123-4567-8978", new DiscountPlan()),
                new Customer("박길동", new Date(2016,4,8),
                        "123-4567-8978", new DiscountPlan()),
                new Customer("이노인", new Date(1940,4,8),
                        "123-4567-8978", new BasicPlan()),
                new Customer("박길동", new Date(2016,4,8),
                        "123-4567-8978", new DiscountPlan())
        };

        PhoneOffice office = new PhoneOffice(customers);
        office.inputData();
        office.display();

    }
}