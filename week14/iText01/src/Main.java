public class Main {
    public static void main() {
        String path = ".\\data\\";
        String fileName = "bookInvoice.pdf";

        Book[] books = new Book[]{
                new Book("JAVA Programing 완전 정복", 22000, 5, "1234567891012"),
                new Book("Android Programing 완전 정복", 32000, 5, "1244567291012")
        };
        ItextHandler itextHandler = new ItextHandler();
        itextHandler.makePDF(books, path+fileName);
    }
}