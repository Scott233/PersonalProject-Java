import lib.Counter;
import lib.Printer;
import lib.Result;

public class WordCount {

    public static void main(String[] args) {
        ensureArguments(args);
        begin(args[0], args[1]);
    }

    private static void ensureArguments(String[] args) {
        switch (args.length) {
            case 0:
                throw new IllegalArgumentException("No input file.");
            case 1:
                throw new IllegalArgumentException("No output file");
            default:
                break;
        }
    }

    private static void begin(String inputFilePath, String outputFilePath) {
        Counter counter = new Counter();
        Result result = counter.count(inputFilePath);
        Printer printer = new Printer();
        printer.print(result, outputFilePath);
    }

}
