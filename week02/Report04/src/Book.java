public class Book {
    private String title;
    private String author;

    public Book(String author, String title) {
        this.author = author;
        this.title = title;
    }
    @Override
    public String toString() {
        return String.format("책 제목 : %s, 저자 : %s", title, author);
    }
}
