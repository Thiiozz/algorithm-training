package fr.thiiozz.algorithm.unionfind.practice;

public class LazyApproach extends AbstractUF {
    public LazyApproach(int N) {
        super(N);
    }

    @Override
    public void union(int p, int q) {
       int i = root(p);
       int j = root(q);

       id[i] = j;
    }

    @Override
    public boolean connected(int p, int q) {
        return root(p) == root(q);
    }

    private int root(int i) {
        return (i == id[i]) ? i : root(id[i]);
    }
}
