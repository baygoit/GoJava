package ua.goit.alg;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class LRUCache {

  private int sizeLimit;
  private Map<Integer,Integer> cacheMap = new HashMap<>();
  private List<Integer> cacheList = new LinkedList<>();
  
  public LRUCache(int sizeLimit) {
    this.sizeLimit = sizeLimit;
  }

  public void put(int key, int value) {
    int index = getIndex(key);
    if (getSize() == sizeLimit || index != -1){
      if (index == -1){
        int keyToRemove = cacheList.get(0);
        cacheMap.remove(keyToRemove);
        cacheList.remove(0);
      } else {
        cacheMap.remove(key);
        cacheList.remove(index);
      }
    } 
    cacheMap.put(key, value);
    cacheList.add(key);
  }

  public Integer get(int key) {
    Integer result = null;
    int index = getIndex(key);
    if (index != -1){
      cacheList.remove(index);
      cacheList.add(key);
      result = cacheMap.get(key);
    }
    return result;
  }

  private int getIndex(int key) {
    return cacheList.indexOf(key);
  }

  public int getSize() {
    return cacheMap.size();
  }

  public String getListToString() {
    StringBuilder builder = new StringBuilder();
    for (Integer element : cacheList) {
      builder.append(element).append(" ");
    }
    return builder.toString();
  }

  public Object[] getList() {
    return cacheList.toArray();
  }
}
