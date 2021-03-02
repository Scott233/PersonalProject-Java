package entry;

import java.util.Map;

public class Entry {
    public final String word;
    public final int count;

    public Entry(String word, int count) {
        this.word = word;
        this.count = count;
    }

    public Entry(Map.Entry<String, Integer> that) {
        this(that.getKey(), that.getValue());
    }
}
