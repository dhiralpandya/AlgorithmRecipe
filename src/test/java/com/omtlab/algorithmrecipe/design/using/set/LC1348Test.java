package com.omtlab.algorithmrecipe.design.using.set;

import com.google.common.collect.Lists;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LC1348Test {

    @Test
    void tweetExample() {
        LC1348 lc1348 = new LC1348();
        lc1348.recordTweet("tweetOne", 0);
        lc1348.recordTweet("tweetOne", 30);
        lc1348.recordTweet("tweetOne", 10);
        lc1348.recordTweet("tweetOne", 60);
        lc1348.recordTweet("tweetOne", 120);

        assertThat(
                lc1348.getTweetCountsPerFrequency("minute",
                        "tweetNotAvailable",
                        0,
                        99))
                .isEqualTo(Lists.newArrayList(0, 0));

        assertThat(
                lc1348.getTweetCountsPerFrequency("minute",
                        "tweetOne",
                        0,
                        59))
                .isEqualTo(Lists.newArrayList(3));
        assertThat(
                lc1348.getTweetCountsPerFrequency("day",
                        "tweetOne",
                        0,
                        121))
                .isEqualTo(Lists.newArrayList(5));

        assertThat(
                lc1348.getTweetCountsPerFrequency("minute",
                        "tweetOne",
                        0,
                        121))
                .isEqualTo(Lists.newArrayList(3, 1, 1));
    }

}