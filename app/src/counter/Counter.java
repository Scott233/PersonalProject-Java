package counter;

import repository.Repository;
import result.EmptyResult;
import result.Result;

import java.io.*;

public abstract class Counter {
    private final Repository mRepository;

    private static final int sNewLine = (int) '\n';

    public Counter(Repository repository) {
        mRepository = repository;
    }

    public Result count(String filePath) {
        Reader reader = null;
        try {
            reader = new BufferedReader(new FileReader(new File(filePath)));
            final StringBuilder buffer = new StringBuilder(32);
            for (; ; ) {
                int it = reader.read();
                if (Character.isLetterOrDigit(it)) {
                    buffer.appendCodePoint(it);
                } else if (it > 0) {
                    if (mRepository.isWord(buffer)) onNextWord(buffer.toString());
                    if (it == sNewLine) onNextLine(buffer.length() > 0);
                    buffer.setLength(0);
                } else break;
                onNextChar();
            }
            return buildResult();
        } catch (IOException e) {
            e.printStackTrace();
            return EmptyResult.getInstance();
        } finally {
            if (reader != null) try {
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    protected abstract void onNextChar();

    protected abstract void onNextLine(boolean contentful);

    protected abstract void onNextWord(String word);

    protected abstract Result buildResult();
}
