package fr.thiiozz.algorithm.stackandqueues.stack;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;

public class ArrayStackOfStringsTest {
    private ArrayStackOfStrings stack;

    @Before
    public void setUp() {
        stack = new ArrayStackOfStrings(1);
    }

    @Test
    public void canConstructAnEmptyStack() {
        assertEquals(0, stack.size());
        assertTrue(stack.isEmpty());
    }

    @Test
    public void canAccessToTopElementWhileStackContainsOneElement() {
        stack.push("hello");
        assertEquals("hello", stack.first());
    }

    @Test
    public void canAccessToTopElementWhileStackContainsSeveralElements() {
        stack.push("hello");
        stack.push("world");
        stack.push("!");

        assertEquals("!", stack.first());
    }

    @Test
    public void canPopElement() {
        stack.push("hello");
        stack.push("world");
        stack.push("!");

        stack.pop();

        assertEquals("world", stack.pop());
        assertEquals("hello", stack.first());
    }

    @Test
    public void canCalculateStackValue() {
        stack.push("hello");
        stack.push("hello");
        stack.push("hello");
        stack.push("hello");
        stack.push("hello");

        stack.pop();
        stack.pop();
        stack.pop();

        assertEquals(2, stack.size());
    }
}
