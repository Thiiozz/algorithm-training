package fr.thiiozz.algorithm.unionfind;

public interface UF {

    void union(int p, int q);

    boolean connected(int p, int q);

    int[] getId();
}
