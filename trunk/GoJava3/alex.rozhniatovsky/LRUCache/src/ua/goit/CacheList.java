package ua.goit;

public class CacheList {
    private Node head;
    private Node tail;
    private int size;

    public CacheList() {
        head = tail = null;
        size = 0;
    }

    public void add(int value) {
        if (size == 0) {
            head = tail = new Node(value, null);
            size++;
        } else {
            tail.setNext(new Node(value, null));
            tail = tail.getNext();
            size++;
        }
    }

    public Node getPrevNode(int value) {
        Node current = head;
        for (int i = 1; i < size; i++) {
            if (current.getNext().getValue() == value) {
                return current;
            }
            current = current.getNext();
        }
        return null;
    }

    public void refresh(int value) {
        Node prevNode = getPrevNode(value);
        if (prevNode == null) {
            this.add(value);
        } else {
            Node temp = prevNode.getNext();
            prevNode.setNext(temp.getNext());
            tail.setNext(temp);
            temp.setNext(null);
            tail = temp;
        }
    }

    public int getLastElement() {
        return tail.getValue();
    }

    public int getFirstElement() {
        return head.getValue();
    }

    public static void main(String[] args) {
        CacheList list = new CacheList();
        for(int i = 0; i < 4; i++) {
            list.add(i);
        }
        list.refresh(6);
        System.out.println(list.getLastElement());
    }
}
