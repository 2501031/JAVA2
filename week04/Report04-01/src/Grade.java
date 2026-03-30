public class Grade {
    private int grade;
    private int step;
    private int basePay;
    private int positionPay;

    public Grade(int grade, int step) {
        this.grade = grade;
        this.step = step;
        this.basePay = calcBasePay(grade, step);
        this.positionPay = calcPositionPay(grade);
    }
    private int calcBasePay(int g, int s) {
        int[][] table = {
                {},
                {0, 1250000, 1200000, 1150000, 1100000, 1050000},
                {0,  950000,  925000,  900000,  875000,  850000},
                {0,  750000,  725000,  700000,  675000,  650000}
        };
        return table[g][s];
    }

    private int calcPositionPay(int g) {
        switch (g) {
            case 1: return 300000;
            case 2: return 200000;
            case 3: return 100000;
            default: return 0;
        }
    }

    public int getGrade() {
        return grade;
    }
    public int getStep() {
        return step;
    }
    public int getBasePay() {
        return basePay;
    }
    public int getPositionPay() {
        return positionPay;
    }
    @Override
    public String toString() {
        return String.format("%d  -  %d", grade, step);
    }
}