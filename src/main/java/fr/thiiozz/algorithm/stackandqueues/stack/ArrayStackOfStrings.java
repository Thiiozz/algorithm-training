package fr.thiiozz.algorithm.stackandqueues.stack;

public class ArrayStackOfStrings extends FixedCapacityStackOfStrings {
    public ArrayStackOfStrings(int capacity) {
        super(capacity);
    }

    @Override
    public void push(String item) {
        if (N == s.length) resize(2 * s.length);
        super.push(item);
    }

    @Override
    public String pop() {
        String item = s[--N];
        s[N] = null;
        if (N > 0 && N == s.length / 4) resize(s.length / 2);

        return item;

    }

    private void resize(int capacity) {
        String[] copy = new String[capacity];

        System.arraycopy(s, 0, copy, 0, N);

        s = copy;
    }
}
