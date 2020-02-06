package com.omtlab.algorithmrecipe.iterator.list;

import java.util.Iterator;
import java.util.List;

/**
 * 251. Flatten 2D Vector
 * 
 * Design and implement an iterator to flatten a 2d vector. It should support the following operations: next and 
 * hasNext.
 *
 *
 *
 * Example:
 *
 * Vector2D iterator = new Vector2D([[1,2],[3],[4]]);
 *
 * iterator.next(); // return 1
 * iterator.next(); // return 2
 * iterator.next(); // return 3
 * iterator.hasNext(); // return true
 * iterator.hasNext(); // return true
 * iterator.next(); // return 4
 * iterator.hasNext(); // return false
 *
 *
 * Notes:
 *
 * Please remember to RESET your class variables declared in Vector2D, as static/class variables are persisted across
 * multiple test cases. Please see here for more details.
 * You may assume that next() call will always be valid, that is, there will be at least a next element in the 2d 
 * vector when next() is called.
 */
public class LC251 {

    private List<List<Integer>> vector2D;
    private Iterator<List<Integer>> vector2DIterator;
    private Iterator<Integer> iterator;
    public LC251(List<List<Integer>> vector2D) {
        this.vector2D = vector2D;
        this.vector2DIterator = vector2D.iterator();
        this.iterator = vector2DIterator.next().iterator();
    }
    
    public int next() {
        hasNext(); // Added to avoid NoSuchElementException
        return iterator.next();
    }

    public boolean hasNext() {
        if(!iterator.hasNext() && vector2DIterator.hasNext()){
            iterator = vector2DIterator.next().iterator();
        }
        
        return iterator.hasNext();
    }
    
}
