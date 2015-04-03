package main;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {
  private int capacity;
  private static Entity head;
  private static Entity tail;
  Map<Integer, Entity> cacheHolder;

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
          addElementAndSwiftOtherDown(newEntity);
        } else {
          head = newEntity;
          tail = newEntity;
        }
      } else {
        Entity newTailEntity = tail.previous;
        delete(tail.key);
        tail = newTailEntity;
        addElementAndSwiftOtherDown(newEntity);
      }

      cacheHolder.put(key, newEntity);
    }
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
      addElementAndSwiftOtherDown(entity);
    }
  }

  private void addElementAndSwiftOtherDown(Entity newEntity) {
    head.previous = newEntity;
    head = newEntity;
  }

  private class Entity {
    public Entity(int key, int value, Entity next) {
      this.value = value;
      this.next = next;
      this.key = key;
    }

    public int key;
    public int value;
    public Entity next;
    public Entity previous;

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
      textToString.append(entity.key + " " + entity.value + "\n");
      entity = entity.next;
    }

    return textToString.toString();
  }
}