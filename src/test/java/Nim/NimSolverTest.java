package Nim;

import org.testng.annotations.Test;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

/**
 * Created by Kendall on 1/14/2016.
 */
public class NimSolverTest {
    @Test
    public void test() {
        NimSolver nim = new NimSolver();

        assertTrue(nim.winRecursive(0, 0, 5));
        assertFalse(nim.winRecursive(0, 1, 1));
        assertTrue(nim.winRecursive(1, 1, 1));
        assertFalse(nim.winRecursive(1, 2, 3));
        assertTrue(nim.winRecursive(1, 2, 4));
        assertFalse(nim.winRecursive(1, 4, 5));
        assertTrue(nim.winRecursive(1, 5, 5));
        assertFalse(nim.winRecursive(1, 6, 7));
        assertTrue(nim.winRecursive(1, 8, 7));
        assertFalse(nim.winRecursive(1, 8, 9));
        assertTrue(nim.winRecursive(1, 8, 10));
        assertFalse(nim.winRecursive(2, 4, 6));
        assertFalse(nim.winRecursive(2, 5, 7));
        assertFalse(nim.winRecursive(3, 4, 7));
        assertFalse(nim.winRecursive(3, 5, 6));
        assertFalse(nim.winRecursive(4, 8, 12));
        assertFalse(nim.winRecursive(4, 9, 13));
        assertFalse(nim.winRecursive(5, 8, 13));
        assertFalse(nim.winRecursive(5, 9, 12));
    }

    @Test
    public void testWinMemoize() throws InterruptedException {
        NimSolver nim = new NimSolver();

        assertTrue(nim.winMemoize(0, 0, 5));
        assertFalse(nim.winMemoize(0, 1, 1));
        assertTrue(nim.winMemoize(1, 1, 1));
        assertFalse(nim.winMemoize(1, 2, 3));
        assertTrue(nim.winMemoize(1, 2, 4));
        assertFalse(nim.winMemoize(1, 4, 5));
        assertTrue(nim.winMemoize(1, 5, 5));
        assertFalse(nim.winMemoize(1, 6, 7));
        assertTrue(nim.winMemoize(1, 8, 7));
        assertFalse(nim.winMemoize(1, 8, 9));
        assertTrue(nim.winMemoize(1, 8, 10));
        assertFalse(nim.winMemoize(2, 4, 6));
        assertFalse(nim.winMemoize(2, 5, 7));
        assertFalse(nim.winMemoize(3, 4, 7));
        assertFalse(nim.winMemoize(3, 5, 6));
        assertFalse(nim.winMemoize(4, 8, 12));
        assertFalse(nim.winMemoize(4, 9, 13));
        assertFalse(nim.winMemoize(5, 8, 13));
        assertFalse(nim.winMemoize(5, 9, 12));
    }

    @Test
    public void testVals() {
        NimSolver nim = new NimSolver();
        assertTrue(nim.winMemoize(16, 13, 17));
        assertFalse(nim.winMemoize(25, 2, 27));
        assertTrue(nim.winMemoize(25, 20, 21));
        assertTrue(nim.winMemoize(31, 15, 21));
        assertFalse(nim.winMemoize(19,3,16));
        assertTrue(nim.winMemoize(18, 24, 27));
    }
}