package effective.chapter3.item10;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * 违反对称性
 */
public class CaseInsensitiveString {
    private final String s;

    public CaseInsensitiveString(String s) {
        this.s = Objects.requireNonNull(s);
    }

/*
    该 equals 方法违反了对称性
    @Override
    public boolean equals(Object o) {
        if (o instanceof CaseInsensitiveString) {
            return s.equalsIgnoreCase(((CaseInsensitiveString) o).s);
        }
        if (o instanceof String) {
            return s.equalsIgnoreCase((String )o);
        }
        return false;
    }
*/

    //正确的 equals 方法
    @Override
    public boolean equals(Object o) {
        return o instanceof CaseInsensitiveString &&
                ((CaseInsensitiveString) o).s.equalsIgnoreCase(s);
    }
    public static void main(String[] args) {
        CaseInsensitiveString cis = new CaseInsensitiveString("Polish");
        String s = "polish";
        String s1 = "Polish";
        //equalsIgnoreCase 方法比较字符串忽略大小写
//        System.out.println(s.equalsIgnoreCase(s1));
        System.out.println(cis.equals(s));
        List<CaseInsensitiveString> list = new ArrayList<>();
        list.add(cis);
        System.out.println(list.contains(s));
        //两个结果不同破坏了一致性，对象比较是相同，但是再集合中判断是否包含该对象是不包含。
    }
}
