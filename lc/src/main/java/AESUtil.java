import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;
import java.util.Scanner;

public class AESUtil {

    public static void main(String args[]) throws Exception{
        String key = "123asdzx";
        String iv = "123asdzx";
        Boolean f = true;
        int menu;
        while (f) {
            System.out.println("------------------");
            System.out.println("------------------");
            System.out.println("------------------");
            System.out.println("请选择要执行的方法(选择对应数字)");
            System.out.println("1、加密");
            System.out.println("2、解密");
            System.out.println("3、退出");
            Scanner scanner = new Scanner(System.in);
            String next = scanner.next();
            menu = Integer.valueOf(next);
            if (1 == menu) {
                System.out.println("请输入要加密的字符串:");
                Scanner s = new Scanner(System.in);
                String str = s.nextLine();
                byte[] encrypted = AES_CBC_Encrypt(str.getBytes(), key.getBytes(), iv.getBytes());
                String aesStr = encryptBASE64(encrypted);
                System.out.println("加密前字符串:" + str);
                System.out.println("加密后字符串:" + aesStr);
            } else if (2 == menu) {
                System.out.println("请输入要解密的字符串:");
                Scanner s = new Scanner(System.in);
                String str = s.nextLine();
                byte[] decrypted = AES_CBC_Decrypt(decryptBASE64(str), key.getBytes(), iv.getBytes());
                System.out.println("解密前字符串:" + str);
                System.out.println("解密后字符串:" + byteToString(decrypted));
            } else {
                System.out.println("程序结束!");
                break;
            }
        }

    }
    public static String byteToString(byte[] byte1){
        return new String(byte1);
    }

    public static byte[] AES_CBC_Encrypt(byte[] content, byte[] keyBytes, byte[] iv){
        try {
            SecretKeySpec key = new SecretKeySpec(keyBytes, "AES");
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE,key, new IvParameterSpec(iv));
            byte[] result = cipher.doFinal(content);
            return result;
        } catch (Exception e) {
        }
        return null;
    }

    public static byte[] AES_CBC_Decrypt(byte[] content, byte[] keyBytes, byte[] iv){
        try {
            SecretKeySpec key = new SecretKeySpec(keyBytes, "AES");
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher.init(Cipher.DECRYPT_MODE,key, new IvParameterSpec(iv));
            byte[] result = cipher.doFinal(content);
            return result;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    //字符串装换成base64
    public static byte[] decryptBASE64(String key) throws Exception {
        return Base64.getDecoder().decode(key);
    }
    //base64装换成字符串
    public static String encryptBASE64(byte[] key) throws Exception {
        return Base64.getEncoder().encodeToString(key);
    }
}
