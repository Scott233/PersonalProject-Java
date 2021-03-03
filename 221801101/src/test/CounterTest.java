package test;

import lib.Counter;
import lib.Printer;
import lib.Result;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

class CounterTest {

    private static final String DIR = "samples/";
    private static final String INPUT = "-in.txt";
    private static final String OUTPUT = "-out.txt";

    private final Counter mCounter = new Counter();
    private final Printer mPrinter = new Printer();

    private boolean testImpl(final String name) {
        final Result result = mCounter.count(DIR + name + INPUT);
        mPrinter.print(result, "output");
        try (final Reader standard = new BufferedReader(new FileReader(DIR + name + OUTPUT)); final Reader actual = new BufferedReader(new FileReader("output"))) {
            for (; ; ) {
                final int ch = standard.read();
                final int it = actual.read();
                if (it != ch)
                    return false;
                else if (ch == -1)
                    return true;
            }
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Test
    public void testCountEmptyFile() {
        assert testImpl("empty");
    }

    @Test
    public void testCountBlankFile() {
        assert testImpl("blank");
    }

    @Test
    public void testSingleLetterFile() {
        assert testImpl("single letter");
    }

    @Test
    public void testSingleWordFile() {
        assert testImpl("single word");
    }

    @Test
    public void testPureNumberFile() {
        assert testImpl("pure number");
    }

    @Test
    public void testPureUppercaseFile() {
        assert testImpl("pure uppercase");
    }

    @Test
    public void testJsonFile() {
        assert testImpl("json");
    }

}