package effective.chapter2.item8;

// Well-behaved client of resource with cleaner safety-net (Page 33)
public class Adult {
    public static void main(String[] args) {
        try (Room room = new Room(7)) {
            System.out.println("GoodBye");
        }
        System.out.println("清理下一个!");
        Room room = new Room(1);
        room.close();
    }
}
