public class Person {
    protected String name;
    protected int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void greet() {
        System.out.printf("안녕하세요, 제 이름은 %s이고 %d살 입니다.\n", name, age);
    }
}