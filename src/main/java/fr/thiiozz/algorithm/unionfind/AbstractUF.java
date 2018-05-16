package fr.thiiozz.algorithm.unionfind;

public abstract class AbstractUF implements UF{
    protected int[] id;

    public AbstractUF(int N) {
        id = new int[N];

        for (int i = 0; i < N; i++) {
            id[i] = i;
        }
    }

    @Override
    public void union(int p, int q) {

    }

    @Override
    public boolean connected(int p, int q) {
        return false;
    }

    @Override
    public int[] getId() {
        return id;
    }
}
