package printer;

import entry.Entry;
import result.Result;

import java.io.*;

public class FilePrinter implements Printer {

    private final File mFile;

    public FilePrinter(String path) {
        mFile = new File(path);
    }

    @Override
    public void printResult(Result result) {
        Writer writer = null;
        try {
            writer = new BufferedWriter(new FileWriter(mFile));
            writer.write(String.valueOf(result.getUnclassifiedCharCount()));
            writer.write('\n');
            writer.write(String.valueOf(result.getUnclassifiedWordCount()));
            writer.write('\n');
            writer.write(String.valueOf(result.getNonBlankLineCount()));
            writer.write('\n');
            for (Entry entry : result.listMostFrequent()) {
                writer.write(entry.word);
                writer.write(": ");
                writer.write(String.valueOf(entry.count));
                writer.write('\n');
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (writer != null) try {
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
