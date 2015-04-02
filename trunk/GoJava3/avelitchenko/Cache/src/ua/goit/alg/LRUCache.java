package ua.goit.alg;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class LRUCache {

  private int sizeLimit;
  private Map<Integer,Node> cacheMap = new HashMap<>();

  private Node first;
  private Node last;
  
  private static class Node {
    Integer value;
    Node next;
    Node prev;

    Node(Integer value) {
        this.value = value;
    }
  }
  
  private void removeFirst(){
    if (cacheMap.size() > 1) {
      first.next.prev = null;
      first.next = null;
      first = first.next; 
    } else {
      first = null;
      last = null;
    }
  }
  
  private void addToEnd(Node element){
    if (cacheMap.size() == 0) {
      first = element;
    } else {
      last.next = element;
      element.prev = last;
    }
    last = element;
  }

  private void moveElementToEnd(Node element){
    if (element == last){
      return;
    }
    if (element == null){
      addToEnd(element);
      return;
    } else if (first == element) {
      first.next = null;
      first = element.next;
      first.prev = null;
    } else {
      element.prev.next = element.next;
      element.next.prev = element.prev;
      element.prev = last;
      element.next = null;
    }
    last.next = element;
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
      node = new Node(value);
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
      sb.append(i.value).append(" ");
    }
    return sb.toString();
  }
}
