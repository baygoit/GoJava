package com.gojava6.Iterator;

/**
 * Created by root on 07.10.15.
 */
public class ArrayIteratorDemo {

    public static void main(String[] args) {

        ArrayRepository arrayRepository = new ArrayRepository();
        Iterator iterator = arrayRepository.getIterator();

        while (iterator.hasNext()) {

            int number = (Integer) iterator.next();
            System.out.println(number);

        }

    }

}
