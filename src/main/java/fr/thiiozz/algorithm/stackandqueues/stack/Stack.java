package fr.thiiozz.algorithm.stackandqueues.stack;

import java.util.Iterator;

public class Stack<E> implements Iterable<E>{
    private class Node{
        E item;
        Node next;
    }

    private Node first;

    public void push(E item) {
        Node n = new Node();
        n.item = item;
        n.next = first;

        first = n;
    }

    public E pop() {
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

    public E first() {
        return first.item;
    }

    @Override
    public Iterator<E> iterator() {
        return new CustomIterator();
    }

    private class CustomIterator implements Iterator<E> {
        private Node current = first;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public E next() {
            E item = current.item;
            current = current.next;

            return item;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException("Remove not supported !");
        }
    }
}
