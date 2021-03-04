import lib.Counter;
import lib.Printer;
import lib.Result;

public final class WordCount {

    public static void main(final String[] args) {
        ensureArguments(args);
        begin(args[0], args[1]);
    }

    private static void ensureArguments(final String[] args) {
        switch (args.length) {
            case 0:
                throw new IllegalArgumentException("No input file.");
            case 1:
                throw new IllegalArgumentException("No output file");
            default:
                break;
        }
    }

    private static void begin(final String inputFilePath, final String outputFilePath) {
        Counter counter = new Counter();
        Result result = counter.count(inputFilePath);
        Printer printer = new Printer();
        printer.print(result, outputFilePath);
    }

}
