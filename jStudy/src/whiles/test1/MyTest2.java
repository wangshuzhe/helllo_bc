package whiles.test1;

public class MyTest2 {
    public static void main(String[] args) {
        MyList list = new MyList();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(8);
        list.addMid(4, 5);
        list.remove(2);
        for (int i = 7; i < 16; i++) {
            list.add(i);
        }
        for (int i = 0; i < list.getSize(); i++) {
            System.out.println(list.get(i));
        }
    }
}
