package lib;

import java.util.Map;

public final class Result {

    public final int charCount;
    public final int wordCount;
    public final int lineCount;
    public final Iterable<Map.Entry<String, Integer>> mostFrequent;

    public Result(int charCount, int wordCount, int lineCount, Iterable<Map.Entry<String, Integer>> mostFrequent) {
        this.charCount = charCount;
        this.wordCount = wordCount;
        this.lineCount = lineCount;
        this.mostFrequent = mostFrequent;
    }

}
