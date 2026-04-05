public class RateTable {

    public static double getNormalUnitPrice(int usage) {
        if (usage <= 100) {
            return 184.1;
        } else if (usage <= 200) {
            return 223.8;
        } else if (usage <= 300) {
            return 278.3;
        } else if (usage <= 400) {
            return 353.6;
        } else if (usage <= 500) {
            return 466.4;
        } else {
            return 643.9;
        }
    }

    public static int calcUsageFee(int usage, boolean supported) {
        int chargeUsage = usage;
        if (supported) {
            if (usage <= 100) {
                chargeUsage = 0;
            } else {
                chargeUsage = usage - 100;
            }
        }

        int fee = 0;
        int remain = chargeUsage;

        int block = Math.min(remain, 100);
        if (block > 0) {
            fee += (int)Math.round(block * 184.1);
            remain -= block;
        }

        block = Math.min(remain, 100);
        if (block > 0) {
            fee += (int)Math.round(block * 223.8);
            remain -= block;
        }

        block = Math.min(remain, 100);
        if (block > 0) {
            fee += (int)Math.round(block * 278.3);
            remain -= block;
        }

        block = Math.min(remain, 100);
        if (block > 0) {
            fee += (int)Math.round(block * 353.6);
            remain -= block;
        }

        block = Math.min(remain, 100);
        if (block > 0) {
            fee += (int)Math.round(block * 466.4);
            remain -= block;
        }

        if (remain > 0) {
            fee += (int)Math.round(remain * 643.9);
        }

        return fee;
    }
}