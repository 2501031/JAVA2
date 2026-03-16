public class Main {
    public static void main(String[] args) {
        Movie1 movie1 = new Movie1("헤라클레스", "레니 할린", 2014, "켈란 루츠", 6.9f);
        Movie2 movie2 = new Movie2("노아", "대런 아로노프스키", 2004, "러셀 크로우", 8.2f);

        System.out.println(movie1);
        System.out.println("-----------------------");
        System.out.println(movie2);
        System.out.println("-----------------------");
        System.out.println(movie1.getDirector());
    }
}