package com.ericrgon;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

import java.util.List;
import java.util.Map;

/**
 * A convenience class for maintaining and incrementing {@link com.ericrgon.WordCount} objects.
 */
class WordCounter {

    private final Map<String,WordCount> wordMap = Maps.newHashMap();

    public WordCount addWord(String word){
        if(!wordMap.containsKey(word)){
            wordMap.put(word,new WordCount(word));
        }

        WordCount current = wordMap.get(word);
        current.increment();
        return current;
    }

    public WordCount getWordCount(String word){
        return wordMap.get(word);
    }

    public List<WordCount> getAllWords(){
        return Lists.newArrayList(wordMap.values());
    }
}
