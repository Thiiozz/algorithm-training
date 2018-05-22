package fr.thiiozz.algorithm.stackandqueues;

public class FixedCapacityStackOfStrings {
    private String[] s;
    private int N;

    public FixedCapacityStackOfStrings(int capacity) {
        s = new String[capacity];
        N = 0;
    }


    public int size() {
        return N;
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public void push(String hello) {
        s[N++] = hello;
    }

    public String pop() {
        String item = s[--N];
        s[N] = null;

        return item;
    }

    public String first() {
        return s[N - 1];
    }
}
