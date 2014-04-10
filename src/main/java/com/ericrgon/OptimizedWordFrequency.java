package com.ericrgon;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * Given the problems and it's restrictions I'm attempting to reduce the total number of items that require sorting. We
 * have to iterate through all {@code n} items to perform word counting but we only sort {@code k} objects at any moment.
 * Where {@code k} is the number of largest items to store. The backing data structure used by the {@link com.ericrgon.FixedSizeLargestItemQueue}
 * is a {@link java.util.PriorityQueue} which performs {@link java.util.PriorityQueue#peek()} in O(1) and {@link java.util.PriorityQueue#add(Object)},
 * {@link java.util.PriorityQueue#remove()} in O(log n). We should have a combined runtime of O(n + k lg k).
 */
public final class OptimizedWordFrequency {

    private OptimizedWordFrequency(){
        throw new AssertionError("This class should not be instantiated.");
    }

    public static List<String> getHighestFrequency(File file, int numberOfHighest) throws IOException {
        List<String> words = DocumentParser.getWords(file);
        return getHighestFrequency(words,numberOfHighest);
    }

    public static List<String> getHighestFrequency(List<String> words, int numberOfHighest){
        FixedSizeLargestItemQueue<WordCount> wordHeap = new FixedSizeLargestItemQueue<WordCount>(numberOfHighest);
        WordCounter wordCounter = new WordCounter();

        for(String word : words){
            wordHeap.add(wordCounter.addWord(word));
        }

        return WordCountUtil.getWords(wordHeap.getDescending());
    }
}
