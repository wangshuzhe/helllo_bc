package w050106;

public class Test050106_2 {
    public static void main(String[] args) {
        HashMapChaining map = new HashMapChaining();
        map.put(6, String.valueOf('a' + 6));
        map.put(2, String.valueOf('a' + 2));
        map.put(5, String.valueOf('a' + 5));
        map.print();
        map.remove(5);
        map.remove(2);
        System.out.println("-----");
        map.print();

    }
}
