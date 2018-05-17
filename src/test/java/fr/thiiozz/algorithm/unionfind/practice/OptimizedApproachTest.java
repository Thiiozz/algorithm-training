package fr.thiiozz.algorithm.unionfind.practice;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class OptimizedApproachTest extends AbstractUFTest {
    @Before
    public void setUp() {
        uf = new OptimizedApproach(NUMBER_OF_ELEMENTS);
    }


    @Test
    public void initialNoElementsAreUnited() {
        for (int i = 0; i < NUMBER_OF_ELEMENTS; i++)
            assertTrue(uf.getId()[i] == i);
    }

    @Test
    public void twoElementsAreInitialNotUnited() {
        unions.clear();
        unions.add("0,1");
        unions.add("1,2");
        connect();

        assertFalse(uf.connected(4, 3));
    }

    @Test
    public void twoElementsCanBeUnited() {
        unions.clear();
        unions.add("4,3");
        connect();

        assertTrue(uf.connected(4, 3));
    }

    @Test
    public void multipleElementsCanBeUnited() {
        unions.clear();
        unions.add("4,3");
        unions.add("3,8");
        unions.add("8,9");
        unions.add("9,0");
        connect();

        assertTrue(uf.connected(9, 0));
    }
}
