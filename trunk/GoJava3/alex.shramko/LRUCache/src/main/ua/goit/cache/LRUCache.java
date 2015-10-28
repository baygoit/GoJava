package ua.goit.cache;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCache {

  private int capacity;
  private Node head;
  private Map<Integer, Integer> map;

  public LRUCache(int capacity) {
    this.capacity = capacity;
    map = new LinkedHashMap<Integer, Integer>(capacity);
  }

  public int get(int key) {
    Integer result = map.get(key);
    return (result == null) ? -1 : result;
  }

  public void set(int key, int value) {
    if (get(key) == -1) {
      insertNewElement(key, value);
    } else if (head.value != value) {
      shift(key, value);
    }
  }

  private void insertNewElement(int key, int value) {
    Node node = new Node(key, value);
    map.put(key, value);
    if (map.size() == 1) {
      head = node;
    } else {
      insertNewHead(node);
      if (map.size() > capacity) {
        removeLast();
      }
    }
  }

  private void insertNewHead(Node node) {
    node.next = head;
    head = node;
  }

  private void shift(int key, int value) {
    Node node = new Node(key, value);
    Node prevNode = head;
    while (true) {
      if (prevNode.next.equals(node)) {
        prevNode.next = node.next;
        break;
      } else {
        prevNode = prevNode.next;
      }
    }
    insertNewHead(node);
  }

  private void removeLast() {
    Node node = head;
    int size = 1;
    while (true) {
      if (size == capacity) {
        map.remove(node.next.key);
        node.next = null;
        break;
      } else {
        node = node.next;
        size++;
      }
    }
  }

  class Node {

    int value;
    int key;
    Node next;

    Node(int key, int value) {
      this.value = value;
      this.key = key;
    }
    
    @Override
    public boolean equals(Object obj) {
      if (this == obj) return true;
      if (obj == null || getClass() != obj.getClass()) return false;
      Node node = (Node) obj;
      if (key == node.key && value == node.value) return true;
      return false;
    }
    
  }

}
