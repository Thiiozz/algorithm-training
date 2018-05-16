package fr.thiiozz.algorithm.unionfind;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class DumbApproachTest extends AbstractUFTest {
    @Before
    public void setUp() {
        uf = new DumbApproach(NUMBER_OF_ELEMENTS);
    }


    @Test
    public void initialNoElementsAreUnited() {
        for (int i = 0; i < NUMBER_OF_ELEMENTS; i++)
            assertTrue(uf.getId()[i] == i);
    }

    @Test
    public void twoElementsCanBeUnited() {
        unions.clear();
        unions.add("4,3");
        connect();

        assertEquals(3, uf.getId()[3]);
        assertEquals(uf.getId()[3], uf.getId()[4]);
    }

    @Test
    public void multipleElementsCanBeUnited() {
        unions.clear();
        unions.add("4,3");
        unions.add("3,8");
        connect();

        assertEquals(8, uf.getId()[3]);
        assertTrue(uf.getId()[3] == uf.getId()[4] && uf.getId()[3] == uf.getId()[8]);
    }
}
