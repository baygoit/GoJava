package ua.goit.alg.LRUCache;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {
    private Map<Integer, Node> map = new HashMap<Integer, Node>();

    private int capacity;
    private int length;
    private Node head;
    private Node tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        length = 0;
    }
    public int get(int key) {
        if (map.containsKey(key)) {
            Node latest = map.get(key);
            remove(latest);
            setHead(latest);
            return latest.value;
        } else {
            return -1;
        }
    }

    public void set(int key, int value) {
        Node node = new Node(key, value);

        if (length < capacity) {
            setHead(node);
            map.put(key, node);
            length++;
        } else {
            map.remove(tail.key);
            tail = tail.after;

            if (tail != null) {
                tail.before = null;
            }
            setHead(node);
            map.put(key, node);
        }

    }

    private void setHead(Node node) {
        node.before = head;
        node.after = null;

        if (head != null) {
            head.after = node;
        }

        head = node;
        if (tail == null) {
            tail = node;
        }
    }

    public void remove(Node node) {
        Node current = node;
        Node previous = current.after;
        Node before = current.before;

        if (previous != null) {
            previous.before = before;
        } else {
            head = before;
        }

        if (before != null) {
            before.after = previous;
        } else {
            tail = previous;
        }
    }

    public Map<Integer, Node> getMap() {
        return map;
    }
}