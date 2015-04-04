import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class LRUCache {

  public final int capacity;
  private Node first;
  private Node last;
  private Map<Integer, Node> cache;

  public LRUCache(int capacity) {
    this.capacity = capacity;
    cache = new HashMap<>(capacity);
  }

  public int get(int key) {
    if (!cache.containsKey(key)) {
      return -1;
    }
    Node node = cache.get(key);
    unLink(node);
    linkLast(node);
    return node.value;
  }

  public void set(int key, int value) {
    if (cache.size() < capacity && !cache.containsKey(key)) {
      addNewNode(key, value);
    } else if (cache.containsKey(key)) {
      Node node = cache.get(key);
      node.value = value;
      unLink(node);
      linkLast(cache.get(key));
    } else {
      int firstNodeKey = unLink(first);
      cache.remove(firstNodeKey);
      addNewNode(key, value);
    }
  }

  private void addNewNode(int key, int value) {
    Node newNode = new Node(key, value);
    linkLast(newNode);
    cache.put(key, newNode);
  }

  private int unLink(Node node) {
    final Node prev = node.prev;
    final Node next = node.next;
    final int key = node.key;

    if (prev == null) {
      first = next;
    } else {
      prev.next = next;
      node.prev = null;
    }

    if (next == null) {
      last = prev;
    } else {
      next.prev = prev;
      node.next = null;
    }

    return key;
  }

  private void linkLast(final Node node) {
    final Node l = last;
    node.next = null;
    node.prev = l;
    last = node;
    if (l == null) {
      first = node;
    } else {
      l.next = node;
    }
  }

  private static class Node {
    final int key;
    int value;
    Node next;
    Node prev;

    Node(int key, int element) {
      this.value = element;
      this.key = key;
    }

  }

  public int getFirstValue() {
    return first.value;
  }

  public int getLastValue() {
    return last.value;
  }

  public int getCacheSize() {
    return cache.size();
  }

}
