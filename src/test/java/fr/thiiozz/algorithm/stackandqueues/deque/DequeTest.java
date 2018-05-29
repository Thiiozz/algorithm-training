package fr.thiiozz.algorithm.stackandqueues.deque;

import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;
import java.util.NoSuchElementException;

import static junit.framework.TestCase.*;

public class DequeTest {
    private static final String S1 = "HELLO";
    private static final String S2 = "WORLD";
    private static final String S3 = "!";

    private Deque<String> c;

    @Before
    public void setUp() {
        c = new DequeImpl<>();
    }

    @Test
    public void isInitiallyEmpty() {
        assertTrue(c.isEmpty());
        assertEquals(0, c.size());
    }

    @Test
    public void canAddOneElementToTheHead() {
        c.addFirst(S1);
        assertEquals(S1, c.first());
    }

    @Test
    public void canAddMultipleElementToTheHead() {
        c.addFirst(S1);
        c.addFirst(S2);
        c.addFirst(S3);

        assertEquals(S3, c.first());
    }

    @Test
    public void canAddOneElementToTheTail() {
        c.addLast(S1);
        assertEquals(S1, c.last());
    }

    @Test
    public void canAddMultipleElementToTheTail() {
        c.addLast(S1);
        c.addLast(S2);
        c.addLast(S3);

        assertEquals(S3, c.last());
        assertEquals(S1, c.first());
    }

    @Test
    public void canAddElementToTheTailAndToTheHead() {
        for (int i = 0; i < 100; i++) {
            c.addFirst(S1.concat(String.valueOf(i)));
        }

        for (int i = 0; i < 100; i++) {
            c.addLast(S2.concat(String.valueOf(i)));
        }

        assertEquals(S1.concat("99"), c.first());
        assertEquals(S2.concat("99"), c.last());

        assertEquals(200, c.size());
        assertFalse(c.isEmpty());
    }

    @Test
    public void canPopFirst() {
        c.addFirst(S1);
        c.addFirst(S2);
        c.addFirst(S3);

        assertEquals(S3, c.removeFirst());
        assertEquals(S2, c.removeFirst());
        assertEquals(S1, c.first());

        assertEquals(1, c.size());
    }

    @Test
    public void canPopLast() {
        c.addLast(S1);
        c.addLast(S2);
        c.addLast(S3);

        assertEquals(S3, c.removeLast());
        assertEquals(S2, c.removeLast());
        assertEquals(S1, c.last());
        assertEquals(1, c.size());
    }


    @Test
    public void canMergeHeadAndTail() {
        c.addLast(S1);
        c.addFirst(S2);
        c.addFirst(S3);

        assertEquals(S1, c.removeLast());
        assertEquals(S3, c.removeFirst());

        assertEquals(c.last(), c.first());
        assertEquals(S2, c.last());
    }

    @Test(expected = IllegalArgumentException.class)
    public void rejectNullItemsOnTail() {
        c.addLast(null);
    }

    @Test(expected = NoSuchElementException.class)
    public void rejectAccessWhileQueueIsEmpty() {
        c.removeFirst();
    }

    @Test(expected = IllegalArgumentException.class)
    public void rejectNullItemsOnHead() {
        c.addFirst(null);
    }

    @Test
    public void iteratorCanIterateAlOverTheQueue(){
        int numberOfElementFind = 0;

        c.addLast(S1);
        c.addLast(S2);
        c.addLast(S3);

        Iterator<String> it = c.iterator();

        while (it.hasNext()){
            it.next();
            numberOfElementFind++;
        }

        assertEquals(3, numberOfElementFind);
    }

    @Test(expected = NoSuchElementException.class)
    public void iteratorThrowExceptionOnIllegalAccess(){
        c.iterator().next();
    }

    @Test(expected = UnsupportedOperationException.class)
    public void iteratorThrowExceptionOnIllegalOperation(){
        c.iterator().remove();
    }
}
