package com.omtlab.algorithmrecipe.design.using.set;

import java.util.*;

/**
 * 1348. Tweet Counts Per Frequency
 * <p>
 * Implement the class TweetCounts that supports two methods:
 * <p>
 * 1. recordTweet(string tweetName, int time)
 * <p>
 * Stores the tweetName at the recorded time (in seconds).
 * 2. getTweetCountsPerFrequency(string freq, string tweetName, int startTime, int endTime)
 * <p>
 * Returns the total number of occurrences for the given
 * tweetName per minute, hour, or day (depending on freq)
 * starting from the startTime (in seconds) and ending at the endTime (in seconds).
 * <p>
 * freq is always minute, hour or day,
 * representing the time interval to get the
 * total number of occurrences for the given tweetName.
 * <p>
 * The first time interval always starts from the startTime,
 * so the time intervals are [startTime, startTime + delta*1>,  [startTime + delta*1, startTime + delta*2>, [startTime + delta*2, startTime + delta*3>, ... , [startTime + delta*i, min(startTime + delta*(i+1), endTime + 1)>
 * for some non-negative number i and delta (which depends on freq).
 * <p>
 * <p>
 * Example:
 * <p>
 * Input
 * ["TweetCounts","recordTweet","recordTweet","recordTweet","getTweetCountsPerFrequency","getTweetCountsPerFrequency","recordTweet","getTweetCountsPerFrequency"]
 * [[],["tweet3",0],["tweet3",60],["tweet3",10],["minute","tweet3",0,59],["minute","tweet3",0,60],["tweet3",120],["hour","tweet3",0,210]]
 * <p>
 * Output
 * [null,null,null,null,[2],[2,1],null,[4]]
 * <p>
 * Explanation
 * TweetCounts tweetCounts = new TweetCounts();
 * tweetCounts.recordTweet("tweet3", 0);
 * tweetCounts.recordTweet("tweet3", 60);
 * tweetCounts.recordTweet("tweet3", 10);                             // All tweets correspond to "tweet3" with recorded times at 0, 10 and 60.
 * tweetCounts.getTweetCountsPerFrequency("minute", "tweet3", 0, 59); // return [2]. The frequency is per minute (60 seconds), so there is one interval of time: 1) [0, 60> - > 2 tweets.
 * tweetCounts.getTweetCountsPerFrequency("minute", "tweet3", 0, 60); // return [2, 1]. The frequency is per minute (60 seconds), so there are two intervals of time: 1) [0, 60> - > 2 tweets, and 2) [60,61> - > 1 tweet.
 * tweetCounts.recordTweet("tweet3", 120);                            // All tweets correspond to "tweet3" with recorded times at 0, 10, 60 and 120.
 * tweetCounts.getTweetCountsPerFrequency("hour", "tweet3", 0, 210);  // return [4]. The frequency is per hour (3600 seconds), so there is one interval of time: 1) [0, 211> - > 4 tweets.
 * <p>
 * <p>
 * Constraints:
 * <p>
 * There will be at most 10000 operations considering both recordTweet and getTweetCountsPerFrequency.
 * 0 <= time, startTime, endTime <= 10^9
 * 0 <= endTime - startTime <= 10^4
 */
public class LC1348 {
    private static final Map<String, Integer> FREQUENCY_TO_SECOND = new HashMap<String, Integer>() {
        {
            put("minute", 60);
            put("hour", 60 * 60);
            put("day", 60 * 60 * 24);
        }
    };
    private Map<String, TreeSet<Integer>> tweetsWithTime = new HashMap<>();

    public void recordTweet(String tweetName, int timeInSeconds) {
        TreeSet<Integer> times = tweetsWithTime.getOrDefault(tweetName, new TreeSet<>());
        times.add(timeInSeconds);
        tweetsWithTime.put(tweetName, times);
    }

    public List<Integer> getTweetCountsPerFrequency(String freq, String tweetName, int startTimeInSeconds, int endTimeInSeconds) {
        int freqToSeconds = FREQUENCY_TO_SECOND.get(freq);
        List<Integer> output = new ArrayList<>();

        for (int i = startTimeInSeconds; i <= endTimeInSeconds; i += freqToSeconds) {
            if (tweetsWithTime.containsKey(tweetName)) {
                TreeSet<Integer> times = tweetsWithTime.get(tweetName);
                int tweetCount = times.subSet(i, Math.min(endTimeInSeconds + 1, i + freqToSeconds)).size();
                output.add(tweetCount);
            } else {
                output.add(0);
            }
        }

        return output;
    }
}
