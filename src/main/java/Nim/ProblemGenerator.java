package Nim;

import java.util.Random;

/**
 * Created by Kendall on 1/20/2016.
 */
public class ProblemGenerator {

    private static int smallProbMin = 1;
    private static int smallProbMax = 7;
    private static int largeProbMin = 1;
    private static int largeProbMax = 30;

    private static Random random = new Random();

    public static void main(String[] args) throws InterruptedException {
        NimSolver nimSolver = new NimSolver();

        System.out.println("Starting 1,000 sample runs of all three algorithms " +
                "using smaller problem inputs");
        for (int i = 0; i < 1000; i++) {
            int a = randomIntBetween(smallProbMin, smallProbMax);
            int b = randomIntBetween(smallProbMin, smallProbMax);
            int c = randomIntBetween(smallProbMin, smallProbMax);
            boolean recursive = nimSolver.winRecursive(a, b, c);
            boolean memoize = nimSolver.winMemoize(a, b, c);
            boolean dp = nimSolver.winDP(a, b, c);
            boolean memoizeOptimized = nimSolver.winMemoizeOptimized(a, b, c);
            boolean dpOptimized = nimSolver.winDPOptimized(a, b, c);
//            StringBuilder sb = new StringBuilder();
//            sb.append(a).append(" ")
//              .append(b).append(" ")
//              .append(c).append(" ")
//              .append(recursive ? "True" : "False").append("|")
//              .append(memoize ? "True" : "False").append("|")
//              .append(dp ? "True" : "False").append("|")
//              .append(memoizeOptimized ? "True" : "False").append("|")
//              .append(dpOptimized ? "True" : "False");
//            System.out.println(sb.toString());
            if (recursive != memoize || memoize != dp || dp != memoizeOptimized || memoizeOptimized != dpOptimized) {
                throw new RuntimeException(String.format(
                        "The five methods did not return the same value for inputs %d, %d, and %d!", a, b, c));
            }
        }
        System.out.println("Finished sample runs of all three algorithms");

        System.out.println("Starting 1,000 sample runs of the second and third algorithms " +
                "using larger problem inputs");
        for (int i = 0; i < 1000; i++) {
            int a = randomIntBetween(largeProbMin, largeProbMax);
            int b = randomIntBetween(largeProbMin, largeProbMax);
            int c = randomIntBetween(largeProbMin, largeProbMax);
            boolean memoize = nimSolver.winMemoize(a, b, c);
            boolean dp = nimSolver.winDP(a, b, c);
            boolean memoizeOptimized = nimSolver.winMemoizeOptimized(a, b, c);
            boolean dpOptimized = nimSolver.winDPOptimized(a, b, c);
            if (memoize != dp || dp != memoizeOptimized || memoizeOptimized != dpOptimized) {
                throw new RuntimeException(String.format(
                        "The last four methods did not return the same value for inputs %d, %d, and %d!", a, b, c));
            }
        }
        System.out.println("Finished sample runs of memoizing and DP algorithms");

        System.out.println("Success!!");
        Thread.sleep(1000);
    }

    private static int randomIntBetween(int min, int max) {
        return min + random.nextInt(max - min + 1);
    }
}
