public class Doctor extends Person {
    public Doctor(String name, int age) {
        super(name, age);
    }

    public void treat() {
        System.out.printf("%s 의사가 환자를 진료합니다.\n", name);
    }

    public void operate() {
        System.out.printf("%s 의사가 수술도 진행합니다.\n", name);
    }
}
