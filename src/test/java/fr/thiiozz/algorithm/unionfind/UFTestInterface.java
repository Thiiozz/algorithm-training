package fr.thiiozz.algorithm.unionfind;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class UFTestInterface {
    private static final int NUMBER_OF_ELEMENTS = 10;

    private List<String> unions = new ArrayList<>();

    private  UF uf;

    @Before
    public void setUp(){
        uf = new UF(NUMBER_OF_ELEMENTS);
    }

    private void connect(){
        unions.forEach(
                u -> uf.union(
                        Integer.valueOf(u.split(",")[0]),
                        Integer.valueOf(u.split(",")[1])
                )
        );
    }


    @Test
    public void initialNoElementsAreUnited(){
        for(int i = 0; i < NUMBER_OF_ELEMENTS; i++)
            assertTrue(uf.getId()[i] == i);
    }

    @Test
    public void twoElementsCanBeUnited(){
        unions.clear();
        unions.add("4,3");
        connect();

        assertEquals(3, uf.getId()[3]);
        assertEquals(uf.getId()[3], uf.getId()[4]);
    }

    @Test
    public void multipleElementsCanBeUnited(){
        unions.clear();
        unions.add("4,3");
        unions.add("3,8");
        connect();

        assertEquals(8, uf.getId()[3]);
        assertTrue(uf.getId()[3] == uf.getId()[4] && uf.getId()[3] == uf.getId()[8]);
    }
}
