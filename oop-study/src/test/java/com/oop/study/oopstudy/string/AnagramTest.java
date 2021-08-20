package com.oop.study.oopstudy.string;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Locale;

public class AnagramTest {
    @DisplayName("아나그램 작성해보기")
    @Test
    void test() {
        String str1 = "asd a a";
        String str2 = "aa ds a";

        boolean isSame = isSameString(str1, str2);
        assert (isSame);

        str1 = "a aa bbq";
        str2 = "qqbb aa a";
        isSame = isSameString(str1, str2);
        assert (!isSame);
    }

    public boolean isSameString(String str1, String str2) {
        str1 = str1.replaceAll("\\s", "");
        str2 = str2.replaceAll("\\s", "");

        if (str1.length() != str2.length()) return false;

        char[] chars1 = str1.toLowerCase(Locale.ROOT).toCharArray();
        char[] chars2 = str2.toLowerCase(Locale.ROOT).toCharArray();

        Arrays.sort(chars1);
        Arrays.sort(chars2);

        return new String(chars1).equals(new String(chars2));
    }
}
