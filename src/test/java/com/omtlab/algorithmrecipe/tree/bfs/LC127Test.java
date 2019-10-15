package com.omtlab.algorithmrecipe.tree.bfs;

import com.google.common.collect.Lists;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class LC127Test {

    LC127 lc127 = new LC127();
    @Test
    public void ladderLength() {
        Assert.assertEquals(5, lc127.ladderLength("hit","cog", Lists.newArrayList("hot","dot","dog","lot","log","cog")));
        Assert.assertEquals(0, lc127.ladderLength("hit","cog", Lists.newArrayList("hot","dot","dog","lot","log")));
    }
}