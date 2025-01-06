package whiles.test1;

import java.util.Arrays;

public class MyList {
    private int[] arr;
    private int capacity = 10;
    private int size = 0;
    private int extendRatio = 2;

    public MyList() {
        this.arr = new int[capacity];
    }
    public int getSize(){
        return this.size;
    }
    public int getCapacity() {
        return this.capacity;
    }

    public int get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("索引越界");
        }
        return arr[index];
    }

    public void add(int value) {
        if (size == getCapacity()) {
            extendCapatity();
        }
        arr[size] = value;
        size++;
    }

    public void addMid(int index, int num) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("索引越界");
        }
        if (size == getCapacity()) {
            extendCapatity();
        }
        for (int j = size - 1; j >= index; j--) {
            arr[j + 1] = arr[j];
        }
        arr[index] = num;
        size++;
    }

    public int remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("索引越界");
        }
        int num = arr[index];
        for (int i = index; i < size - 1; i++) {
            arr[i] = arr[i + 1];
        }
        size--;
        return num;
    }

    public void extendCapatity() {
        arr = Arrays.copyOf(arr, capacity * extendRatio);
        capacity = arr.length;
    }
    public int[] toArray() {
        int size = getSize();
        int [] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = get(i);
        }
        return arr;
    }
}
