public class Library {
    private String name;
    private Book[] books;
    private int bookCount;

    public Library(String name, int maxBookCount) {
        this.name = name;
        this.books = new Book[maxBookCount];
        this.bookCount = 0;
    }

    public String getName() {
        return name;
    }

    public void registerMember(Member member) {
    }
    public void addBook(Book book) {
        if (bookCount < books.length) {
            books[bookCount++] = book;
        }
    }
    public Book lendBook(String title) {
        for (int i = 0; i < bookCount; i++) {
            Book b = books[i];
            if (b.getTitle().equals(title)) {
                if (b.borrow()) {
                    return b;
                } else {
                    return null;
                }
            }
        }
        System.out.println("ERROR: 해당 제목의 책이 없습니다. (" + title + ")");
        return null;
    }

    public void receiveBook(Book book) {
        book.giveBack();
    }

    public void showStatus() {
        System.out.println("=== " + name + " 도서 대출 상황 ===");
        for (int i = 0; i < bookCount; i++) {
            System.out.println(books[i]);
        }
        System.out.println("==============================");
    }
}
