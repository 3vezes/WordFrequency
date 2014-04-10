package com.ericrgon;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class WordFrequencyTest {

    private static final int LARGEST = 2;
    private ImmutableList<String> EXPECTED_WORDS = ImmutableList.of("Gonzalez", "Eric");

    private List<String> words;

    @Before
    public void setUp() throws Exception {
        words = Lists.newArrayList();

        for (int i = 0; i < 10; i++) {
            words.add("Eric");
        }

        for (int i = 0; i < 30; i++) {
            words.add(String.valueOf(i));
        }

        for (int i = 0; i < 50; i++) {
            words.add("Gonzalez");
        }
    }

    @Test
    public void testSimpleWordFrequency() throws Exception {
        Assert.assertEquals(EXPECTED_WORDS, SimpleWordFrequency.getHighestFrequency(words, LARGEST));
    }

    @Test
    public void testOptimizedWordFrequency() throws Exception {
        Assert.assertEquals(EXPECTED_WORDS, OptimizedWordFrequency.getHighestFrequency(words, LARGEST));
    }
}
