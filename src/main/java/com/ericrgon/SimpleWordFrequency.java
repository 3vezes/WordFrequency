package com.ericrgon;

import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.List;

/**
 * This solution sorts all the counted words in reverse order (descending) and return a number of k
 * specified element. The run time for this solution is O(n lg n).
 */
public class SimpleWordFrequency {

    private SimpleWordFrequency() {
        throw new AssertionError("This class should not be instantiated.");
    }

    public static List<String> getHighestFrequency(File file, int numberOfHighest) throws IOException {
        List<String> words = DocumentParser.getWords(file);
        return getHighestFrequency(words, numberOfHighest);
    }

    public static List<String> getHighestFrequency(List<String> words, int numberOfHighest) {
        WordCounter wordCounter = new WordCounter();
        for (String word : words) {
            wordCounter.addWord(word);
        }

        List<WordCount> allWords = wordCounter.getAllWords();

        //Sort largest to smallest
        Collections.sort(allWords, Collections.reverseOrder());

        return WordCountUtil.getWords(allWords.subList(0, numberOfHighest));
    }
}
