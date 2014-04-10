package com.ericrgon;

import com.google.common.collect.Lists;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class FixedSizeLargestItemQueueTest {

    private static final int TARGET_SIZE = 5;
    private FixedSizeLargestItemQueue<Integer> fixedSizeMinHeapSet;

    @Before
    public void setUp() throws Exception {
        fixedSizeMinHeapSet = new FixedSizeLargestItemQueue<Integer>(TARGET_SIZE);

        for(int i = 0 ; i <= 60 ; i++){
            //Make sure the heap filters duplicates
            fixedSizeMinHeapSet.add(i);
            fixedSizeMinHeapSet.add(i);
            fixedSizeMinHeapSet.add(i);
        }
    }

    @Test
    public void testInsertion() throws Exception {
        Assert.assertEquals(TARGET_SIZE, fixedSizeMinHeapSet.size());
        Assert.assertEquals(Lists.newArrayList(60,59,58,57,56),fixedSizeMinHeapSet.getDescending());
    }
}
