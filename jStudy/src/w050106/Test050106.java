package w050106;

import java.util.List;

public class Test050106 {
    public static void main(String[] args) {
        ArrayHashMap map = new ArrayHashMap();
        for (int i = 0; i < 100; i++) {
            map.put(i, String.valueOf('a' + i));
        }
        map.print();
        map.remove(5);
        map.remove(1);
        map.remove(5);
        map.remove(12);
        System.out.println("------");
        List<Integer> integers = map.keySet();
        for (Integer integer : integers) {
            System.out.println(integer);
        }
        System.out.println("------");
        List<String> strings = map.valueSet();
        for (String string : strings) {
            System.out.println(string);
        }
        System.out.println("--------");
        List<Pair> pairList = map.pairSet();
        for (Pair pair : pairList) {
            System.out.println(pair.getKey() + " -> " + pair.getVal());
        }
    }
}
