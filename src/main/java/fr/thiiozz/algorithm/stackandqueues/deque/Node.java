package fr.thiiozz.algorithm.stackandqueues.deque;

public class Node<T> {
    T item;
    Node<T> next;
    Node<T> previous;

    public Node(T item, Node<T> next, Node<T> previous) {
        this.item = item;
        this.next = next;
        this.previous = previous;
    }
}
