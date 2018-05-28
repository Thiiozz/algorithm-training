package fr.thiiozz.algorithm.stackandqueues.stack;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;

public class StackTest {
    private Stack<String> stack;

    @Before
    public void setUp() {
        stack = new Stack<>();
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

    @Test
    public void iterable(){
        Stack<Integer> intStack = new Stack<>();

        intStack.push(1);
        intStack.push(2);
        intStack.push(3);
        intStack.push(4);
        intStack.push(5);

        for(Integer s : intStack){
            System.out.println(s);
        }
    }
}
