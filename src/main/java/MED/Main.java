package MED;

import javafx.util.Pair;

import java.io.*;
import java.util.*;

/**
 * Created by Kendall on 2/5/2016.
 */
public class Main {

    public static void main(String[] args) throws InterruptedException, IOException {
        String basePath = "src\\main\\java\\MED\\";
        File file = new File(basePath + "input.txt");
        List<Pair<String, String>> stringPairs = readFile(file);
        Map<Integer, WordPairCollection> map = processPairs(stringPairs);

        //String output = buildSummary(map);
        String output = buildOutput(map);
        System.out.println(output);
        File outFile = new File(basePath + "output.csv");
        FileWriter fileWriter = new FileWriter(outFile);
        fileWriter.write(output);
        fileWriter.close();
    }

    public static List<Pair<String, String>> readFile(File file) throws IOException {
        List<Pair<String, String>> pairsList = new ArrayList<Pair<String, String>>();
        BufferedReader reader = new BufferedReader(new FileReader(file));
        for(String line; (line = reader.readLine()) != null; ) {
            int index = line.indexOf("->");
            String first = line.substring(0, index);
            String second = line.substring(index + 2);

            if (second.contains(",")) {
                String[] strings = second.split("\\s*,\\s*");
                for (String string : strings) {
                    pairsList.add(new Pair(first, string));
                }
            } else {
                pairsList.add(new Pair(first, second));
            }
        }
        return pairsList;
    }

    public static Map<Integer, WordPairCollection> processPairs(List<Pair<String, String>> stringPairs) {
        Map<Integer, WordPairCollection> map = new HashMap<Integer, WordPairCollection>();
        for (Pair<String, String> pair : stringPairs) {
            String first = pair.getKey();
            String second = pair.getValue();
            MED med = new MED(first, second);
            int numEdits = med.numEditsDP(first.length(), second.length());

            WordPairCollection wordPairCollection = map.get(numEdits);
            if (wordPairCollection == null) {
                wordPairCollection = new WordPairCollection();
                map.put(numEdits, wordPairCollection);
            }
            wordPairCollection.add(first, second);
        }

        return map;
    }

    public static String buildSummary(Map<Integer, WordPairCollection> map) {
        Map<Integer, WordPairCollection> map2 = new TreeMap<Integer, WordPairCollection>(map);
        StringBuilder sb = new StringBuilder("Distance, Count\n");

        for (Map.Entry entry : map2.entrySet()) {
            sb.append(entry.getKey()).append(", ")
                    .append(((WordPairCollection) entry.getValue()).size()).append("\n");
        }

        return sb.toString();
    }

    public static String buildOutput(Map<Integer, WordPairCollection> map) {
        Map<Integer, WordPairCollection> map2 = new TreeMap<Integer, WordPairCollection>(map);
        StringBuilder sb = new StringBuilder("Count, First, Second\n");

        for (Map.Entry<Integer, WordPairCollection> entry : map2.entrySet()) {
            WordPairCollection collection = entry.getValue();
            int distance = entry.getKey();
            Iterator<Pair<String, String>> it = collection.iterator();
            while (it.hasNext()) {
                Pair<String, String> pair = it.next();
                sb.append(distance).append(", ")
                        .append(pair.getKey()).append(", ")
                        .append(pair.getValue()).append("\n");
            }
        }

        return sb.toString();
    }
}
