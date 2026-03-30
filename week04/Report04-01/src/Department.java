public class Department {
    private int code;
    private String name;
    private int dutyPay;

    public Department(int code, String name, int dutyPay) {
        this.code = code;
        this.name = name;
        this.dutyPay = dutyPay;
    }

    public int getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public int getDutyPay() {
        return dutyPay;
    }

    @Override
    public String toString() {
        return String.format("%s", name);
    }
}