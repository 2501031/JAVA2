public class Movie1 {
    private String title;
    private String director;
    private int year;
    private String actor;
    private float score;

    public Movie1(String title, String director, int year, String actor, float score) {
        this.title = title;
        this.director = director;
        this.year = year;
        this.actor = actor;
        this.score = score;
    }

    public String getDirector() {
        return director;
    }

    @Override
    public String toString() {
        return String.format("제목 : %s\n" +
                "감독 : %s\n" +
                "개봉 : %d\n" +
                "주연 : %s\n" +
                "평점 : %.1f", title, director, year, actor, score);
    }
}
