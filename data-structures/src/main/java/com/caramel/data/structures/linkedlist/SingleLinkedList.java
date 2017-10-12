package com.caramel.data.structures.linkedlist;

/**
 * Created by patrycja.lisowska on 12.10.2017.
 */
public class SingleLinkedList<T> {

    private Node head;


    public static class Node<T> {
        // public fields for cleaner code in problems
        public T value;
        public Node next;

        public Node(T value) {
            this.value = value;
        }
    }

    public int getSize() {
        if (head == null)
            return 0;

        Node ptr = head;
        int size = 1;

        while (ptr.next != null) {
            size++;
            ptr = ptr.next;
        }

        return size;
    }

    public void add(T t) {
        assertArgumentNotNull(t);

        Node newNode = new Node(t);

        if (head == null) {
            head = newNode;
        } else {
            Node last = getLast();
            last.next = newNode;
        }
    }

    public void remove(int i) {
        if (i == 0) {
            if (this.head == null) return;
            head = head.next;
        } else {
            Node current = head;
            int currentIndex = 0;
            while (currentIndex < i - 1 && current != null) { // TODO - add end of list check
                current = current.next;
                currentIndex++;
            }

            if (current != null && current.next != null) {
                current.next = current.next.next;
            }
        }
    }

    public Node<T> getLast() {
        Node last = head;
        while (last.next != null) {
            last = last.next;
        }
        return last;
    }


    public Node<T> getFirst() {
        return head;
    }


    private void assertArgumentNotNull(T t) {
        if (t == null) {
            throw new IllegalArgumentException("object cannot be null");
        }
    }


    @Override
    public String toString() {
        StringBuilder b = new StringBuilder();
        Node ptr = head;
        while (ptr != null) {
            b.append(" " + ptr.value + " ");
            ptr = ptr.next;
        }
        b.append("\n\r");
        return b.toString();
    }
}
