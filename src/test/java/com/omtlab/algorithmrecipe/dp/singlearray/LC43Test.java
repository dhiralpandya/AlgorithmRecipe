package com.omtlab.algorithmrecipe.dp.singlearray;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigInteger;

import static org.junit.Assert.*;

public class LC43Test {
    private LC43 lc43 = new LC43();
    
    @Test
    public void multiplyStrings(){
        Assert.assertEquals(String.valueOf(124*124), lc43.multiplyStrings("124","124"));
        Assert.assertEquals(String.valueOf(124*1245), lc43.multiplyStrings("124","1245"));
        Assert.assertEquals(String.valueOf(0*1245), lc43.multiplyStrings("0","1245"));
        Assert.assertEquals(String.valueOf(new BigInteger("124535673463223").multiply(new BigInteger("1243562341532434"))), lc43.multiplyStrings("124535673463223","1243562341532434"));
        Assert.assertEquals(String.valueOf(new BigInteger("124356234153243412435623415324343245641243512435623415324341243562341532434324564124351243562341532434124356234153243432456412435")
                .multiply(new BigInteger("124356234153243412435623415324343245641243512435623415324341243562341532434324564124351243562341532434124356234153243432456412435"))), 
                lc43.multiplyStrings("124356234153243412435623415324343245641243512435623415324341243562341532434324564124351243562341532434124356234153243432456412435"
                        ,"124356234153243412435623415324343245641243512435623415324341243562341532434324564124351243562341532434124356234153243432456412435"));
    }

}