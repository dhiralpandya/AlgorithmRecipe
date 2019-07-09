package AlgorithmRecipe.backtracking;

import com.google.common.collect.Lists;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class LC17Test {

    private LC17 lc17 = new LC17();
    
    
    @Test
    public void findAllPossibleCombination() {
        String input = "23";
        String[] expectedOutput = {"ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"};
        List<String> output = Lists.newArrayList();
        lc17.findAllPossibleCombination(input,"", output);
        Assert.assertEquals(expectedOutput.length,output.size());
        for(String expected:expectedOutput){
            Assert.assertTrue(output.contains(expected));
        }
    }


    @Test
    public void findAllPossibleCombination2() {
        String input = "21";
        String[] expectedOutput = {"a","b","c"};
        List<String> output = Lists.newArrayList();
        lc17.findAllPossibleCombination(input,"", output);
        Assert.assertEquals(expectedOutput.length,output.size());
        for(String expected:expectedOutput){
            Assert.assertTrue(output.contains(expected));
        }
    }
}