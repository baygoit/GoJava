//package com.gojava6.differenttasks.collection;
//
//import java.util.*;
//
//public class ArrayListCollection<E> implements List {
//
//    List<E> list = new ArrayList<E>();
//    E[] elementData;
//    int capacity;
//
//    public ArrayListCollection() {
//        elementData = (E[]) new Object[10];
//    }
//
//    public ArrayListCollection(int capacity) {
//        if(capacity < 0) {
//            throw new IllegalArgumentException();
//        }
//            elementData = (E[]) new Object[capacity];
//    }
//
//    public int size() {
//        if(elementData != null) {
//            return elementData.length;
//        }
//        return 0;
//    }
//
//    public boolean isEmpty() {
//        return elementData.length == 0;
//    }
//
//    public boolean contains(Object o) {
//        return false;
//    }
//
//    public Iterator iterator() {
//        return null;
//    }
//
//    public Object[] toArray() {
//        return new Object[0];
//    }
//
//    public boolean add(Object o) {
//
//        return false;
//    }
//
//    public boolean remove(Object o) {
//        return false;
//    }
//
//    public boolean addAll(Collection c) {
//        return false;
//    }
//
//    public boolean addAll(int index, Collection c) {
//        return false;
//    }
//
//    public void clear() {
//
//    }
//
//    public Object get(int index) {
//        return null;
//    }
//
//    public Object set(int index, Object element) {
//        return null;
//    }
//
//    public void add(int index, Object element) {
//
//    }
//
//    public Object remove(int index) {
//        return null;
//    }
//
//    public int indexOf(Object o) {
//        for (int i = 0; i < elementData.length; i++) {
//            if(elementData[i].equals(o)) {
//                return i;
//            } else if(o == null) {
//                if(elementData[i] == null) {
//                    return i;
//                }
//            }
//        }
//        return -1;
//    }
//
//    public int lastIndexOf(Object o) {
//        return 0;
//    }
//
//    public ListIterator listIterator() {
//        return null;
//    }
//
//    public ListIterator listIterator(int index) {
//        return null;
//    }
//
//    public List subList(int fromIndex, int toIndex) {
//        return null;
//    }
//
//    public boolean retainAll(Collection c) {
//        return false;
//    }
//
//    public boolean removeAll(Collection c) {
//        return false;
//    }
//
//    public boolean containsAll(Collection c) {
//        return false;
//    }
//
//    public E[] toArray(Object[] a) {
//        return new E[0];
//    }
//}
