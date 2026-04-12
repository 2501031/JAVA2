public class NormalCustomer extends ElectricCustomer {

    public NormalCustomer(String number, String name, int usage) {
        super(number, name, usage);
    }

    @Override
    protected int calcUsageFeeCore() {
        int fee = 0;
        int remain = usage;

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