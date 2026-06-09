import java.util.ArrayList;
public class Student extends Person {
    private String studentID;
    private ArrayList<Subject> subjects;

    public Student(String name, String gender) {
        super(name, gender);
        this.subjects = new ArrayList<>();
        subjects.add(new Subject("국어", 0));
        subjects.add(new Subject("영어", 0));
        subjects.add(new Subject("수학", 0));
        if (getGender().equals("남"))
            subjects.add(new Subject("기술", 0));
        else
            subjects.add(new Subject("가정", 0));
    }

    public void setStudentID(String studentID) { this.studentID = studentID; }
    public String getStudentID() { return studentID; }
    public ArrayList<Subject> getSubjects() { return subjects; }
    public Subject getSubject(int index) { return subjects.get(index); }

    public int sum() {
        int sum = 0;
        for (Subject s : subjects) sum += s.getScore();
        return sum;
    }

    public double average() {
        return Math.round((sum() / (double)subjects.size()) * 100) / 100.0;
    }
}