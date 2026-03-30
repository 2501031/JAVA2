public class Company {
    private Employee[] employees;

    public Company(Employee[] employees) {
        this.employees = employees;
    }

    public void display() {
        line();
        System.out.println();
        System.out.println("   이름   사번  부서명  원호   급-호        본봉      업무수당    직급수당    공제금액      세금       수령액");
        line();
        System.out.println();
        for (Employee e : employees) {
            System.out.println(e);
        }
        line();
        System.out.println();
    }

    private void line() {
        for (int i = 0; i < 110; i++) {
            System.out.print("-");
        }
    }
}