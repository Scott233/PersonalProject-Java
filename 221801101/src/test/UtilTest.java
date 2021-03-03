package test;

import lib.Util;
import org.junit.jupiter.api.Test;

class UtilTest {
    @Test
    public void test() {
        assert !Util.isWord("\0");
        assert !Util.isWord("");
        assert !Util.isWord("\n");
        assert !Util.isWord("!");
        assert !Util.isWord("?");
        assert !Util.isWord("a");
        assert !Util.isWord("ab");
        assert !Util.isWord("abc");
        assert Util.isWord("abcd");
        assert Util.isWord("abcdefg");
        assert Util.isWord("abcdefg123");
        assert Util.isWord("abcdefg123456");
        assert Util.isWord("abcdefg123456789");
        assert Util.isWord("abcdefg123456789gfedcba");
    }
}