package Nim;

import com.google.common.base.Stopwatch;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * Created by Kendall on 1/28/2016.
 */
public class ProblemTimer {

    private static String basePath = "src\\main\\java\\Nim\\";

    public static void main(String[] args) throws IOException {
        timeSystem();
    }

    public static void timeGuava() throws IOException {
        NimSolver nimSolver = new NimSolver();
        Stopwatch stopwatch;
        FileWriter writer;
        long time;
        for (int i = 2; i < 11; ++i)
        {
            stopwatch = Stopwatch.createUnstarted();
            stopwatch.start();
            nimSolver.winRecursive(i, i, i);
            stopwatch.stop();
            time = stopwatch.elapsed(TimeUnit.NANOSECONDS);

            writer = new FileWriter(new File(basePath + "recursive.txt"), true);
            writer.write(String.format("%d, %d\n", i, time));
            writer.close();
        }

        for (int i = 2; i < 257; i *= 2)
        {
            stopwatch = Stopwatch.createUnstarted();
            stopwatch.start();
            nimSolver.winMemoize(i, i, i);
            stopwatch.stop();
            time = stopwatch.elapsed(TimeUnit.NANOSECONDS);

            writer = new FileWriter(new File(basePath + "memoizing.txt"), true);
            writer.write(String.format("%d, %d\n", i, time));
            writer.close();
        }

        for (int i = 2; i < 257; i *= 2)
        {
            stopwatch = Stopwatch.createUnstarted();
            stopwatch.start();
            nimSolver.winDP(i, i, i);
            stopwatch.stop();
            time = stopwatch.elapsed(TimeUnit.NANOSECONDS);

            writer = new FileWriter(new File(basePath + "dp.txt"), true);
            writer.write(String.format("%d, %d\n", i, time));
            writer.close();
        }
    }

    public static void timeSystem() throws IOException {
        NimSolver nimSolver = new NimSolver();
        FileWriter writer;
        long start;
        long stop;
        long time;
        for (int i = 2; i < 11; ++i)
        {
            start = System.nanoTime();
            nimSolver.winRecursive(i, i, i);
            stop = System.nanoTime();
            time = stop - start;

            writer = new FileWriter(new File(basePath + "recursive.txt"), true);
            writer.write(String.format("%d, %d\n", i, time));
            writer.close();
        }

        for (int i = 2; i < 257; i *= 2)
        {
            start = System.nanoTime();
            nimSolver.winMemoize(i, i, i);
            stop = System.nanoTime();
            time = stop - start;

            writer = new FileWriter(new File(basePath + "memoizing.txt"), true);
            writer.write(String.format("%d, %d\n", i, time));
            writer.close();
        }

        for (int i = 2; i < 257; i *= 2)
        {
            start = System.nanoTime();
            nimSolver.winDP(i, i, i);
            stop = System.nanoTime();
            time = stop - start;

            writer = new FileWriter(new File(basePath + "dp.txt"), true);
            writer.write(String.format("%d, %d\n", i, time));
            writer.close();
        }
    }
}
