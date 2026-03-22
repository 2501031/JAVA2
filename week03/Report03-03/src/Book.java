public class Book {
    private String title;
    private int totalCopy;
    private int borrowedCopy;

    public Book(String title, int totalCopy) {
        this.title = title;
        this.totalCopy = totalCopy;
        this.borrowedCopy = 0;
    }
    public String getTitle() {
        return title;
    }
    public boolean isAvailable() {
        return borrowedCopy < totalCopy;
    }
    public boolean borrow() {
        if (isAvailable()) {
            borrowedCopy++;
            return true;
        } else {
            System.out.println("ERROR: 대출 가능 권수가 없습니다. (" + title + ")");
            return false;
        }
    }
    public void giveBack() {
        if (borrowedCopy > 0) {
            borrowedCopy--;
        }
    }
    @Override
    public String toString() {
        return String.format("Book 제목: %s, 전체: %d권, 대출중: %d권",
                title, totalCopy, borrowedCopy);
    }
}
