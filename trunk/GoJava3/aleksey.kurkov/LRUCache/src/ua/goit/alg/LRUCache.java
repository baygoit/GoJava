package ua.goit.alg;

import java.util.HashMap;

public class LRUCache {
  private final int cacheCapacity;
  private final HashMap<Integer, Node> cache;
  private Node head;
  private Node tail;

  public LRUCache(int capacity) {
    this.cacheCapacity = capacity;
    cache = new HashMap<>(cacheCapacity);
  }

  public void put(int key, int value) {
    boolean cacheDoesNotContainKey = !cache.containsKey(key);
    boolean cacheNotFull = cache.size() < cacheCapacity;

    if (cacheNotFull && cacheDoesNotContainKey) {
      addNodeToCache(key, value);
    } else if (cache.containsKey(key)) {
      Node node = cache.get(key);
      node.setValue(value);
      brakeLinks(node);
      setLinks(cache.get(key));
    } else {
      cache.remove(head.getKey());
      brakeLinks(head);
      addNodeToCache(key, value);
    }
  }

  public int get(int key) {
    int result;
    boolean cacheDoesNotContainKey = !cache.containsKey(key);

    if (cacheDoesNotContainKey) {
      result = -1;
    } else {
      Node node = cache.get(key);
      brakeLinks(node);
      setLinks(node);
      result = node.getValue();
    }
    return result;
  }

  private void addNodeToCache(int key, int value) {
    Node node = new Node(key, value);
    setLinks(node);
    cache.put(key, node);
  }

  private void brakeLinks(Node node) {
    Node previousNode = node.getPreviousNode();
    Node nextNode = node.getNextNode();

    if (node.hasPreviousNode()) {
      previousNode.setNextNode(nextNode);
      node.setPreviousNode(null);
    } else {
      head = nextNode;
    }

    if (node.hasNextNode()) {
      nextNode.setPreviousNode(previousNode);
      node.setNextNode(null);
    } else {
      tail = previousNode;
    }
  }

  private void setLinks(Node node) {
    Node lastNode = tail;
    node.setNextNode(null);
    node.setPreviousNode(lastNode);
    tail = node;

    if (lastNode == null) {
      head = node;
    } else {
      lastNode.setNextNode(node);
    }
  }

  public int getCapacity() {
    return this.cacheCapacity;
  }

  public int getSize() {
    return cache.size();
  }
}

class Node {

  private final int key;
  private int value;
  private Node previousNode;
  private Node nextNode;

  Node(int key, int value) {
    this.value = value;
    this.key = key;
  }

  public int getValue() {
    return value;
  }

  public void setValue(int value) {
    this.value = value;
  }

  public int getKey() {
    return key;
  }

  public boolean hasNextNode() {
    return (nextNode != null);
  }

  public boolean hasPreviousNode() {
    return (previousNode != null);
  }

  public Node getPreviousNode() {
    return previousNode;
  }

  public void setPreviousNode(Node previousNode) {
    this.previousNode = previousNode;
  }

  public Node getNextNode() {
    return nextNode;
  }

  public void setNextNode(Node nextNode) {
    this.nextNode = nextNode;
  }
}
