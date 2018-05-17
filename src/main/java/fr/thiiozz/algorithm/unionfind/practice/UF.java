package fr.thiiozz.algorithm.unionfind.practice;

public interface UF {

    void union(int p, int q);

    boolean connected(int p, int q);

    int[] getId();
}
