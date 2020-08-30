package com.omtlab.algorithmrecipe.greedy;

import com.google.common.collect.Lists;
import com.omtlab.algorithmrecipe.greedy.LC253.MeetingInterval;
import org.junit.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LC253Test {
    LC253 lc253 = new LC253();

    @Test
    public void minRooms() {
        List<MeetingInterval> input1 = Lists.newArrayList(
                new MeetingInterval(0, 30),
                new MeetingInterval(5, 10),
                new MeetingInterval(15, 20)
        );
        int output1 = lc253.minRooms(input1);
        assertEquals(2, output1);

        List<MeetingInterval> input2 = Lists.newArrayList(
                new MeetingInterval(7, 30),
                new MeetingInterval(2, 4)
        );
        int output2 = lc253.minRooms(input2);
        assertEquals(1, output2);
    }
}