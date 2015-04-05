package ua.goit.lrucache;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {
  private Node head;
  private Node tail;
  private int capacity;
  private Map<Integer, Node> map;

  public LRUCache(int capacity) {
    this.capacity = capacity;
    map = new HashMap<Integer, Node>(capacity);
  }

  public void set(int key, int value) {
    Node node = new Node(value);
    if (map.size() < capacity) {
      map.put(key, node);
      insertLastNode(node);
    } else {
      removeFirstNode();
      map.put(key, node);
      insertLastNode(node);
    }
  }

  private void removeFirstNode() {
    for (Map.Entry<Integer, Node> entry : map.entrySet()) {
      Node value = entry.getValue();
      if (value.equals(head)) {
        map.remove(entry.getKey());
      }
    }
  }

  public int get(int key) {
    if (map.containsKey(key)) {
      Node currentNode = map.get(key);
      cutNode(currentNode);
      insertLastNode(currentNode);
      return currentNode.value;
    } else {
      return -1;
    }
  }

  private void cutNode(Node currentNode) {
    Node prev = currentNode.prev;
    Node next = currentNode.next;
    if (prev == null) {
      next.prev = null;
      head = next;
    } else if (next == null) {
      tail = prev;
    } else {
      prev.next = next;
      next.prev = prev;
    }
  }

  private void insertLastNode(Node currentNode) {
    currentNode.prev = tail;
    tail = currentNode;
    currentNode.next = null;
  }

  public Node getTail() {
    return tail;
  }

  public Node getHead() {
    return head;
  }

  class Node {
    private int value;
    private Node next;
    private Node prev;

    Node(int value) {
      this.value = value;
    }

    public int getValue() {
      return value;
    }
  }
}
