package effective.chapter3.item11;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class PhoneNumber {
    private final short areaCode, prefix, lineNum;

    public PhoneNumber(int areaCode, int prefix, int lineNum) {
        this.areaCode = rangeCheck(areaCode, 999, "areaCode");
        this.prefix = rangeCheck(prefix, 999, "prefix");
        this.lineNum = rangeCheck(lineNum, 9999, "lineNum");
    }

    private static short rangeCheck(int val, int max, String arg) {
        if (val < 0 || val > max) {
            throw new IllegalArgumentException();
        }
        return (short) val;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof PhoneNumber)) {
            return false;
        }
        return areaCode == ((PhoneNumber) o).areaCode &&
                prefix == ((PhoneNumber) o).prefix &&
                lineNum == ((PhoneNumber) o).lineNum;
    }

    /**
     * 没有 hashCode适用于以下三种
     */

    //1经典的 hashCode 方法
/*
    @Override
    public int hashCode() {
        int result = Short.hashCode(areaCode);
        result = 31 * result + Short.hashCode(prefix);
        result = 31 * result + Short.hashCode(lineNum);
        return result;
    }
*/
    //2.一行hashCode方法，性能一般。
/*
    @Override
    public int hashCode() {
        return Objects.hash(areaCode, prefix, lineNum);
    }
*/
    //3.延迟初始化缓存哈希码
/*
    private int hashCode;

    @Override
    public int hashCode() {
        int result = hashCode;
        if (result == 0) {
            result = Short.hashCode(areaCode);
            result = 31 * result + Short.hashCode(prefix);
            result = 31 * result + Short.hashCode(lineNum);
        }
        return result;
    }
*/

    public static void main(String[] args) {
        Map<PhoneNumber, String> map = new HashMap<>();
        PhoneNumber p1 = new PhoneNumber(707, 867, 5309);
        map.put(p1, "Jenny");
        PhoneNumber p2 = new PhoneNumber(707, 867, 5309);
        System.out.println(map.get(p2));
        /**
         *未重写 hashCode() 时的行为：
         * 每个 PhoneNumber 实例会使用默认的 Object.hashCode()，返回的是对象的内存地址。
         * 即使两个对象的内容完全相同（如在 main 函数中创建的两个 PhoneNumber 对象），它们的哈希码仍然不同，因为它们是不同的实例。
         * HashMap 的工作原理：
         * 当你调用 map.put(key, value) 时，HashMap 使用 key.hashCode() 决定将键值对放在哪个桶中。
         * 当你调用 map.get(key) 时，它再次使用 hashCode() 找到正确的桶，然后使用 equals() 来查找匹配的键。
         * 如果 hashCode() 不一致，即使 equals() 判断为相等，HashMap 也无法找到对应的键。
         * 为什么加上 hashCode() 就可以？
         * 当你提供了与 equals() 一致的 hashCode() 方法（无论哪种方式实现），相同的对象就会具有相同的哈希码。
         * 这样，HashMap 能够正确地定位桶并找到匹配的键。
         */
        //不实现 hashCode 方法的时候，即使两个对象的值一样，hashCode 值也是不一样的
        System.out.println("p1 hashCode: " + p1.hashCode());
        System.out.println("p2 hashCode: " + p2.hashCode());
    }

}
