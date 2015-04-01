package ua.goit.cache;

import java.util.HashMap;
import java.util.Map;

public class NodeTable {

  final int DEFAULT_CACHE_SIZE = 5;

  Map<Integer, Node> cacheTable = new HashMap<Integer, Node>();
  Node head = null;
  Node tail = null;

  int capacity = DEFAULT_CACHE_SIZE;

  public NodeTable() {
  }

  public NodeTable(int capacity) {
    super();
    this.capacity = capacity;
  }

  public void put(int argKey, int argValue) {

    Node tableNode = cacheTable.get(argKey);

    if (tableNode == null) {
      Node newNode = new Node(argKey, argValue);
      addToTail(newNode);
      cacheTable.put(argKey, newNode);
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

  private void addToTail(Node arg) {
    if (tail == null) {
      tail = arg;
      head = tail;
    } else {
      tail.setNextNode(arg);
      tail = arg;
    }
  }

  private void removeNodeFromList(Node arg) {

    Node prev = arg.getPrevNode();
    Node next = arg.getNextNode();

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
  }

  private void moveToTail(Node arg) {
    removeNodeFromList(arg);
    addToTail(arg);
  }

  private void checkCapacity() {

    if (cacheTable.size() > capacity) {

      cacheTable.remove(head.getKey());
      removeNodeFromList(head);
    }
  }
}
