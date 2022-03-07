package com.omtlab.algorithmrecipe.design.using.placeholder;

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

public class LC2034 {

    int currentTimeStamp = Integer.MIN_VALUE;
    int currentValue = 0;
    int maxValue = Integer.MIN_VALUE; // So that we can compare first value as greater than
    int minValue = Integer.MAX_VALUE; // So that we can compare first value as less than.

    public void update(int timestamp, int price) {
        if (timestamp >= currentTimeStamp) {
            currentTimeStamp = timestamp;
            currentValue = price;
        }

        updateMinMaxValue(price);
    }

    public int current() {
        return currentValue;
    }

    public int maximum() {
        return maxValue;
    }

    public int minimum() {
        return minValue;
    }

    private void updateMinMaxValue(int newValue) {
        minValue = Math.min(minValue, newValue);
        maxValue = Math.max(maxValue, newValue);
    }
}
