package fr.thiiozz.algorithm.stackandqueues.queue;


public class Queue<E> {
    private class Node{
        E item;
        Node next;
    }

    private Node first;
    private Node last;

    public void enqueue(E item) {
        Node oldLast = last;

        last = new Node();

        last.item = item;
        last.next = null;

        if (isEmpty())
            first = last;
        else
            oldLast.next = last;
    }

    public E dequeue() {
        E item = first.item;

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

    public E front() {
        return first.item;
    }
}
