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
      if (!reqElement.equals(head)){
        if (!reqElement.equals(tail)){
          reqElement.getNext().setPrevious(reqElement.getPrevious());
        }
        reqElement.getPrevious().setNext(reqElement.getNext());
        reqElement.setNext(head);
        head.setPrevious(reqElement);
        head = reqElement;
      }
      return reqElement.getValue();
    }
    return -1;
  }

  public void set(int key, int value) {
    map.put(key, new Node(value));
    Node newElement = map.get(key);
    newElement.setKey(key);

    counter++;
    if (counter == 1){
      head = newElement;
      tail = head;
    } else if (counter > 1){
      if (counter > capacity){
        head = head.getNext();
        map.remove(head.getPrevious().getKey());
      }
      tail.setNext(newElement);
      newElement.setPrevious(tail);
      tail = newElement;
    } 
  }
}
