public class Member {
    private String name;
    private int id;
    private Book borrowedBook; // 한 번에 한 권만

    public Member(String name, int id) {
        this.name = name;
        this.id = id;
    }
    public void join(Library library) {
        library.registerMember(this);
        System.out.printf("%s 님이 %s에 회원 가입했습니다.\n", name, library.getName());
    }
    public void borrowBook(Library library, String title) {
        if (borrowedBook != null) {
            System.out.println("ERROR: 이미 책을 한 권 빌렸습니다. 먼저 반납하세요.");
            return;
        }
        Book book = library.lendBook(title);
        if (book != null) {
            borrowedBook = book;
            System.out.printf("%s 님이 '%s' 책을 대출했습니다.\n", name, title);
        }
    }
    public void returnBook(Library library) {
        if (borrowedBook == null) {
            System.out.println("ERROR: 반납할 책이 없습니다.");
            return;
        }
        library.receiveBook(borrowedBook);
        System.out.printf("%s 님이 '%s' 책을 반납했습니다.\n",
                name, borrowedBook.getTitle());
        borrowedBook = null;
    }
    @Override
    public String toString() {
        String bookInfo = (borrowedBook == null) ?
                "없음" : borrowedBook.getTitle();
        return String.format("회원[%d] %s, 대출중인 책: %s", id, name, bookInfo);
    }
}
