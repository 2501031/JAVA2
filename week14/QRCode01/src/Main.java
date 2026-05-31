import com.google.zxing.BarcodeFormat;

import java.util.Scanner;

public class Main {
    public static void main() {
        String path = ".\\data\\";
        String fileName = "barcode128.png";
        Scanner keyboard = new Scanner(System.in);
        String data;

        while (true){
            System.out.print("Barcode 문자열 입력(영문자, 숫자) : ");
            data = keyboard.nextLine();

            if (data != null){
                break;
            }
        }

        ZXingHandler handler = new ZXingHandler();
        handler.encoding(data, BarcodeFormat.CODE_128, path+fileName);

    }
}