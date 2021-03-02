package result;

import entry.Entry;

import java.util.Iterator;

public class EmptyResult implements Result {

    private static EmptyResult sInstance = null;
    private static Iterable<Entry> sList = null;

    private final Iterable<Entry> mList;

    private EmptyResult() {
        if (sList == null) sList = new Iterable<>() {
            private final Iterator<Entry> sIt = new Iterator<>() {
                @Override
                public boolean hasNext() {
                    return false;
                }

                @Override
                public Entry next() {
                    return null;
                }
            };

            @Override
            public Iterator<Entry> iterator() {
                return sIt;
            }
        };
        mList = sList;
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
    public Iterable<Entry> listMostFrequent() {
        return mList;
    }

    public static EmptyResult getInstance() {
        if (sInstance == null) sInstance = new EmptyResult();
        return sInstance;
    }
}
