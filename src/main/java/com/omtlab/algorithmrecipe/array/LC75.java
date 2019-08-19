package com.omtlab.algorithmrecipe.array;

public class LC75 {
    
    public void sortColor(int[] nums){
        int[] threeColorsCount = new int[3];
        for(int i=0 ; i <nums.length;i++){
            int color = nums[i];
            threeColorsCount[color]+=1;
        }
        
        int index = 0;
        for(int color = 0; color < 3; color++){
            int colorCount = threeColorsCount[color];
            for(int j=0; j<colorCount; j++){
                nums[index++]=color;
            }
        }
    }
    
}
