package com.ericrgon;

import com.google.common.collect.Lists;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.util.List;

/**
 * Used to a get a rough estimate of total time required and compare that Optimized and
 * Simple versions return the same results.
 */
public class MobyDickWordFrequencyTest{

    private static final int N_LARGEST = 10;

    private List<String> words;

    @Before
    public void setUp() throws Exception {
        String wordsPath = getClass().getClassLoader().getResource("moby_dick.txt").getPath();
        words = Lists.newArrayList(DocumentParser.getWords(new File(wordsPath)));
    }

    @Test
    public void testSimpleWordFrequency(){
        SimpleWordFrequency.getHighestFrequency(words, N_LARGEST);
    }

    @Test
    public void testOptimizedWordFrequency() throws Exception {
        OptimizedWordFrequency.getHighestFrequency(words, N_LARGEST);
    }

    @Test
    public void testVerifyResults() throws Exception {
        Assert.assertEquals(OptimizedWordFrequency.getHighestFrequency(words, N_LARGEST), SimpleWordFrequency.getHighestFrequency(words, N_LARGEST));
    }
}
