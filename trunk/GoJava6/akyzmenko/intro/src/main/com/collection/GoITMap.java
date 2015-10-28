package com.collection;

import java.util.LinkedList;

/**
 * Created by sergiigetman on 9/23/15.
 */
public class GoITMap {

    private int arraysize = 10;

    private LinkedList<Pair>[] values = new LinkedList[arraysize];

    private int length;

    public void put(Object key, Object value) {
        int index = hashFunction(key);
        if(values[index] == null) {
            values[index] = new LinkedList<Pair>();
        } else {
            for (Pair pair : values[index]) {
                if (pair.key.equals(key)) {
                    values[index].remove(pair);
                    length--;
                }
            }
        }
        values[index].add(new Pair(key, value));
        length++;
    }

    private int hashFunction(Object key) {
        return key.hashCode() % arraysize;
    }

    public Object get(Object key) {
        int index = hashFunction(key);
        for (Pair pair : values[index]) {
            if(pair.key.equals(key)) {
                return pair.value;
            }
        }
        return null;
    }

    public int size() {
        return length;
    }

    private class Pair {
        Object key;
        Object value;

        public Pair(Object key, Object value) {
            this.key = key;
            this.value = value;
        }
    }

    public static void main(String[] args) {
        GoITMap map = new GoITMap();
        map.put(new Integer(1),"One");
        map.put(new Integer(1),"One");
        map.put(new Integer(2),"Two");
        map.put(new Integer(11),"Eleven");
        System.out.println(map.get(new Integer(1)));
        System.out.println(map.get(new Integer(2)));
        System.out.println(map.get(new Integer(1)));
        System.out.println(map.get(new Integer(11)));
        System.out.println(map.size());
    }
}
