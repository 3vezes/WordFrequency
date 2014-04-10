package com.ericrgon;


import com.google.common.collect.Lists;

import java.util.List;

public class WordCountUtil {

    /**
     * Converts word objects into a list of strings.
     * @param wordCounts
     * @return
     */
    public static List<String> getWords(List<WordCount> wordCounts) {
        List<String> stringWords = Lists.newArrayList();
        for (WordCount wordCount : wordCounts) {
            stringWords.add(wordCount.getWord());
        }

        return stringWords;
    }
}
