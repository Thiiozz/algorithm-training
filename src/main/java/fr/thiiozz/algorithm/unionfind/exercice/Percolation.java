package fr.thiiozz.algorithm.unionfind.exercice;

import fr.thiiozz.algorithm.unionfind.practice.OptimizedApproach;
import fr.thiiozz.algorithm.unionfind.practice.UF;

import static java.util.Arrays.stream;
import static java.util.stream.IntStream.range;

public class Percolation {
    public static final int OPEN = 0;
    public static final int CLOSE = 1;

    private int gridDimension;
    private int N;
    private int[] grid;

    private UF uf;

    public Percolation(int N) {
        gridDimension = N;
        this.N = N * N;

        grid = new int[this.N];

        uf = new OptimizedApproach(this.N);

        populateGrid();
    }

    private void populateGrid() {
        range(0, N).forEach(i -> grid[i] = CLOSE);
    }

    public void open(int row, int col) {
        if (!isOpen(row, col)) {
            grid[oneDimensionalIndex(row, col)] = OPEN;
            connectNeighbors(row, col);
        }
    }

    private void connectNeighbors(int row, int col) {
        int siteOneDOpenIndex = oneDimensionalIndex(row, col);

        if (row > 0) {
            if (isOpen(row - 1, col))
                uf.union(
                        siteOneDOpenIndex,
                        oneDimensionalIndex(row - 1, col)
                );
        }

        if (row < gridDimension - 1) {
            if (isOpen(row + 1, col))
                uf.union(
                        siteOneDOpenIndex,
                        oneDimensionalIndex(row + 1, col)
                );
        }

        if (col > 0) {
            if (isOpen(row, col - 1))
                uf.union(
                        siteOneDOpenIndex,
                        oneDimensionalIndex(row, col - 1)
                );
        }

        if (col < gridDimension - 1) {
            if (isOpen(row, col + 1))
                uf.union(
                        siteOneDOpenIndex,
                        oneDimensionalIndex(row, col + 1)
                );
        }
    }

    public boolean isOpen(int row, int col) {
        return grid[oneDimensionalIndex(row, col)] == OPEN;
    }

    public boolean isFull(int row, int col) {
        for (int i = 0; i < gridDimension; i++) {
            if (grid[i] == OPEN) {
                if (uf.connected(
                        oneDimensionalIndex(0, i),
                        oneDimensionalIndex(row, col)
                )) return true;
            }
        }

        return false;
    }

    public int numberOfOpenSites() {
        return (int) stream(grid).filter(i -> i == OPEN).count();
    }

    public boolean percolates(boolean debug) {
        if(debug)
            displayGrid();

        for (int j = 0; j < gridDimension; j++) {

            int i = oneDimensionalIndex(gridDimension - 1, j);

            if (grid[i] == OPEN) {
                if (isFull(gridDimension - 1, j)) {
                    return true;
                }
            }
        }

        return false;
    }

    private int oneDimensionalIndex(int row, int col) {
        return (row * gridDimension) + (col + 1) - 1;
    }

    public int[] grid() {
        return grid;
    }


    public void displayGrid(){
        int charsOnActualRow = 0;

        for (int i = 0; i < N; i++){
            if(charsOnActualRow > gridDimension - 1){
                System.out.println("");
                charsOnActualRow = 0;
            }

            System.out.print(String.valueOf(grid[i]).concat(" "));
            charsOnActualRow++;
        }
    }
}
