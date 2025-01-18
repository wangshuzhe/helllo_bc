public class Main {
    public static void main(String[] args) {
        String a1 = "(V_PAY_PLAN_VOUCHERH___QPRO_CAT_CODEH___Q=='1')or (V_PAY_PLAN_VOUCHERH___QPRO_CAT_CODEH___Q=='21')";
        String a2 = "(V_PAY_PLAN_VOUCHERH___QPRO_CAT_CODEH___Q!='1' )  or (V_PAY_PLAN_VOUCHERH___QPRO_CAT_CODEH___Q!='21')";
        String a3 = "(testtableH___QAGENCYH___Q=='1') or (testtableH___QAMTH___Q =='2')";

        String[] split = a1.split(" and | or ");
        System.out.println("a1-----");
        for (String s : split) {
            System.out.println(s.split("H___Q").length);
        }
        System.out.println("a1-------");
        String[] split1 = a2.split(" and | or ");

        System.out.println("a2-----");
        for (String s : split1) {
            System.out.println(s.split("H___Q").length);

        }
        System.out.println("a2-------");
        System.out.println();
        String[] split2 = a3.split(" and | or ");
        System.out.println("a3-----");
        for (String s : split2) {
            System.out.println(s);
        }
        System.out.println("a3-------");
        System.out.println();

        System.out.println("Hello, World!");
    }
}