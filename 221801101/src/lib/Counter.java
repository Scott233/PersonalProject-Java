package lib;

import java.io.*;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public final class Counter {

    private static final Comparator<Map.Entry<String, Integer>> sComparator = (e1, e2) -> {
        int retValue = e1.getValue() - e2.getValue();
        if (retValue == 0) retValue = e2.getKey().compareTo(e1.getKey());
        return retValue;
    };

    public Result count(String filePath) {
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
                () -> new Iterator<>() {
                    private final Iterator<Map.Entry<String, Integer>> mSource = wordMap.entrySet()
                            .stream()
                            .sorted((e1, e2) -> {
                                int retVal = e2.getValue() - e1.getValue();
                                if (retVal == 0) retVal = e1.getKey().compareTo(e2.getKey());
                                return retVal;
                            }).iterator();

                    @Override
                    public boolean hasNext() {
                        return mSource.hasNext();
                    }

                    @Override
                    public Map.Entry<String, Integer> next() {
                        return mSource.next();
                    }
                }
        );
    }

}
