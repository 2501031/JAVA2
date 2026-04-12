public class SupportedCustomer extends ElectricCustomer {

    public SupportedCustomer(String number, String name, int usage) {
        super(number, name, usage);
        this.supported = true;
    }

    @Override
    protected int calcUsageFeeCore() {
        int chargeUsage;
        if (usage <= 100) {
            chargeUsage = 0;
        } else {
            chargeUsage = usage - 100;
        }

        int fee = 0;
        int remain = chargeUsage;

        int block = Math.min(remain, 100);
        if (block > 0) {
            fee += Math.round(block * 184.1);
            remain -= block;
        }

        block = Math.min(remain, 100);
        if (block > 0) {
            fee += Math.round(block * 223.8);
            remain -= block;
        }

        block = Math.min(remain, 100);
        if (block > 0) {
            fee += Math.round(block * 278.3);
            remain -= block;
        }

        block = Math.min(remain, 100);
        if (block > 0) {
            fee += Math.round(block * 353.6);
            remain -= block;
        }

        block = Math.min(remain, 100);
        if (block > 0) {
            fee += Math.round(block * 466.4);
            remain -= block;
        }

        if (remain > 0) {
            fee += Math.round(remain * 643.9);
        }

        return fee;
    }
}