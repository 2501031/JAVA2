import java.util.ArrayList;
public class ClassRoom {
    private ArrayList<Student> students;

    public ClassRoom(ArrayList<Student> students) {
        this.students = students;
    }

    public int getGradeRank(int index) {
        int rank = 1;
        int targetSum = students.get(index).sum();
        for (Student s : students) {
            if (s.sum() > targetSum) rank++;
        }
        return rank;
    }

    public int getRank(int index) {
        return getGradeRank(index);
    }
}