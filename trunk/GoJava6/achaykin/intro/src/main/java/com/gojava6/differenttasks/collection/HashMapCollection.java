package com.gojava6.differenttasks.collection;

import java.util.*;

/**
 * @Autor Andrey Chaykin
 * @Since 04.10.2015
 */

/**
 * put, get, remove, containsKey, containsValue, capacity, and empty
 * bulk operations (such as putAll and clear)
 * collection views (such as keySet, entrySet, and values)
 */
public class HashMapCollection<K, V> {

    Entry[] table;                                              //todo entry? Objects?
    private int capacity;
    private float loadFactor;
    private int threhhold;

    public static void main(String[] args) {
        HashMapCollection<String, Integer> hashMapCollection = new HashMapCollection<String, Integer>();
        Map<String, String> hashMapList = new HashMap<String, String>();
    }

    public HashMapCollection() {
        capacity = 16;
        loadFactor = 0.75f;
        threhhold = Math.round(capacity * loadFactor);
        table = new Entry[capacity];
    }

    public int size() {
        return table.length;
    }

    public boolean isEmpty() {
        if(table.length == 0 || table == null) {
            return true;
        }
        return false;
    }

    public boolean containsKey(Object key) {
        return false;
    }

    public boolean containsValue(Object value) {
//        Node<K, V>[] tab; V v;   //todo Node?
        return false;
    }

    public Object get(Object key) {
        if (key == null) {
            //return getForNullKet(key);
        } else {
            int hash = hash(key.hashCode());
            for(Entry<K, V> e = table[indexFor(hash, table.length)]; e != null; e = e.next) {
                    return e.value;
            }
        }
        return null;
    }

    public V put(K key, V value) {
        if (key == null) {
            return putForNulKey(value);
        } else {
            int hash = hash(key.hashCode());
            int index = indexFor(hash, table.length);

            for (Entry<K, V> e = table[index]; e != null; e = e.next) {  //todo ?
                Object k;
                if (e.hash == hash && ((k = e.key) == key || key.equals(k))) {
                    V oldValue = e.value;
                    e.value = value;
                    e.recordAccess(this);    //todo which this?
                    return oldValue;
                } else {
                    addEntry(hash, key, value, index);
                }
            }
        }
        return null;
    }

    private V putForNulKey(V value) {
        for (Entry<K, V> e = table[0]; e != null; e = e.next) {
            if (e.key == null) {
                V oldValue = e.value;
                e.value = value;
                return oldValue;
            } else {
                addEntry(0, null, value, 0);
            }
        }
        return null;
    }

    private void addEntry(int hash, K key, V value, int index) {
        Entry<K, V> e = table[index];
        table[index] = new Entry<K, V>(hash, key, value, e);
    }

    public Object remove(Object key) {
        return null;
    }

    public void putAll(Map m) {

    }

    public void clear() {

    }

    public Set keySet() {
        return null;
    }

    public Collection values() {
        return null;
    }

    public Set<Entry> entrySet() {
        return null;
    }

    private int hash(int h) {
        h ^= (h >>> 20) ^ (h >>> 7);
        return h ^ (h >>> 7) ^ (h >>> 4);
    }

    private int indexFor(int h, int length) {
        return h % (length - 1);
    }

    static class Entry<K, V> implements Map.Entry {
        final int hash;
        final K key;
        V value;
        Entry next;

        public Entry(int hash, K key, V value, Entry next) {
            this.key = key;
            this.value = value;
            this.hash = hash;
            this.next = next;
        }

        public Object getKey() {
            return null;
        }

        public Object getValue() {
            return null;
        }

        public Object setValue(Object value) {
            return null;
        }

        public void recordAccess(HashMapCollection hashMapCollection) {

        }
    }
}