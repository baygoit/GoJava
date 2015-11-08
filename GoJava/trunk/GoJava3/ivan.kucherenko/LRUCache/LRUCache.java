package ua.goit.alg.LRUCache;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {
  private Map<Integer, Node> map = new HashMap<Integer, Node>();
  private int capacity = 0;
  private int counter = 0;
  private Node head = null;
  private Node tail = null;

  public LRUCache(int capacity) {
    this.capacity = capacity;
  }

  public int get(int key) {
    Node reqElement = map.get(key);
    if (reqElement != null){
      changePriority(reqElement);
      return reqElement.getValue();   
    }
    return -1;
  }

  public void set(int key, int value) {

    Node newElement = new Node(value);
    newElement.setKey(key);
    map.put(key, newElement);
    counter++;
    if (counter == 1){
      firstAdd(newElement);
    } else {
      defaultAdd(newElement);
    } 
  }

  private void firstAdd(Node newElement){
    head = newElement;
    tail = head;
  }

  private void defaultAdd(Node newElement){
    if (counter > capacity){
      rotateHead();
    }
    tail.setNext(newElement);
    newElement.setPrevious(tail);
    tail = newElement;
  }

  private void rotateHead(){
    head = head.getNext();
    map.remove(head.getPrevious().getKey());
  }

  private void changePriority(Node element){
    if (!element.equals(tail)) {
      if(!element.equals(head)){
        element.getNext().setPrevious(element.getPrevious());
        element.getPrevious().setNext(element.getNext());
        element.setPrevious(tail);
        tail.setNext(element);
        tail = element;
      } else {
        element.setPrevious(tail);
        head = element.getNext();
        tail = element;
      }
    }
  }
}
