public abstract class ElectricCustomer implements IChargeable {
    protected String number;
    protected String name;
    protected int usage;
    protected boolean supported;
    protected final int BASIC_FEE = 1660;

    public ElectricCustomer(String number, String name, int usage) {
        this.number = number;
        this.name = name;
        this.usage = usage;
        this.supported = number.charAt(0) == '9'; // 9로 시작하면 지원가구
    }
    public String getNumber() {
        return number;
    }
    public String getName() {
        return name;
    }
    public int getUsage() {
        return usage;
    }
    public boolean isSupported() {
        return supported;
    }
    protected abstract int calcUsageFeeCore();

    @Override
    public int usageFee() {
        return BASIC_FEE + calcUsageFeeCore();
    }
    @Override
    public int tax() {
        return (int)(usageFee() * 0.07);
    }
    @Override
    public int totalPay() {
        return usageFee() + tax();
    }
    protected String fmt(int n) {
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