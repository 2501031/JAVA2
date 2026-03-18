public class Main {
    public static void main(String[] args) {
        Book book = new Book("자바의 정석");
        Person lee = new Student("이영희");
        Person kim = new Teacher("김철수", "JAVA");

        ClassRoom classRoom = new ClassRoom(kim, lee);
        classRoom.startClass(book);
    }
}