package Nim;

import java.util.Arrays;
import java.util.HashMap;

/**
 * Created by Kendall on 1/14/2016.
 */
public class NimSolver {

    public boolean winRecursive(int a, int b, int c) {
        // Simple solution: If no stones left, you've lost
        if (a == 0 && b == 0 && c == 0) {
            return false;
        }

        // Attempt to force a loss on the other player
        // Recursively call win by trying to take stones from one of the piles until the
        // other player is in a losing situation
        for (int i = 1; i <= a; i++) {
            if (!winRecursive(a - i, b, c)) {
                return true;
            }
        }
        for (int i = 1; i <= b; i++) {
            if (!winRecursive(a, b - i, c)) {
                return true;
            }
        }
        for (int i = 1; i <= c; i++) {
            if (!winRecursive(a, b, c - i)) {
                return true;
            }
        }

        // If you cannot force the other player into a losing situation, you cannot force a win
        return false;
    }

    public boolean winMemoize(int a, int b, int c) {
        Boolean[][][] cache = buildBooleanArray3d(a, b, c);
        return winMemoize(a, b, c, cache);
    }

    private boolean winMemoize(int a, int b, int c, Boolean[][][] cache) {
        if (cache[a][b][c] != null) {
            return cache[a][b][c];
        }

        // Attempt to force a loss on the other player
        for (int i = 1; i <= a; i++) {
            if (!winMemoize(a - i, b, c, cache)) {
                // Store result in cache before returning
                cache[a][b][c] = true;
                return true;
            }
        }
        for (int i = 1; i <= b; i++) {
            if (!winMemoize(a, b - i, c, cache)) {
                cache[a][b][c] = true;
                return true;
            }
        }
        for (int i = 1; i <= c; i++) {
            if (!winMemoize(a, b, c - i, cache)) {
                cache[a][b][c] = true;
                return true;
            }
        }
        // If you cannot force the other player into a losing situation, you cannot force a win
        cache[a][b][c] = false;
        return false;
    }

    public boolean winMemoizeOptimized(int a, int b, int c) {
        HashMap<Integer, Boolean> cache = new HashMap<Integer, Boolean>();
        return winMemoizeOptimized(a, b, c, cache);
    }

    private boolean winMemoizeOptimized(int a, int b, int c, HashMap<Integer, Boolean> cache) {
        int[] arr = { a, b, c };
        Arrays.sort(arr);
        int hashCode = Arrays.hashCode(arr);
        // If have already calculated win/is in cache, simply return it
        if (cache.containsKey(hashCode)) {
            return cache.get(hashCode);
        }

        // Attempt to force a loss on the other player
        for (int i = 1; i <= a; i++) {
            if (!winMemoizeOptimized(a - i, b, c, cache)) {
                // Store result in cache before returning
                cache.put(hashCode, true);
                return true;
            }
        }
        for (int i = 1; i <= b; i++) {
            if (!winMemoizeOptimized(a, b - i, c, cache)) {
                cache.put(hashCode, true);
                return true;
            }
        }
        for (int i = 1; i <= c; i++) {
            if (!winMemoizeOptimized(a, b, c - i, cache)) {
                cache.put(hashCode, true);
                return true;
            }
        }
        // If you cannot force the other player into a losing situation, you cannot force a win
        cache.put(hashCode, false);
        return false;
    }

    public boolean winDP(int a, int b, int c) {
        Boolean[][][] cache = buildBooleanArray3d(a, b, c);
        // Initialize cache
        // Simple solution: If no stones left, you've lost
        cache[0][0][0] = false;

        // Scan through all problems/solutions
        for (int i = 0; i <= a; i++) {
            for (int j = 0; j <= b; j++) {
                for (int k = 0; k <= c; k++) {
                    if (i == 0 && j == 0 && k == 0) {
                        continue;
                    }
                    cache[i][j][k] = calculateWinDP(i, j, k, cache);
                }
            }
        }
        return cache[a][b][c];
    }

    private boolean calculateWinDP(int a, int b, int c, Boolean[][][] cache) {
        // Look up sub-problems in cache
        for (int i = 1; i <= a; i++) {
            if (!cache[a-i][b][c]) {
                return true;
            }
        }
        for (int j = 1; j <= b; j++) {
            if (!cache[a][b-j][c]) {
                return true;
            }
        }
        for (int k = 1; k <= c; k++) {
            if (!cache[a][b][c-k]) {
                return true;
            }
        }

        return false;
    }

    public boolean winDPOptimized(int a, int b, int c) {
        HashMap<Integer, Boolean> cache = new HashMap<Integer, Boolean>();
        // Initialize cache
        // Simple solution: If no stones left, you've lost
        int[] arr = new int[] { 0, 0, 0 };
        int hashCode = Arrays.hashCode(arr);
        cache.put(hashCode, false);

        // Scan through all problems/solutions
        for (int i = 0; i <= a; i++) {
            for (int j = 0; j <= b; j++) {
                for (int k = 0; k <= c; k++) {
                    if (i == 0 && j == 0 && k == 0) {
                        continue;
                    }
                    arr = new int[] { i, j, k };
                    hashCode = Arrays.hashCode(arr);
                    cache.put(hashCode, calculateWinDPOptimized(i, j, k, cache));
                }
            }
        }
        arr = new int[] { a, b, c };
        hashCode = Arrays.hashCode(arr);
        return cache.get(hashCode);
    }

    private boolean calculateWinDPOptimized(int a, int b, int c, HashMap<Integer, Boolean> cache) {
        int[] arr;
        int hashCode;
        // Look up sub-problems in cache
        for (int i = 1; i <= a; i++) {
            arr = new int[] { a - i, b, c };
            hashCode = Arrays.hashCode(arr);
            if (!cache.get(hashCode)) {
                return true;
            }
        }
        for (int j = 1; j <= b; j++) {
            arr = new int[] { a, b - j, c };
            hashCode = Arrays.hashCode(arr);
            if (!cache.get(hashCode)) {
                return true;
            }
        }
        for (int k = 1; k <= c; k++) {
            arr = new int[] { a, b, c - k };
            hashCode = Arrays.hashCode(arr);
            if (!cache.get(hashCode)) {
                return true;
            }
        }

        return false;
    }

    private Boolean[][][] buildBooleanArray3d(int a, int b, int c) {
        Boolean[][][] arr = new Boolean[a+1][][];
        for (int i = 0; i <= a; i++) {
            arr[i] = new Boolean[b+1][];
            for (int j = 0; j <= b; j++) {
                arr[i][j] = new Boolean[c+1];
            }
        }
        return arr;
    }
}
