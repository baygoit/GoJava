package com.collections;

import java.util.Arrays;

/**
 * Created by Игорь on 25.09.2015.
 */
public class ArrayList {
    private Object[] array;
    private int size;

    public ArrayList(int size) throws IllegalAccessException {
        if (size < 0) {
            throw new IllegalAccessException();
        }
        this.array = new Object[size];
    }

    public ArrayList() {
        this.array = new Object[10];;
    }

    public int size(){
        return array.length;
    }

    public Object get (int index){
        rangeCheck(index);
        return array[index];
    }


    public Object set(int index, Object element){
        rangeCheck(index);
        Object oldValue = array[index];
        array[index] = element;

        return oldValue;
    }

    public void rangeCheck(int index){
        if (size < index || index < 0) {
            throw new IndexOutOfBoundsException();
        }
    }

    private boolean  add(int value) {
        ensureCapacityInternal(size + 1);
        array[size++] = value;
        return true;
    }

    private void add(int index, Object element){
        rangeCheck(index);
        ensureCapacityInternal(size + 1);  // Increments modCount!!
        System.arraycopy(array, index, array, index + 1,
                size - index);
        array[index] = element;
        size++;

    }

    public Object remove(int index) {
        rangeCheck(index);

        Object oldValue = array[index];

        int numMoved = size - index - 1;
        if (numMoved > 0)
            System.arraycopy(array, index+1, array, index,
                    numMoved);
        array[--size] = 0; // Let gc do its work

        return oldValue;
    }

    public boolean removeForValue (int value) {
        if (value == 0) {
            for (int index = 0; index < size; index++)
                if (array[index] == null) {
                    fastRemove(index);
                    return true;
                }
        } else {
            for (int index = 0; index < size; index++)
                if (value == array[index]) {
                    fastRemove(index);
                    return true;
                }
        }
        return false;
    }

    private void fastRemove(int index) {
        int numMoved = size - index - 1;
        if (numMoved > 0)
            System.arraycopy(array, index+1, array, index,
                    numMoved);
        array[--size] = 0; // Let gc do its work
    }

    private void ensureCapacityInternal(int minCapacity) {
        // overflow-conscious code
        if (minCapacity - array.length > 0)
            grow(minCapacity);
    }

    private void grow(int minCapacity) {
        // overflow-conscious code
        int oldCapacity = array.length;
        int newCapacity = oldCapacity + (oldCapacity >> 1);
        if (newCapacity - minCapacity < 0)
            newCapacity = minCapacity;
        if (newCapacity - Integer.MAX_VALUE > 0)
            newCapacity = hugeCapacity(minCapacity);
        // minCapacity is usually close to size, so this is a win:
        array = Arrays.copyOf(array, newCapacity);
    }

    private static int hugeCapacity(int minCapacity) {
        if (minCapacity < 0) // overflow
            throw new OutOfMemoryError();
        return  Integer.MAX_VALUE;
    }
}
