package com.pepaa.backtracking;

import java.util.ArrayList;
import java.util.List;

public class PEP001_PrintAbbreviation {
    public static void main(String[] args) {
        String word = "pepcodingsuraj";
        List<String> abbrevWords = new ArrayList();
        findAbbreviation(word, 0, word.length(),0, "", abbrevWords);
        abbrevWords.forEach(System.out::println);
    }

    private static void findAbbreviation(String word, int i, int length, int count, String current, List<String> abbrevWords) {
        if (i == length) {
            abbrevWords.add(count>0?current+count:current);
            return;
        }

        findAbbreviation(word, i+1, length, 0, current + (count>0?count : "")+ word.charAt(i),  abbrevWords);
        findAbbreviation(word, i+1, length, count +1, current,  abbrevWords);
    }

}
