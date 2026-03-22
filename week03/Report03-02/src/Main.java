public class Main {
    public static void main(String[] args) {
        Person younghee = new Teacher("영희", 24);
        Person cheolsu = new Doctor("철수", 45);
        Person minsu = new Engineer("민수", 35);

        younghee.greet();
        cheolsu.greet();
        minsu.greet();

        ((Teacher)younghee).teach();
        ((Teacher)younghee).grade();
        ((Doctor)cheolsu).treat();
        ((Doctor)cheolsu).operate();
        ((Engineer)minsu).develop();
        ((Engineer)minsu).fixBug();
    }
}
