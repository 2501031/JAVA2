public class Grade {
    public String getKorGrade(int score) {
        switch (score / 10) {
            case 10: case 9: return "수";
            case 8: return "우";
            case 7: return "미";
            case 6: return "양";
            default: return "가";
        }
    }

    public String getEngMathGrade(int score) {
        if (score >= 95) return "A+";
        switch (score / 10) {
            case 10: case 9: return "A0";
            case 8: return (score >= 85) ? "B+" : "B0";
            case 7: return (score >= 75) ? "C+" : "C0";
            case 6: return (score >= 65) ? "D+" : "D0";
            default: return "F";
        }
    }

    public String getOptionGrade(int score) {
        if (score >= 90) return "A";
        else if (score >= 80) return "B";
        else if (score >= 70) return "C";
        else if (score >= 60) return "D";
        else return "F";
    }
}