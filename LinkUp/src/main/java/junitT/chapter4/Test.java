package junitT.chapter4;

import java.util.ArrayList;
import java.util.List;

/**
 * 泛型传递的时候不会丢失当前类的类型
 */
public class Test {
    private static <T> void as (List<T> t){
        for (T t1 : t) {
            System.out.println(t1.getClass());
        }
    }

    private static <T> void as2(List<T> t) {
        as(t);
    }
    public static void main(String[] args) {
        int i = 2;

        Test test = new Test();
        List<Test> tests = new ArrayList<>();
        tests.add(test);
        as2(tests);
    }
}
