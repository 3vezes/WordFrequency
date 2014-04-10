package com.ericrgon;

import com.google.common.base.Objects;

/**
 * Maintains a word and the number of occurrences for that word.
 */
public class WordCount implements Comparable<WordCount>{

    private int count;
    private final String word;

    public WordCount(String word) {
        this.word = word;
    }

    public int increment(){
        return count++;
    }

    public int getCount() {
        return count;
    }

    public String getWord() {
        return word;
    }

    @Override
    public int compareTo(WordCount o) {
        return Integer.compare(count,o.getCount());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(word);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        final WordCount other = (WordCount) obj;
        return Objects.equal(this.word, other.word);
    }

    @Override
    public String toString() {
        return Objects.toStringHelper(this.getClass())
                .add("Count",count)
                .add("Word",word)
                .toString();
    }
}
