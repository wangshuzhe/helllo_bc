package effective.chapter3.item14;

import java.util.NavigableSet;
import java.util.TreeSet;
import java.util.concurrent.ThreadLocalRandom;

public class PhoneNumber implements Cloneable, Comparable<PhoneNumber>{


    private final short areaCode, prefix, lineNum;

    public PhoneNumber(int areaCode, int prefix, int lineNum) {
        this.areaCode = rangeCheck(areaCode, 999, "area code");
        this.prefix   = rangeCheck(prefix,   999, "prefix");
        this.lineNum  = rangeCheck(lineNum, 9999, "line num");
    }

    private static short rangeCheck(int val, int max, String arg) {
        if (val < 0 || val > max)
            throw new IllegalArgumentException(arg + ": " + val);
        return (short) val;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof PhoneNumber))
            return false;
        PhoneNumber pn = (PhoneNumber)o;
        return pn.lineNum == lineNum && pn.prefix == prefix
                && pn.areaCode == areaCode;
    }

    @Override
    public int hashCode() {
        int result = Short.hashCode(areaCode);
        result = 31 * result + Short.hashCode(prefix);
        result = 31 * result + Short.hashCode(lineNum);
        return result;
    }

    @Override
    public String toString() {
        return String.format("%03d-%03d-%04d", areaCode, prefix, lineNum);
    }

    /**
     * 克隆没有引用可变状态的类的方法
     *
     *
     */
    @Override
    public PhoneNumber clone() {
        try {
            return  (PhoneNumber) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 两种比较方法
     *
     */
    //1. 基本字段比较的多字段
    public int compareTo(PhoneNumber phoneNumber) {
        int result = Short.compare(areaCode, phoneNumber.areaCode);
        if (result == 0) {
            result = Short.compare(prefix, phoneNumber.prefix);
            if (result == 0) {
                result = Short.compare(lineNum, phoneNumber.lineNum);
            }
        }
        return result;
    }

    /**
     * 随机生成电话号码
     *
     */
    private static PhoneNumber randomPhoneNumber() {
        ThreadLocalRandom current = ThreadLocalRandom.current();
        return new PhoneNumber((short) current.nextInt(1000),
                (short) current.nextInt(1000),
                (short) current.nextInt(10000));

    }
    public static void main(String[] args) {
        NavigableSet<PhoneNumber> s = new TreeSet<>();
        for (int i = 0; i < 10; i++) {
            s.add(randomPhoneNumber());
        }
        System.out.println(s);
    }
}
