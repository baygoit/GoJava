package ua.goit.lrucache;

import java.util.HashMap;
import java.util.Iterator;
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
    if (map.size() < capacity || map.containsKey(key)) {
      if (map.containsKey(key)) {
        Node oldNode = map.get(key);
        cutNode(oldNode);
      }
      map.put(key, node);
      insertLastNode(node);
    } else {
      if (capacity == 0) {
        return;
      }
      Node firstNode = head;
      cutNode(firstNode);
      removeFirstNode(firstNode);
      map.put(key, node);
      insertLastNode(node);
    }
  }

  private void removeFirstNode(Node node) {
    Iterator<Map.Entry<Integer, Node>> iterator = map.entrySet().iterator();
    while (iterator.hasNext()){
      Map.Entry<Integer, Node> entry = iterator.next();
      Node value = entry.getValue();
      if (value.equals(node)) {
        iterator.remove();
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
    if (prev == null && next == null) {
      head = null;
      tail = null;
    }else if (prev == null) {
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
    if (currentNode.prev != null) {
      Node prev = currentNode.prev;
      prev.next = currentNode;
    }
    if (map.size() == 1) {
      head = currentNode;
    }
    tail = currentNode;
    currentNode.next = null;
  }

  @Override
  public String toString() {
    StringBuilder result = new StringBuilder("");
    if (head != null) {
      Node node = head;
      result.append(node.value).append(" ");
      while (node.next != null) {
        node = node.next;
        result.append(node.value).append(" ");
      }
    }
    return result.toString();
  }

  class Node {
    private int value;
    private Node next;
    private Node prev;

    Node(int value) {
      this.value = value;
    }
  }
}
