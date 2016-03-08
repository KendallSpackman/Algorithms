package MED;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Kendall on 2/5/2016.
 */
public class WordPairCollection {
    List<Pair<String, String>> wordPairs;

    WordPairCollection() {
        wordPairs = new ArrayList<Pair<String, String>>();
    }

    public void add(String a, String b) {
        wordPairs.add(new Pair<String, String>(a, b));
    }

    public int size() {
        return wordPairs.size();
    }

    public Iterator<Pair<String, String>> iterator() {
        return wordPairs.iterator();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Pair pair : wordPairs) {
            sb.append(pair.getKey()).append("->").append(pair.getValue()).append("\n");
        }
        return sb.toString();
    }
}
