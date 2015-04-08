package main;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {
  private final int capacity;
  private Entity head;
  private Entity tail;
  private final Map<Integer, Entity> cacheHolder;

  public LRUCache(int capacity) {
    cacheHolder = new HashMap<Integer, Entity>();
    this.capacity = capacity;
  }

  public int get(int key) {
    if (cacheHolder.containsKey(key)) {
      upToHead(key);
      return cacheHolder.get(key).value;
    } else {
      return -1;
    }
  }

  public void set(int key, int value) {
    if (cacheHolder.containsKey(key)) {
      Entity entity = cacheHolder.get(key);
      entity.value = value;
      upToHead(key);
    } else {
      Entity newEntity = new Entity(key, value, head);
      if (cacheHolder.size() < capacity) {
        if (head != null) {
          addElementAndSwitchOtherDown(newEntity);
        } else {
          head = newEntity;
          tail = newEntity;
        }
      } else {
        Entity newTailEntity = tail.previous;
        delete(tail.key);
        tail = newTailEntity;
        addElementAndSwitchOtherDown(newEntity);
      }

      cacheHolder.put(key, newEntity);
    }
  }

  public void clearCache() {
    cacheHolder.clear();
  }

  public int getCacheSize() {
    return cacheHolder.size();
  }

  private void upToHead(int key) {
    Entity entity = cacheHolder.get(key);
    if (entity == head) {
      return;
    }

    Entity previousEntity = entity.previous;
    Entity nextEntity = entity.next;
    if (entity == tail) {
      previousEntity.next = null;
      tail = previousEntity;
      head.previous = entity;
      entity.next = head;
      head = entity;
    } else if (entity != head) {
      previousEntity.next = nextEntity;
      nextEntity.previous = previousEntity;
      entity.next = head;
      addElementAndSwitchOtherDown(entity);
    }
  }

  private void addElementAndSwitchOtherDown(Entity newEntity) {
    head.previous = newEntity;
    head = newEntity;
  }

  private static class Entity {
    public Entity(int key, int value, Entity next) {
      this.value = value;
      this.next = next;
      this.key = key;
    }

    protected final int key;
    protected int value;
    protected Entity next;
    protected Entity previous;

    @Override
    public String toString() {
      return String.valueOf(value);
    }
  }

  private void delete(int key) {
    if (cacheHolder.containsKey(key)) {
      Entity entity = cacheHolder.get(key);
      Entity previousEntity = entity.previous;
      previousEntity.next = null;
      cacheHolder.remove(tail.key);
      tail = previousEntity;
    }
  }

  @Override
  public String toString() {
    StringBuilder textToString = new StringBuilder();
    Entity entity = head;
    while (entity != null) {
      appendDataToAnswerString(textToString, entity);
      entity = entity.next;
    }

    return textToString.toString();
  }

  private void appendDataToAnswerString(StringBuilder textToString,
                                        Entity entity) {
    textToString.append(entity.key);
    textToString.append(' ');
    textToString.append(entity.value);
    textToString.append('\n');
  }
}