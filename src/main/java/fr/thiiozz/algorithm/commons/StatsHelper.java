package fr.thiiozz.algorithm.commons;

import static java.lang.StrictMath.sqrt;
import static java.util.Arrays.stream;

public class StatsHelper {
    public static float mean(int[] n) {
        return stream(n).sum() / n.length;
    }

    public static float variance(int[] n) {
        float sum = 0;
        float nMean = mean(n);

        for (int e : n) {
            sum += (e - nMean) * (e - nMean);
        }

        return sum / (n.length - 1);
    }

    public static float confidenceLo(int[] n) {
        return mean(n) + thresold(n, true);
    }

    public static float confidenceHi(int[] n) {
        return mean(n) + thresold(n, false);
    }

    private static float thresold(int[] n, boolean negative) {
        return negative ? -1 : 1 * (float) (1.96 / sqrt(n.length));
    }
}
