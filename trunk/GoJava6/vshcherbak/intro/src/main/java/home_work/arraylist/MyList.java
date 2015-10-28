package home_work.arraylist;

/**
 * Created by slavik on 22.09.2015.
 */
public class MyList {
    private int[] array;
    private int size;
    private int capacity;

    public MyList() {
        array = new int[10];
        size = 0;
        capacity = 10;
    }

    public MyList(int capacity) {
        array = new int[capacity];
        size = 0;
        this.capacity = capacity;
    }

    public void add(int value) {
        array[size++] = value;
        if(size == capacity) {
            capacity *= 2;
            int[] arrayTemp = new int[capacity];
            System.arraycopy(array, 0, arrayTemp, 0, size);
            array = arrayTemp;
        }
    }

    public void remove(int index) {
        if (index < 0 || index > size - 1 ) {
            System.out.println("incorrect index");
        }
        for (int i = index; i < size; i++ ) {
            array[i] = array[i+1];
        }
        size--;
    }

    public int getSize() {
        return size;
    }

    public int getCapacity() {
        return capacity;
    }
    @Override
    public String toString() {
        StringBuffer str = new StringBuffer();
        for ( int i = 0; i < size; i++ ) {
            str.append(array[i]);
            str.append(' ');
        }
        return str.toString();
    }
}
