package com.omtlab.algorithmrecipe.design.using.map;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeMap;

/**
 * 2034. Stock Price Fluctuation
 * <p>
 * You are given a stream of records about a particular stock. Each record contains a timestamp and the corresponding price of the stock at that timestamp.
 * <p>
 * Unfortunately due to the volatile nature of the stock market, the records do not come in order. Even worse, some records may be incorrect. Another record with the same timestamp may appear later in the stream correcting the price of the previous wrong record.
 * <p>
 * Design an algorithm that:
 * <p>
 * Updates the price of the stock at a particular timestamp, correcting the price from any previous records at the timestamp.
 * Finds the latest price of the stock based on the current records. The latest price is the price at the latest timestamp recorded.
 * Finds the maximum price the stock has been based on the current records.
 * Finds the minimum price the stock has been based on the current records.
 * Implement the StockPrice class:
 * <p>
 * StockPrice() Initializes the object with no price records.
 * void update(int timestamp, int price) Updates the price of the stock at the given timestamp.
 * int current() Returns the latest price of the stock.
 * int maximum() Returns the maximum price of the stock.
 * int minimum() Returns the minimum price of the stock.
 */


/**
 * NOT GOOD SOLUTION, Please check in PlaceHolder/LC2034
 */
public class LC2034 {
    TreeMap<Integer, Integer> record = new TreeMap<>();
    TreeMap<Integer, Set<Integer>> vals = new TreeMap<>();

    /**
     * NOT GOOD SOLUTION, Please check in PlaceHolder/LC2034
     */
    public void update(int timestamp, int price) {
        if (record.containsKey(timestamp)) {
            int prevPrice = record.get(timestamp);
            Set<Integer> book = vals.get(prevPrice);
            book.remove(timestamp);
            if (book.isEmpty()) {
                vals.remove(prevPrice);
            }
        }
        vals.putIfAbsent(price, new HashSet<>());
        vals.get(price).add(timestamp);
        record.put(timestamp, price);
    }

    /**
     * NOT GOOD SOLUTION, Please check in PlaceHolder/LC2034
     */
    public int current() {
        return record.lastEntry().getValue();
    }

    /**
     * NOT GOOD SOLUTION, Please check in PlaceHolder/LC2034
     */
    public int maximum() {
        return vals.lastKey();
    }

    public int minimum() {
        return vals.firstKey();
    }
}
