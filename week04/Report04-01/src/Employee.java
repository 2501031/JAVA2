import java.text.NumberFormat;
public class Employee {
    private int id;
    private String name;
    private Department dept;
    private Grade grade;
    private boolean special;
    private int aid;

    public Employee(int id, String name, Department dept,
                    Grade grade, boolean special, int aid) {
        this.id = id;
        this.name = name;
        this.dept = dept;
        this.grade = grade;
        this.special = special;
        this.aid = aid;
    }

    private int basicDeduct() {
        return (int)(grade.getBasePay() * 0.03);
    }

    private int totalDeduct() {
        return basicDeduct() + aid;
    }

    private int taxable() {
        int totalIncome = grade.getBasePay()
                + grade.getPositionPay()
                + dept.getDutyPay();
        return totalIncome - totalDeduct();
    }

    private int normalTax() {
        int t = taxable();
        if (t < 700000) {
            return 0;
        } else if (t < 800000) {
            return (int)(t * 0.05);
        } else if (t < 1000000) {
            return (int)(t * 0.07);
        } else {
            return (int)(t * 0.09);
        }
    }

    private int specialTax() {
        if (!special) return 0;
        return (int)(grade.getBasePay() * 0.03);
    }

    private int totalTax() {
        return normalTax() + specialTax();
    }

    private int totalPay() {
        int totalIncome = grade.getBasePay()
                + grade.getPositionPay()
                + dept.getDutyPay();
        return totalIncome - totalDeduct() - totalTax();
    }

    private String fmt(int n) {
        return String.format("%,d", n); // %,d 사용[web:101][web:103]
    }

    @Override
    public String toString() {

        return String.format(
                "%-4s %5d  %-4s   %2s  %7s %10s %10s %10s %10s %8s %12s",
                name,
                id,
                dept.getName(),
                "X",                     // 원호는 X로 표시
                grade.toString(),       // "1  -  1"
                fmt(grade.getBasePay()),
                fmt(dept.getDutyPay()),
                fmt(grade.getPositionPay()),
                fmt(totalDeduct()),
                fmt(totalTax()),
                fmt(totalPay())
        );
    }
}