package demo;

import java.util.Locale;

public class String125 {
    public static void main(String[] args) {
//        String s = "A man, a plan, a canal: Panama";
        String s = "amanaplanacanalPanama";
//        String s = "abcddcba";
        boolean palindrome = isPalindrome(s);
        System.out.println(palindrome);
    }
    public static boolean isPalindrome(String s) {
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isLetterOrDigit(c)) {
                str.append(String.valueOf(c).toLowerCase(Locale.ROOT));
            }
        }
        String a1 = str.toString();
        int l = 0, r = str.length() - 1;
        while (l <= r) {
            if (a1.charAt(l) == a1.charAt(r)) {
                l++;
                r--;
            } else {
                return false;
            }
        }
        return true;
    }
}
