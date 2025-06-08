package effective.chapter2.item3.enumtype;

/**
 * Enum singleton - the preferred approach(Page 18)
 * 枚举单例 - 首选方法
 *
 */
public enum Elvis {
    INSTANCE;

    void leaveTheBuilding() {
        System.out.println("Who a baby, I'm outta here!");
    }

    /**
     * This code would normally appear outside the class!
     * @param args
     */
    public static void main(String[] args) {
        Elvis elvis = Elvis.INSTANCE;
        elvis.leaveTheBuilding();
    }
}
