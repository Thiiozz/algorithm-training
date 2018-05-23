package fr.thiiozz.algorithm.stackandqueues.queue;

import fr.thiiozz.algorithm.stackandqueues.model.Node;

public class QueueOfStrings {
    private Node first;
    private Node last;

    public void enqueue(String item) {
        Node oldLast = last;

        last = new Node();

        last.item = item;
        last.next = null;

        if (isEmpty())
            first = last;
        else
            oldLast.next = last;
    }

    public String dequeue() {
        String item = first.item;

        first = first.next;

        if (isEmpty()) last = null;

        return item;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public int size() {
        int size = 0;

        Node n = first;

        while (n != null) {
            n = n.next;
            size++;
        }

        return size;
    }

    public String front() {
        return first.item;
    }
}
