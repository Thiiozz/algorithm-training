package fr.thiiozz.algorithm.stackandqueues.deque;

import java.util.Iterator;
import java.util.NoSuchElementException;

public interface Deque<T> {
    boolean isEmpty();
    int size();
    void addFirst(T item) throws IllegalArgumentException;
    void addLast(T item) throws IllegalArgumentException;
    T removeFirst() throws NoSuchElementException;
    T removeLast() throws NoSuchElementException;
    T first() ;
    T last() ;
    Iterator<T> iterator();
}
