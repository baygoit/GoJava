package main.ua.goit.xmlparser;

public class TagStack {
  private int size;
  private String[] data;
  private boolean wasRootElement;

  private static final String[] EMPTY_ELEMENTDATA = {};
  private static final int DEFAULT_CAPACITY = 10;
  private static final int MAX_ARRAY_SIZE = Integer.MAX_VALUE - 8;

  public TagStack() {
    this.data = EMPTY_ELEMENTDATA;
  }

  public TagStack(int initialCapacity) {
    if (initialCapacity < 0)
      throw new IllegalArgumentException("Illegal Capacity: " + initialCapacity);
    this.data = new String[initialCapacity];
  }

  public boolean isEmpty() {
    return size == 0;
  }

  public int size() {
    return size;
  }

  private int length() {
    return data.length;
  }

  private void ensureCapacityGrow(int newCapacity) {
    if (data == EMPTY_ELEMENTDATA) {
      newCapacity = Math.max(DEFAULT_CAPACITY, newCapacity);
      grow(newCapacity);
    } else if (newCapacity * 2 - length() > 0)
      grow(length() * 2);
  }

  private void ensureCapacityDecrease(int newCapacity) {
    if (data == EMPTY_ELEMENTDATA) {
      throw new IllegalArgumentException("Illegal Capacity: " + newCapacity);
    }
    if ((newCapacity < length() / 4) && (length() > DEFAULT_CAPACITY))
      decrease(Math.max(DEFAULT_CAPACITY, length() / 2));
  }

  private void decrease(int newCapacity) {
    newCapacity = Math.max(newCapacity, DEFAULT_CAPACITY);
    data = copyOf(data, newCapacity);
  }

  private void grow(int newCapacity) {
    if (newCapacity - MAX_ARRAY_SIZE > 0)
      newCapacity = hugeCapacity(newCapacity);
    data = copyOf(data, newCapacity);
  }

  private static int hugeCapacity(int minCapacity) {
    if (minCapacity < 0)
      throw new OutOfMemoryError();
    return (minCapacity > MAX_ARRAY_SIZE) ? Integer.MAX_VALUE : MAX_ARRAY_SIZE;
  }

  private static String[] copyOf(String[] original, int newLength) {
    String[] copy = new String[newLength];
    System.arraycopy(original, 0, copy, 0, Math.min(original.length, newLength));
    return copy;
  }

  public boolean checkForValidRoot() {
    return (size() == 0 && wasRootElement);
  }
  
  public void push(String value) {
    if (size() == 0 && !wasRootElement) {
      wasRootElement = true;
    }
    ensureCapacityGrow(size + 1);
    data[size++] = value;
  }

  public String pop() {
    if (size() == 0)
      return null;
    ensureCapacityDecrease(size - 1);
    String item = data[size - 1];
    data[size - 1] = null;
    size--;
    return item;
  }

  public String get() {
    if (size() == 0)
      return null;
    String item = data[size - 1];
    return item;
  }

}