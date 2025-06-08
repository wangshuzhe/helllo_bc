package effective.chapter2.item3.field;

/**
 *
 Singleton with public final field
 带有公共 final 字段的 Singleton （第 17页）
 */
public class Elvis {
    public static final Elvis INSTANCE = new Elvis();

    public Elvis() {
    }

    public void leaveTheBuilding() {
        System.out.println("Who a baby, I'm outta here!");
    }

    public static void main(String[] args) {
        Elvis elvis = Elvis.INSTANCE;
        elvis.leaveTheBuilding();
    }
}
