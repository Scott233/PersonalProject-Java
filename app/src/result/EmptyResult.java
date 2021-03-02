package result;

import entry.Entry;

import java.util.Iterator;

public class EmptyResult implements Result {

    private static EmptyResult sInstance = null;
    private static Iterator<Entry> sEmptyIterator = new Iterator<>() {
        @Override
        public boolean hasNext() {
            return false;
        }

        @Override
        public Entry next() {
            return null;
        }
    };

    private EmptyResult() {
    }

    @Override
    public int getUnclassifiedCharCount() {
        return 0;
    }

    @Override
    public int getUnclassifiedWordCount() {
        return 0;
    }

    @Override
    public int getNonBlankLineCount() {
        return 0;
    }

    @Override
    public Iterator<Entry> listMostFrequent() {
        return sEmptyIterator;
    }

    public static EmptyResult getInstance() {
        if (sInstance == null) sInstance = new EmptyResult();
        return sInstance;
    }
}
