package fr.thiiozz.algorithm.unionfind.exercice;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class PercolationTest {
    private static final int N = 10;

    private Percolation p;

    @Before
    public void setUp() {
        p = new Percolation(N);
    }

    @Test
    public void canPopulateGrid() {
        assertEquals(N, p.grid().length);
        assertEquals(N, p.grid()[0].length);
    }

    @Test
    public void initiallyASiteIsClosed() {
        assertEquals(Percolation.CLOSE, p.grid()[0][0]);
    }

    @Test
    public void aSiteCanBeOpen() {
        p.open(0, 0);

        assertTrue(p.isOpen(0, 0));
    }

    @Test
    public void topRowSiteAreFullIfOpen(){
        p.open(0, 0);

        assertTrue(p.isFull(0, 0));
    }

    @Test
    public void secondLineRowSiteAreFullIfOpenAndConnectedWithAnOpenTopRowSite(){
        p.open(0, 0);
        p.open(1, 0);
        p.open(2, 0);

        assertTrue(p.isFull(2, 0));
    }

    @Test
    public void knowWhenGridPercolates(){
        p.open(0, 0);
        p.open(1, 0);
        p.open(2, 0);
        p.open(3, 0);
        p.open(4, 0);
        p.open(5, 0);
        p.open(6, 0);
        p.open(7, 0);
        p.open(8, 0);
        p.open(9, 0);

        assertTrue(p.percolates());
    }

    @Test
    public void canCalculateNumberOfOpenSites(){
        p.open(0,0);
        p.open(0,0);
        p.open(0,1);
        p.open(1,1);

        assertEquals(3, p.numberOfOpenSites());
    }
}
