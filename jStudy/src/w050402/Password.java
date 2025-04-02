package w050402;

import java.io.Console;
import java.util.Arrays;

public class Password {
    public static void main(String[] args) {
        //在终端执行才能获取到 Console对象，终端执行时package 需要删除
        Console console = System.console();
        if (console == null) {
            System.out.println("no console!");
            System.exit(1);
        }
        String name = console.readLine("Enter your login:");
        char[] oldPassword = console.readPassword("Enter your password:");
        if (verify(name, oldPassword))  {
            char[] newPassword1 = console.readPassword("Enter new password:");
            char[] newPassword2 = console.readPassword("Enter new password again:");
            boolean match = true;
            match = !Arrays.equals(newPassword1, newPassword2);
            if (match) {
                console.format("Password don't match. Try again.%n");
            } else {
                changer(name, newPassword1);
                console.format("Password for %s changed.%n", name);
            }
            Arrays.fill(newPassword1, ' ');
            Arrays.fill(newPassword2, ' ');
        }
        Arrays.fill(oldPassword, ' ');
    }
    private static boolean verify(String name, char[] password) {
        return true;
    }
    private static void changer(String name, char[] oldPassword) {
    }
}
