package lib;

public final class Util {

    private Util() {
        throw new UnsupportedOperationException("不能生成该类实例");
    }

    public static boolean isWord(CharSequence seq) {
        if (seq == null) return false;
        if (seq.length() < 4) return false;
        for (int i = 0; i < 4; ++i)
            if (!Character.isLetter(seq.charAt(i)))
                return false;
        return true;
    }

}
