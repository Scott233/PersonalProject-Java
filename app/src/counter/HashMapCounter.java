package counter;

import entry.Entry;
import repository.Repository;
import result.Result;
import result.SimpleResult;

import java.util.*;

public class HashMapCounter extends Counter implements Comparator<String> {

    private int mCharCount = 0;
    private int mLineCount = 0;
    private final Map<String, Integer> mWordMap = new HashMap<>();

    public HashMapCounter(Repository repository) {
        super(repository);
    }

    @Override
    protected void onNextChar() {
        ++mCharCount;
    }

    @Override
    protected void onNextLine(boolean contentful) {
        if (contentful) ++mLineCount;
    }

    @Override
    protected void onNextWord(String word) {
        int count = mWordMap.getOrDefault(word, 0) + 1;
        mWordMap.put(word, count);
    }

    @Override
    protected Result buildResult() {
        return new SimpleResult(
                mCharCount,
                mWordMap.size(),
                mLineCount,
                () -> new Iterator<>() {
                    private int mCount = 0;
                    private final Iterator<String> mSource = mWordMap.keySet().stream().sorted(HashMapCounter.this).iterator();

                    @Override
                    public boolean hasNext() {
                        return mCount < 10;
                    }

                    @Override
                    public Entry next() {
                        ++mCount;
                        String key = mSource.next();
                        return new Entry(key, mWordMap.get(key));
                    }
                }
        );
    }

    @Override
    public int compare(String key1, String key2) {
        int result = mWordMap.get(key1) - mWordMap.get(key2);
        if (result == 0) result = key1.compareTo(key2);
        return result;
    }

}
