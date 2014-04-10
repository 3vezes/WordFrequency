package com.ericrgon;

import com.google.common.collect.ForwardingQueue;
import com.google.common.collect.Lists;

import java.util.*;

/**
 * Maintains a list of the {@code x} largest items
 * in the queue. Items smaller than the current smallest item
 * are ignored.
 *
 * <p>
 *     This class relies on comparable to determine sort order but Object.equals to
 *     determine equality.
 * </p>
 *
 * @param <T> Type to queue.
 */
public class FixedSizeLargestItemQueue<T extends Comparable<T>> extends ForwardingQueue<T> {

    private final int maxSize;
    private final PriorityQueue<T> priorityQueue = new PriorityQueue<T>();

    public FixedSizeLargestItemQueue(int maxSize) {
        this.maxSize = maxSize;
    }

    @Override
    public boolean add(T element) {
        T smallestElement = priorityQueue.peek();

        //Smaller than our smallest item. Do not add.
        if(smallestElement != null && (size() == maxSize) && element.compareTo(smallestElement) < 0){
            return false;
        }

        //Delete the previous entry to accommodate the new element.
        priorityQueue.remove(element);
        priorityQueue.add(element);

        /**
         * This new element didn't exist in the
         * queue. Time to kick out the little guy.
         */
        if(priorityQueue.size() > maxSize){
            priorityQueue.poll();
        }

        return true;
    }

    public List<T> getDescending(){
        List<T> results = Lists.newArrayList(priorityQueue);
        //Descending, highest to lowest
        Collections.sort(results,Collections.reverseOrder());
        return results;
    }
    
    @Override
    protected Queue<T> delegate() {
        return priorityQueue;
    }
}
