package counter;

import repository.Repository;
import result.Result;

public abstract class Counter {
    private final Repository mRepository;

    public Counter(Repository repository) {
        mRepository = repository;
    }

    public Result count(String filePath) {
        return null;
    }

    protected abstract void onNextChar();

    protected abstract void onNextLine();

    protected abstract void onNextWord(String word);

    protected abstract Result onBuildResult();
}
