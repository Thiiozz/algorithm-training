package fr.thiiozz.algorithm.unionfind.exercice;

import fr.thiiozz.algorithm.unionfind.practice.OptimizedApproach;
import fr.thiiozz.algorithm.unionfind.practice.UF;

public class Percolation {
    public static final int OPEN = 0;
    public static final int CLOSE = 1;

    private int gridDimension;
    private int[][] grid;

    private UF uf;

    public Percolation(int N) {
        gridDimension = N;
        grid = new int[N][N];

        populateGrid();

        uf = new OptimizedApproach(N * N);
    }

    private void populateGrid() {
        for (int i = 0; i < gridDimension; i++)
            for (int j = 0; j < gridDimension; j++)
                grid[i][j] = CLOSE;
    }

    public void open(int row, int col) {
        grid[row][col] = OPEN;
        connectNeighbors(row, col);
    }

    private void connectNeighbors(int row, int col) {
        int siteOneDOpenIndex = oneDimensionalIndex(row, col);

        if (row > 0) {
            uf.union(
                    siteOneDOpenIndex,
                    oneDimensionalIndex(row - 1, col)
            );
        }

        if (row < gridDimension - 1) {
            uf.union(
                    siteOneDOpenIndex,
                    oneDimensionalIndex(row + 1, col)
            );
        }

        if (col > 0) {
            uf.union(
                    siteOneDOpenIndex,
                    oneDimensionalIndex(row, col - 1)
            );
        }

        if (col < gridDimension - 1) {
            uf.union(
                    siteOneDOpenIndex,
                    oneDimensionalIndex(row, col + 1)
            );
        }
    }

    public boolean isOpen(int row, int col) {
        return grid[row][col] == OPEN;
    }

    public boolean isFull(int row, int col) {
        for (int i = 0; i < gridDimension; i++) {
            if (grid[0][i] == OPEN) {
                return uf.connected(
                        oneDimensionalIndex(0, i),
                        oneDimensionalIndex(row, col)
                );
            }
        }

        return false;
    }

    public int numberOfOpenSites() {
        int numberOfOpenSites = 0;

        for (int i = 0; i < gridDimension; i++)
            for (int j = 0; j < gridDimension; j++)
                if (grid[i][j] == OPEN) numberOfOpenSites++;

        return numberOfOpenSites;
    }

    public boolean percolates() {
        for (int i = 0; i < gridDimension; i++) {
            if (grid[0][i] == OPEN) {
                for (int j = 0; j < gridDimension; j++) {
                    if (grid[gridDimension - 1][j] == OPEN) {
                        return uf.connected(
                                oneDimensionalIndex(gridDimension - 1, j),
                                oneDimensionalIndex(0, i)
                        );
                    }
                }
            }
        }



        return false;
    }

    private int oneDimensionalIndex(int row, int col) {
        return (row + 1) * (col + 1);
    }

    public int[][] grid() {
        return grid;
    }
}
