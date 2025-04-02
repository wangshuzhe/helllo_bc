package w050402;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class DataStreams {
    static final String dataFile = "/Users/wangshuzhe/project/ym_project/project_szw/jStudy/src/w050402/123.txt";
    static final double[] prices = { 19.99, 9.99, 15.99, 3.99, 4.99 };
    static final int[] units = { 12, 8, 13, 29, 50};
    static final String[] descs = {
            "Java T-shirt",
            "Java Mug",
            "Duke Juggling Dolls",
            "Java Pin",
            "Java Key Chain"
    };

    public static void main(String[] args) throws IOException {
        DataOutputStream out = null;
        try {
            out = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(dataFile)));
            for (int i = 0; i < prices.length; i++) {
                out.writeDouble(prices[i]);
                out.writeInt(units[i]);
                out.writeUTF(descs[i]);
            }
        } finally {
            if (out != null) {
                out.close();
            }
        }
        DataInputStream in = null;
        try {
            double total = 0.0;
            in = new DataInputStream(new BufferedInputStream(new FileInputStream(dataFile)));
            double price;
            int unit;
            String desc;
            try {
                while (true) {
                    price = in.readDouble();
                    unit = in.readInt();
                    desc = in.readUTF();
                    System.out.format("You ordered %d units of %s at $%.2f%n", unit, desc, price);
                    total += unit * price;
                }
            } catch (IOException e) {

            }
            System.out.format("For a TOTAL of: $%.2f%n", total);
        } finally {
            if (in != null) {
                in.close();
            }
        }

    }
}
