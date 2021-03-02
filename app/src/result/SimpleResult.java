package result;

import entry.Entry;

import java.util.Iterator;

public class SimpleResult implements Result {

    private final int mCharCount;
    private final int mWordCount;
    private final int mLineCount;
    private final Iterable<Entry> mEntryIterator;

    public SimpleResult(int charCount, int wordCount, int lineCount, Iterable<Entry> entryIterator) {
        mCharCount = charCount;
        mWordCount = wordCount;
        mLineCount = lineCount;
        mEntryIterator = entryIterator;
    }

    @Override
    public int getUnclassifiedCharCount() {
        return mCharCount;
    }

    @Override
    public int getUnclassifiedWordCount() {
        return mWordCount;
    }

    @Override
    public int getNonBlankLineCount() {
        return mLineCount;
    }

    @Override
    public Iterable<Entry> listMostFrequent() {
        return mEntryIterator;
    }

}
