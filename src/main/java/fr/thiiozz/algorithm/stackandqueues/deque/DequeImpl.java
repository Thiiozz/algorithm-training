package fr.thiiozz.algorithm.stackandqueues.deque;

import java.util.Iterator;
import java.util.NoSuchElementException;

/*
    A double-ended queue or deque is a generalization of a stack and a queue that supports adding and removing items
    from either the front or the back of the data structure.
 */
public class DequeImpl<T> implements Deque<T> {
    private Node<T> first;
    private Node<T> last;

    @Override
    public void addFirst(T item) throws IllegalArgumentException {
        if (item == null) {
            throw new IllegalArgumentException("Item cant be null");
        }

        if (first == null) {
            initializeFirstNode(item);
        } else {
            addToTop(item);
        }
    }

    private void initializeFirstNode(T item) {
        first = new Node<>(item, null, null);

        if (last == null) {
            last = first;
        }

        first.previous = last;
    }

    private void addToTop(T item) {
        Node<T> oldFirst = first;

        first = new Node<>(item, null, oldFirst);
        oldFirst.next = first;


        if (last == oldFirst) {
            first.next = null;
            last.previous = null;
        }
    }

    @Override
    public void addLast(T item) throws IllegalArgumentException {
        if (item == null) {
            throw new IllegalArgumentException("Item cant be null");
        }

        if (last == null) {
            initializeLast(item);
        } else {
            addToBottom(item);
        }
    }

    private void initializeLast(T item) {
        last = new Node<>(item, null, null);

        if (first == null) {
            first = last;
        }

        last.next = first;
    }

    private void addToBottom(T item) {
        Node<T> oldLast = last;

        last = new Node<>(item, oldLast, null);
        oldLast.previous = last;

        if (first == oldLast) {
            first.next = null;
            last.previous = null;
        }
    }

    @Override
    public T removeFirst() throws NoSuchElementException {
        checkEmptiness();

        Node<T> oldFirst = first;
        first = oldFirst.previous;

        first.next = null;

        if (first.previous == null) {
            last = first;
        }

        return oldFirst.item;
    }

    @Override
    public T removeLast() throws NoSuchElementException {
        checkEmptiness();

        Node<T> oldLast = last;
        last = oldLast.next;

        last.previous = null;

        if (last.next == null) {
            first = last;
        }

        return oldLast.item;
    }

    private void checkEmptiness() {
        if (isEmpty()) throw new NoSuchElementException("Queue is empty");
    }

    @Override
    public T first() {
        return first.item;
    }

    @Override
    public T last() {
        return last.item;
    }

    @Override
    public boolean isEmpty() {
        return last == null;
    }

    @Override
    public int size() {
        int size = 0;

        if (last != null) {
            Node n = last;

            while (n != null) {
                size++;
                n = n.next;
            }
        }

        return size > 0 ? size : 0;
    }

    @Override
    public Iterator<T> iterator() {
        return new DequeIterator();
    }

    private class DequeIterator implements Iterator<T> {
        Node<T> current = last;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public T next() {
            if (current == null) {
                throw new NoSuchElementException();
            }

            T item = current.item;
            current = current.next;

            return item;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }
}
