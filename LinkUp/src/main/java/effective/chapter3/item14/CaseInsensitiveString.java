package effective.chapter3.item14;

import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;

//单字段可与对象引用字段比较
public class CaseInsensitiveString implements Comparable<CaseInsensitiveString>{
    private final String s;

    public CaseInsensitiveString(String s) {
        this.s = Objects.requireNonNull(s);
    }

    @Override
    public boolean equals(Object o) {
        return o instanceof CaseInsensitiveString && ((CaseInsensitiveString) o).s.equalsIgnoreCase(s);
    }

    @Override
    public int hashCode() {
        return s.hashCode();
    }

    @Override
    public String toString() {
        return s;
    }

    //使用 String 类已存在的比较方法实现类的比较方法
    @Override
    public int compareTo(CaseInsensitiveString o) {
        return String.CASE_INSENSITIVE_ORDER.compare(s, o.s);
    }

    public static void main(String[] args) {
        Set<CaseInsensitiveString> s = new TreeSet<>();
        s.add(new CaseInsensitiveString("Alice"));
        s.add(new CaseInsensitiveString("Bob"));
        System.out.println(s);
        CaseInsensitiveString alice = new CaseInsensitiveString("Alice");
        String alice2 = "Alice";
        //返回false  虽然值相同，但是对象类型不同
        System.out.println(alice.equals(alice2));
        // 使用的 String类的 hashCode方法，只要值相同 hashCode 就相同
        System.out.println(alice.hashCode() == alice2.hashCode());

        for (CaseInsensitiveString cis : s) {
            if (cis.s.equalsIgnoreCase("Alice")) {
                System.out.println(cis.equals(alice));
                System.out.println(cis.hashCode() == alice.hashCode());
            }
        }
    }
}
