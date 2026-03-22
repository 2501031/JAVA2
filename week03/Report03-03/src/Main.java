public class Main {
    public static void main(String[] args) {
        Library library = new Library("경복 도서관", 10);

        Book b1 = new Book("자바 프로그래밍", 3);
        Book b2 = new Book("파이썬 입문", 2);
        library.addBook(b1);
        library.addBook(b2);

        Member m1 = new Member("영희", 1);
        Member m2 = new Member("철수", 2);

        m1.join(library);
        m2.join(library);

        m1.borrowBook(library, "자바 프로그래밍");
        m2.borrowBook(library, "자바 프로그래밍");

        library.showStatus();

        m1.returnBook(library);
        m2.returnBook(library);

        library.showStatus();
    }
}