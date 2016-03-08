package MED;

/**
 * This class will compute the minimal edit distance between String a and String b.
 * numEditsRecursive is a recursive solution, while numEditsDP is a dynamic programming
 * solution using a 2D array.
 * For more info, see https://en.wikipedia.org/wiki/Edit_distance
 *
 * Created by Kendall on 2/5/2016.
 */
public class MED {

    String strA;
    String strB;

    public MED(String a, String b) {
        this.strA = a;
        this.strB = b;
    }

    public int numEditsRecursive(int i, int j) {
        if (i == 0) {
            return j;
        }
        if (j == 0) {
            return i;
        }
        int extra;
        if (strA.charAt(i - 1) == strB.charAt(j - 1)) {
            extra = 0;
        }
        else {
            extra = 1;
        }
        int min = Math.min(numEditsRecursive(i - 1, j) + 1, numEditsRecursive(i, j - 1) + 1);
        min = Math.min(min, numEditsRecursive(i - 1, j - 1) + extra);
        return min;
    }

    public int numEditsDP(int a, int b) {
        int cache[][] = new int[a + 1][];
        for (int i = 0; i < a + 1; i++) {
            cache[i] = new int[b + 1];
        }
        cache[0][0] = 0;
        for (int i = 0; i <= a; ++i) {
            cache[i][0] = i;
        }
        for (int j = 0; j <= b; ++j) {
            cache[0][j] = j;
        }
        for (int i = 1; i <= a; ++i) {
            for (int j = 1; j <= b; ++j) {
                int value = Math.min(cache[i - 1][j] + 1, cache[i][j - 1] + 1);
                int extra;
                if (strA.charAt(i - 1) == strB.charAt(j - 1)) {
                    extra = 0;
                }
                else {
                    extra = 1;
                }
                value = Math.min(value, cache[i - 1][j - 1] + extra);
                cache[i][j] = value;
            }
        }
        return cache[a][b];
    }
}
