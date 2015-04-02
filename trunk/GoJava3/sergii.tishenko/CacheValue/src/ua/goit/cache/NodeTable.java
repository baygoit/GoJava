package ua.goit.cache;

import java.util.HashMap;
import java.util.Map;

public class NodeTable {

  final int DEFAULT_CACHE_SIZE = 5;

  private Map<Integer, Node> cacheTable = new HashMap<Integer, Node>();
  private Node head = null;
  private Node tail = null;
  private int capacity = DEFAULT_CACHE_SIZE;

  public NodeTable() {
  }

  public NodeTable(int capacity) {
    this.capacity = capacity;
  }

  public void put(int argKey, int argValue) {

    Node tableNode = cacheTable.get(argKey);

    if (tableNode == null) {
      tableNode = new Node(argKey, argValue);
      addToTail(tableNode);
      cacheTable.put(argKey, tableNode);
    } else {
      tableNode.setValue(argValue);
      moveToTail(tableNode);
    }

    checkCapacity();
  }

  public int get(int argKey) {

    int result = -1;
    Node tableNode = cacheTable.get(argKey);

    if (tableNode != null) {
      moveToTail(tableNode);
      result = tableNode.getValue();
    }
    return result;

  }

  private void addToTail(Node node) {
    if (tail == null) {
      tail = node;
      head = node;
    } else {
      node.setPrevNode(tail);
      tail.setNextNode(node);
      tail = node;
    }
  }

  private void removeNodeFromList(Node node) {

    Node prev = node.getPrevNode();
    Node next = node.getNextNode();

    if (prev == null && next == null) {
      head = null;
      tail = null;
    } else if (prev == null) {
      next.setPrevNode(null);
      head = next;
    } else if (next == null) {
      prev.setNextNode(null);
      tail = prev;
    } else {
      next.setPrevNode(prev);
      prev.setNextNode(next);
    }

    node.setNextNode(null);
    node.setPrevNode(null);
  }

  private void moveToTail(Node arg) {
    removeNodeFromList(arg);
    addToTail(arg);
  }

  void checkCapacity() {

    if (cacheTable.size() > capacity) {
      cacheTable.remove(head.getKey());
      removeNodeFromList(head);
    }
  }

  public int getCapacity() {
    return capacity;
  }

  void setCapacity(int capacity) {
    this.capacity = capacity;
  }

  Node getHead() {
    return head;
  }

  void setHead(Node head) {
    this.head = head;
  }

  Node getTail() {
    return tail;
  }

  void setTail(Node tail) {
    this.tail = tail;
  }

}
