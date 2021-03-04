package test;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Stream;

public class IterTest {
    private static final Map<String, Integer> sMap = new HashMap<>();

    {
        for (int i = 1; i < 10000000; ++i)
            sMap.put("word" + i, i);
    }

    @Test
    public void testStream() {
        Stream<Map.Entry<String, Integer>> stream = sMap.entrySet().stream().sorted(IterTest::compare);
        Iterable<Map.Entry<String, Integer>> iterable = stream::iterator;
    }

    @Test
    public void testList() {
        List<Map.Entry<String, Integer>> list = new ArrayList<>(sMap.entrySet());
        list.sort(IterTest::compare);
    }

    private static int compare(Map.Entry<String, Integer> e1, Map.Entry<String, Integer> e2) {
        int retVal = e2.getValue() - e1.getValue();
        if (retVal == 0) retVal = e1.getKey().compareTo(e2.getKey());
        return retVal;
    }
}
