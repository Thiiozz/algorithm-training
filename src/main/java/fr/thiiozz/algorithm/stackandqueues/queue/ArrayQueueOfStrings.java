package fr.thiiozz.algorithm.stackandqueues.queue;

public class ArrayQueueOfStrings {
    private String[] s;

    private int head;
    private int tail;

    public ArrayQueueOfStrings() {
        // CHEATED HERE !
        // Array does not resizing dynamically
        this.s = new String[100];
        head = tail = 0;
    }

    public void enqueue(String item) {
        s[tail++] = item;
        if (tail == s.length) resize(s.length * 2);
    }

    public String dequeue() {
        String item = s[head];
        s[head++] = null;

        if (head > 0 && head == s.length / 4){
            resize(s.length / 2);
            head /= 2;
            tail /= 2;
        }

        return item;
    }

    public boolean isEmpty() {
        return head == 0;
    }

    private void resize(int capacity) {
        String[] copy = new String[capacity];

        System.arraycopy(s, 0, copy, 0, size() - 1);

        s = copy;
    }

    public int size() {
        return tail - head;
    }

    public String front() {
        return s[head];
    }
}
