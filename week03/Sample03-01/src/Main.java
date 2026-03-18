public class Main {
    public static void main(String[] args) {
        Book book = new Book("자바의 정석");
        Student lee = new Student("이영희");
        Teacher kim = new Teacher("김철수", "JAVA");

        kim.teach();
        lee.study(book);
    }
}