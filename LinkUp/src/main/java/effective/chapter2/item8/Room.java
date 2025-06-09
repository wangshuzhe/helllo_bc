package effective.chapter2.item8;


import java.lang.ref.Cleaner;

public class Room implements AutoCloseable{
    private static final Cleaner cleaner = Cleaner.create();

    @Override
    public void close() {
        cleanable.clean();
    }

    private static class State implements Runnable {
        int numJunkPiles;
        @Override
        public void run() {
            System.out.println("Cleaning Room!");
            numJunkPiles = 0;
        }

        public State(int numJunkPiles) {
            this.numJunkPiles = numJunkPiles;
        }
    }

    private final State state;
    private final Cleaner.Cleanable cleanable;

    public Room(int numJunkPiles) {
        state = new State(numJunkPiles);
        cleanable = cleaner.register(this, state);
    }
}
