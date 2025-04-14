package w050412;

public class MathChange {
    public static void main(String[] args) {
        int num = 32;
        System.out.println("十进制:{"+num+"} , 转二进制:{"+decimalToBinary(num)+"}" );
        System.out.println("十进制:{" + num +"},转八进制:{" + decimalToOctal(num) + "}");
        int num1 = 15;
        System.out.println("十进制:{" + num1 + "}, 转十六进制:{" + decimalToHexadecimal(num1) + "}");
        String num2 = "FF2B5";
        System.out.println("十六进制:{" + num2 + "}, 转十进制:{" + hexadecimalToDecimal(num2) + "}");

    }

    /**
     * 十进制转换二进制
     */
    public static String decimalToBinary(int decimal) {
        StringBuilder binary = new StringBuilder();
        while (decimal > 0) {
            //取余，并将余数设置到字符串开头
            binary.insert(0, decimal % 2);
            //除数
            decimal = decimal / 2;
        }
        //如果数字为 0，则返回 0，否则返回正常数据
        return binary.length() == 0 ? "0" : binary.toString();
    }
    /**
     * 十进制转八进制
     */
    public static String decimalToOctal(int decimal){
        StringBuilder octal = new StringBuilder();
        while (decimal > 0){
            octal.insert(0, decimal % 8);
            decimal = decimal / 8;
        }
        return octal.length() == 0 ? "0" : octal.toString();
    }

    /**
     * 十进制转换十六进制
     */
    public static String decimalToHexadecimal(int decimal){
        StringBuilder haxadecimal = new StringBuilder();
        String hexChars = "0123456789ABCDEF";
        while (decimal > 0){
            int remainder = decimal % 16;
            //charAt方法获取第 i 位的字符。
            haxadecimal.insert(0, hexChars.charAt(remainder));
            decimal = decimal / 16;
        }
        return haxadecimal.length() == 0 ? "0" : haxadecimal.toString();
    }

    /**
     * 二进制转换十进制
     */
    public static int binaryToDecimal(String binary){
        int decimal = 0;
        for (int i = 0; i < binary.length(); i++) {
            int digit = binary.charAt(i) - '0';
            decimal = decimal * 2 + digit;
        }
        return decimal;
    }
    /**
     * 八进制转十进制
     */
    public static int octalToDecimal(String octal){
        int decimal = 0;
        for (int i = 0; i < octal.length(); i++) {
            int digit = octal.charAt(i) - '0';
            decimal = decimal * 8 + digit;
        }
        return decimal;
    }

    /**
     * 十六进制转十进制
     */
    public static int hexadecimalToDecimal(String hexadecimal){
        int decimal = 0;
        int power = 0;
        String hexChars = "0123456789ABCDEF";
        for (int i = hexadecimal.length() - 1; i >= 0; i--) {
            char digit = hexadecimal.charAt(i);
            int value = hexChars.indexOf(digit);
            decimal += (int) (value * Math.pow(16, power));
            power++;
        }
        return decimal;
    }

}
