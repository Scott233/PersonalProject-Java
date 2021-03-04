package lib;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Iterator;
import java.util.Map;

public final class Printer {

    public final void print(Result result, String filePath) {
        try (Writer writer = new BufferedWriter(new FileWriter(filePath))) {
            writer.write("characters: ");
            writer.write(String.valueOf(result.charCount));
            writer.write('\n');
            writer.write("words: ");
            writer.write(String.valueOf(result.wordCount));
            writer.write('\n');
            writer.write("lines: ");
            writer.write(String.valueOf(result.lineCount));
            writer.write('\n');
            Iterable<Map.Entry<String, Integer>> wrapper = () -> new Iterator<>() {
                private final Iterator<Map.Entry<String, Integer>> mSource = result.mostFrequent.iterator();
                private int mCount = 0;

                @Override
                public boolean hasNext() {
                    return mSource.hasNext() && mCount < 10;
                }

                @Override
                public Map.Entry<String, Integer> next() {
                    ++mCount;
                    return mSource.next();
                }
            };
            for (Map.Entry<String, Integer> it : wrapper) {
                writer.write(it.getKey());
                writer.write(": ");
                writer.write(String.valueOf(it.getValue()));
                writer.write('\n');
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
