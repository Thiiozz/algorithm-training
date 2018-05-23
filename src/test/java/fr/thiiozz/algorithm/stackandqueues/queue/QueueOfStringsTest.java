package fr.thiiozz.algorithm.stackandqueues.queue;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;

public class QueueOfStringsTest {
    private QueueOfStrings queue;

    @Before
    public void setUp() {
        queue = new QueueOfStrings();
    }

    @Test
    public void canConstructAnEmptyStack() {
        assertEquals(0, queue.size());
        assertTrue(queue.isEmpty());
    }

    @Test
    public void canAccessToTopElementWhileStackContainsOneElement() {
        queue.enqueue("hello");
        assertEquals("hello", queue.first());
    }

    @Test
    public void canAccessToTopElementWhileStackContainsSeveralElements() {
        queue.enqueue("hello");
        queue.enqueue("world");
        queue.enqueue("!");

        assertEquals("!", queue.first());
    }

    @Test
    public void canPopElement() {
        queue.enqueue("hello");
        queue.enqueue("world");
        queue.enqueue("!");

        queue.dequeue();

        assertEquals("world", queue.dequeue());
        assertEquals("hello", queue.first());
    }

    @Test
    public void canCalculateStackValue() {
        queue.enqueue("hello");
        queue.enqueue("hello");
        queue.enqueue("hello");
        queue.enqueue("hello");
        queue.enqueue("hello");

        queue.dequeue();
        queue.dequeue();
        queue.dequeue();

        assertEquals(2, queue.size());
    }
}
