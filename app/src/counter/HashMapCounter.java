package counter;

import repository.Repository;
import result.Result;
import result.SimpleResult;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class HashMapCounter extends Counter {

    private int mCharCount = 0;
    private int mLineCount = 0;
    private Map<String, Integer> mWordMap = new HashMap<>();

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
        Set<String> wordSet = mWordMap.keySet();
        return new SimpleResult(
                mCharCount,
                mWordMap.size(),
                mLineCount,
                null
        );
    }
}
