package ua.goit.alg;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {

  private int sizeLimit;
  private Map<Integer,Node> cacheMap = new HashMap<Integer,Node>();

  private Node first;
  private Node last;
  
  private static class Node {
    Integer key;
    Integer value;
    Node next;
    Node prev;

    Node(Integer key, Integer value) {
      this.key = key;
      this.value = value;
    }
  }
  
  private void removeFirst(){
    int size = getSize();
    if (size > 0) {
      cacheMap.remove(first.key);
    }
    if (size > 1) {
      first = first.next; 
      first.prev = null;
    } else {
      first = null;
      last = null;
    }
  }
  
  private void addToEnd(Node element){
    if (getSize() == 0) {
      first = element;
    } else {
      last.next = element;
      element.prev = last;
      element.next = null;
    }
    last = element;
  }

  private void moveElementToEnd(Node element){
    if (element == last){
      return;
    }
    if (last == null){
      addToEnd(element);
      return;
    } 
    if (first == element) {
      first = first.next;
      first.prev = null;
    } else {
      element.prev.next = element.next;
      element.next.prev = element.prev;
      element.prev = last;
      element.next = null;
    }
    last.next = element;
    element.prev = last;
    element.next = null;
    last = element;
  }

  public LRUCache(int sizeLimit) {
    this.sizeLimit = sizeLimit;
  }

  public void put(int key, int value) {
    Node node = cacheMap.get(key);
    if (node != null){
      moveElementToEnd(node);
      node.value = value;
    } else {
      if (getSize() == sizeLimit){
        removeFirst();
      }
      node = new Node(key,value);
      addToEnd(node);
      cacheMap.put(key, node);
    }
  }

  public Integer get(int key) {
    Integer result = null;
    Node node = cacheMap.get(key);
    if (node != null){
      moveElementToEnd(node);
      result = node.value;
    }
    return result;
  }

  public int getSize() {
    return cacheMap.size();
  }

  public String getStringValue() {
    StringBuilder sb = new StringBuilder();
    for (Node i = first; i != null; i = i.next) {
      sb.append(i.key).append(" ");
    }
    return sb.toString();
  }
}
