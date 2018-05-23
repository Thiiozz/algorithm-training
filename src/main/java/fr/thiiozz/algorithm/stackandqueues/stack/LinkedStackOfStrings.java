package fr.thiiozz.algorithm.stackandqueues.stack;

import fr.thiiozz.algorithm.stackandqueues.model.Node;

public class LinkedStackOfStrings {
    private Node first;

    public void push(String item) {
        Node n = new Node();
        n.item = item;
        n.next = first;

        first = n;
    }

    public String pop() {
        Node oldFirst = first;

        first = first.next;

        return oldFirst.item;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public int size() {
        int size = 0;

        Node n = first;

        while (n != null) {
            size++;
            n = n.next;
        }

        return size;
    }

    public String first() {
        return first.item;
    }
}
