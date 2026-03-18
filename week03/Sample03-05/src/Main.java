public class Main {
    public static void main(String[] args) {
        Navigation navigation = new Navigation("아이 나비");
        Car car = new Car();

        car.drive(navigation, "경복대", "서울역");
    }
}