package effective.chapter3.item12;

public class PhoneNumber {
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

    /**
     * 实现 toString方法，指定当前对象的输出方式。
     * 返回该电话号码的字符串表示形式,字符串由12个字符组成，格式为 “XXX-YYY- zzzz”。
     * 其中XXX为区号,YYY为前缀，ZZZZ为行号。 如果电话号码的长度不够对应位置的大小，那么就自动补上 0
     *
     * @param args
     */
    @Override
    public String toString() {
        return String.format("%03d-%03d-%04d", areaCode, prefix, lineNum);
    }

    public static void main(String[] args) {
        PhoneNumber pn1 = new PhoneNumber(707, 867, 5309);
        System.out.println(pn1);
    }
}
