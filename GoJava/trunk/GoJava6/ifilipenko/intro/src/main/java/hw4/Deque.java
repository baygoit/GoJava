package hw4;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Deque<Item> implements Iterable<Item> {

    private int count;
    private Node first;
    private Node last;

    public Deque() {                           // construct an empty deque
    }

    public boolean isEmpty() {                 // is the deque empty?
        return first == null;
    }

    public int size() {                        // return the number of items on the deque
        return count;
    }

    public void addFirst(Item item) {          // add the item to the front
        if (item == null) {
            throw new NullPointerException();
        }

        Node oldFirst = first;
        first = new Node();
        first.item = item;
        first.next = oldFirst;

        if (oldFirst != null) oldFirst.previous = first;

        if (last == null) {
            last = first;
        }

        count++;

    }

    public void addLast(Item item) {           // add the item to the end
        if (item == null) {
            throw new NullPointerException();
        }

        Node oldlast = last;
        last = new Node();
        last.item = item;
        last.previous = oldlast;

        if (oldlast != null) oldlast.next = last;

        if (first == null) {
            first = last;
        }

        count++;
    }

    public Item removeFirst() {                // remove and return the item from the front
        if (first == null) {
            throw new NoSuchElementException();
        }

        Node tempFirst = first;
        first = tempFirst.next;
        if (first != null) first.previous = null;
        else last = null;


        count--;

        return tempFirst.item;
    }

    public Item removeLast() {                 // remove and return the item from the end
        if (last == null) {
            throw new NoSuchElementException();
        }

        Node tempFirst = last;
        last = tempFirst.previous;
        if (last != null) last.next = null;
        else first = null;


        count--;

        return tempFirst.item;
    }

    public Iterator<Item> iterator() {         // return an iterator over items in order from front to end
        return new DequeIterator();
    }

    public static void main(String[] args) {  // unit testing

    }

    private class Node {
        Item item;
        Node next;
        Node previous;
    }

    private class DequeIterator implements Iterator<Item> {

        private Node current = first;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public Item next() {
            if (current == null) {
                throw new NoSuchElementException();
            }
            Item item = current.item;
            current = current.next;
            return item;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }

    }
}