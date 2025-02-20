package w050209;

import java.util.Arrays;

public class W0901 {
    public static void main(String[] args) {
        String r = "2-1";
        String i1 = "12";
        String i2 = "1";
        String i3 ="a1";
        String i4 = "4123";
        String i5 = "a1243";

        System.out.println("校验结果:" + generateRegex(r, i1));
        System.out.println("校验结果:" + generateRegex(r, i2));
        System.out.println("校验结果:" + generateRegex(r, i3));
        System.out.println("校验结果:" + generateRegex(r, i4));
        System.out.println("校验结果:" + generateRegex(r, i5));
    }
    public static boolean generateRegex(String input, String str){
        String preRegex = "^[a-zA-Z0-9]";
        if (input.contains("-")) {
            String[] split = input.split("-");
            for (int i = 0; i < split.length; i++) {
                if (i != 0 && str.isEmpty()) {
                    return true;
                }
                int len = Integer.parseInt(split[i]);
                String regex = preRegex + "{" + len + "}";
                int end = (i+1)*len;
                String subStr = str.substring(0, Math.min(end, str.length()));
                boolean matches = subStr.matches(regex);
                if (!matches) {
                    return false;
                }
                int maxLen = Math.min(str.length(), end);
                str = str.substring(maxLen);
            }
        } else{
            return str.length() == Integer.parseInt(input);
        }
        return true;
    }
}
