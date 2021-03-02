package repository;

public class NormalRepository implements Repository {

    @Override
    public boolean isWord(CharSequence sequence) {
        for (int i = 0; i < 4; ++i)
            if (!Character.isLetter(sequence.charAt(i)))
                return false;
        return true;
    }

}
