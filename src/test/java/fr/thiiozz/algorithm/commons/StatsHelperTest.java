package fr.thiiozz.algorithm.commons;

import fr.thiiozz.algorithm.commons.StatsHelper;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class StatsHelperTest {
    private int[] n;

    @Before
    public void setUp(){
        n = new int[4];

        n[0] = 1;
        n[1] = 1;
        n[2] = 3;
        n[3] = 3;
    }

    @Test
    public void canCalculateMean(){
        assertEquals(2F,  StatsHelper.mean(n), 0.01F);
    }

    @Test
    public void canCalculateVariance(){
        assertEquals(1.33F,  StatsHelper.variance(n), 0.01F);
    }

    @Test
    public void canCalculateConfidenceLo(){
        assertEquals(2.98F,  StatsHelper.confidenceHi(n), 0.01F);
    }

    @Test
    public void canCalculateConfidenceHi(){
        assertEquals(1.0F,  StatsHelper.confidenceLo(n), 0.01F);
    }
}
