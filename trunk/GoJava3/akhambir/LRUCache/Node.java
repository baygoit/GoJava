package ua.goit.alg.LRUCache;


public class Node {
    public int value;
    public int key;
    public Node before;
    public Node after;

    public Node(int key, int value) {
        this.value = value;
        this.key = key;
    }

    @Override
    public String toString() {
        return "Node:" + " Key: " + key + "; Value: " + value + ";";
    }
}
