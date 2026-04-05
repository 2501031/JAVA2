public class ElectricCustomer {
    private String number;
    private String name;
    private int usage;
    private boolean supported;

    private static final int BASIC_FEE = 1660;

    public ElectricCustomer(String number, String name, int usage) {
        this.number = number;
        this.name = name;
        this.usage = usage;
        this.supported = number.charAt(0) == '9';
    }

    public int getUsage() {
        return usage;
    }

    public int usageFee() {
        return BASIC_FEE + RateTable.calcUsageFee(usage, supported);
    }

    public int tax() {
        return (int)(usageFee() * 0.07);
    }

    public int totalPay() {
        return usageFee() + tax();
    }

    public boolean isSupported() {
        return supported;
    }

    private String fmt(int n) {
        return String.format("%,d원", n);
    }

    @Override
    public String toString() {
        return String.format(
                "%5s %-4s %5dKw %10s %8s %10s %s",
                number,
                name,
                usage,
                fmt(usageFee()),
                fmt(tax()),
                fmt(totalPay()),
                supported ? "지원가구" : ""
        );
    }
}