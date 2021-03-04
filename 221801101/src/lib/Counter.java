package lib;

import java.io.*;
import java.util.*;
import java.util.stream.Stream;

public final class Counter {

    public final Result count(String filePath) {
        int charCount = 0;
        int lineCount = 0;
        HashMap<String, Integer> wordMap = new HashMap<>();

        StringBuilder builder = new StringBuilder(32);
        try (Reader reader = new BufferedReader(new FileReader(filePath))) {
            boolean incLine = false;
            for (; ; ) {
                int ch = Character.toLowerCase(reader.read());
                if (Character.isLetterOrDigit(ch)) {
                    builder.appendCodePoint(ch);
                    incLine = true;
                } else {
                    if (Util.isWord(builder)) {
                        String word = builder.toString();
                        int count = wordMap.getOrDefault(word, 0) + 1;
                        wordMap.put(word, count);
                    }
                    builder.setLength(0);
                    if (ch == '\n' && incLine) {
                        ++lineCount;
                        incLine = false;
                    }
                    if (!Character.isWhitespace(ch) && ch > 0)
                        incLine = true;
                    if (ch < 0) {
                        if (incLine)
                            ++lineCount;
                        break;
                    }
                }
                ++charCount;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return new Result(
                charCount,
                wordMap.size(),
                lineCount,
                buildIterable(wordMap)
        );
    }

    private static Iterable<Map.Entry<String, Integer>> buildIterable(HashMap<String, Integer> map) {
        return map.entrySet().stream().sorted(Counter::compare)::iterator;
    }

    private static int compare(Map.Entry<String, Integer> e1, Map.Entry<String, Integer> e2) {
        int retVal = e2.getValue() - e1.getValue();
        if (retVal == 0) retVal = e1.getKey().compareTo(e2.getKey());
        return retVal;
    }

}
