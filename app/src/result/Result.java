package result;

import entry.Entry;

import java.util.Iterator;

public interface Result {
    int getUnclassifiedCharCount();

    int getUnclassifiedWordCount();

    int getNonBlankLineCount();

    Iterable<Entry> listMostFrequent();
}
