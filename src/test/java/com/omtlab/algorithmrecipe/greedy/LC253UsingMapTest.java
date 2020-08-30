package com.omtlab.algorithmrecipe.greedy;

import com.google.common.collect.Lists;
import com.omtlab.algorithmrecipe.greedy.LC253UsingMap.Meeting;
import org.junit.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LC253UsingMapTest {

    private LC253UsingMap lc253UsingMap = new LC253UsingMap();


    @Test
    public void minRooms() {
        List<Meeting> input1 = Lists.newArrayList(
                new Meeting(0, 30),
                new Meeting(5, 10),
                new Meeting(15, 20)
        );
        int output1 = lc253UsingMap.minRooms(input1);
        assertEquals(2, output1);

        List<Meeting> input2 = Lists.newArrayList(
                new Meeting(7, 30),
                new Meeting(2, 4)
        );
        int output2 = lc253UsingMap.minRooms(input2);
        assertEquals(1, output2);
    }
}