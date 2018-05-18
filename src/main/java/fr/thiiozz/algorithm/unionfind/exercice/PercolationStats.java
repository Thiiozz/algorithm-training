package fr.thiiozz.algorithm.unionfind.exercice;

import fr.thiiozz.algorithm.commons.StatsHelper;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import static java.util.stream.IntStream.range;

public class PercolationStats {
    private int N;
    private int tries;
    private List<Percolation> percolations;
    private int[] results;

    public PercolationStats(int n, int trials) {
        percolations = new ArrayList<>();
        N = n;
        tries = trials;

        results = new int[trials];

        range(0, trials).forEach(i -> percolations.add(new Percolation(n)));
    }

    public void run(){
        int i = 0;
        System.out.println("Monte carlo simulation started");

        long start = System.currentTimeMillis();

        for(Percolation p : percolations){
            int numberOfTry = 0;

            while(!p.percolates(false)){
                p.open(rand(), rand());
                numberOfTry++;
            }

            results[i] = numberOfTry;

            i++;
        }

        long end = System.currentTimeMillis();

        System.out.println("Simulation finished");

        System.out.println("");
        System.out.println("");

        System.out.println("N: " + String.valueOf(N));
        System.out.println("Trials: " + String.valueOf(tries));

        System.out.println("");

        System.out.println("Mean: " + String.valueOf(StatsHelper.mean(results)));
        System.out.println("Variance: " + String.valueOf(StatsHelper.variance(results)));
        System.out.println("confidenceHi: " + String.valueOf(StatsHelper.confidenceHi(results)));
        System.out.println("confidenceLo: " + String.valueOf(StatsHelper.confidenceLo(results)));

        System.out.println("");
        System.out.println("Processing time: " + String.valueOf((end - start) / 1000) + "sec");
    }

    private int rand(){
        return ThreadLocalRandom.current().nextInt(0, N);
    }
}
