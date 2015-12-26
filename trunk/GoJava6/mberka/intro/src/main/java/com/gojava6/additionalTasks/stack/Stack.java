package com.gojava6.additionalTasks.stack;

public class Stack {
    private Node top;
    private int size;

    public boolean isEmpty() {
        if (size == 0) {
            return true;
        } else {
            return false;
        }
    }

    public int size() {
        return size;
    }

    public void push(String value) {

        Node oldTop = top;
        top = new Node();
        top.value = value;
        top.next = oldTop;

        size++;
    }

    public Object get() {

        Object topNode;
        if (isEmpty()) {
            throw new RuntimeException("EmptyStackException");
        } else {
            topNode = top.value;
            top = top.next;
            size--;
        }
        return topNode;
    }

    public Object peek() {
        if (isEmpty()) {
            throw new RuntimeException("EmptyStackException");
        } else {
            return top.value;
        }
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        for (Node x = top; x != null; x = x.next)
            str.append(x.value + ", ");
        return str.toString();
    }
}

