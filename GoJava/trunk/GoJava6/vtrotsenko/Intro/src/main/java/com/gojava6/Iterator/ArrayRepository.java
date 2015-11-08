package com.gojava6.Iterator;

/**
 * Created by root on 07.10.15.
 */
public class ArrayRepository implements Container{

    public int array[] = {1, 2, 3, 4};

    public Iterator getIterator() {
        return new ArrayIterator();
    }

    private class ArrayIterator implements Iterator {

        int index;

        @Override
        public boolean hasNext() {
            if (index < array.length) {
                return true;
            }
            return false;
        }

        @Override
        public Object next() {

            if (this.hasNext()) {
                int currentIndex = index;
                index++;
                return array[currentIndex];
            }
            return null;
        }

    }
}
