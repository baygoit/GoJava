package miscel;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {
  private int capacity;
  private HashMap<Integer, Node> map = new HashMap<Integer, Node>();
  private Node head;
  private Node tail;

  public LRUCache(int capacity) {
    this.capacity = capacity;
  }

  public int get(int key) {
    if (map.containsKey(key)) {
      increasePriority(key);
    }
    return map.get(key).key;
  }

  public void put(int key, int value) {
    if (map.containsKey(key)) {
      increasePriority(key);
      map.get(key).value = value;
    } else {
      Node newNode = new Node(key, value);
      if (head == null) {
        head = newNode;
        tail = head;
      } else {
        head.previous = newNode;
        head = newNode;
      }
      map.put(key, newNode);
    }
    if (map.size() > capacity) {
      removeExcessiveValue();
    }
  }

  private void removeExcessiveValue() {
    map.remove(tail.key);
  }

  private void increasePriority(int key) {
    Node oldNode = map.get(key);
    if (oldNode.previous != null && oldNode.next != null) {
      oldNode.previous.next = oldNode.next;
      oldNode.next.previous = oldNode.previous;
    } else if (oldNode.previous != null) {
      oldNode.previous = tail;
    }
    head.previous = oldNode;
    head = oldNode;
  }

  @Override
  public String toString() {
    StringBuilder result = new StringBuilder("");
    if (head != null) {
      Node node = head;
      result.append(node.key + ":" + node.value + ", ");
      while (node.hasNext()) {
        result.append(node.key + ":" + node.value + ", ");
        node = node.next;
      }
    }
    return result.toString();
  }

  private class Node {
    int key;
    int value;
    Node previous;
    Node next;

    public Node(int key, int value) {
      this.key = key;
      this.value = value;
    }

    public boolean hasNext() {
      return (next != null);
    }
  }
}
