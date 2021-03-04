package lib;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.HashMap;
import java.util.Map;

public final class Counter {

    public final Result count(final String filePath) {
        int charCount = 0;
        int lineCount = 0;
        final Map<String, Integer> wordMap = new HashMap<>();

        final StringBuilder builder = new StringBuilder(32);
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
                wordMap.entrySet().stream().sorted(Counter::compare)::iterator
        );
    }

    private static int compare(Map.Entry<String, Integer> e1, Map.Entry<String, Integer> e2) {
        int retVal = e2.getValue() - e1.getValue();
        if (retVal == 0) retVal = e1.getKey().compareTo(e2.getKey());
        return retVal;
    }

}
