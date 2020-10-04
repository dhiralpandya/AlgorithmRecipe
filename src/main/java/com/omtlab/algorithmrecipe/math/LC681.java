package com.omtlab.algorithmrecipe.math;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 681. Next Closest Time
 *
 * Given a time represented in the format "HH:MM", form the next closest time by reusing the current digits.
 * There is no limit on how many times a digit can be reused.
 *
 * You may assume the given input string is always valid. For example, "01:34", "12:09" are all valid. "1:34", "12:9" are all invalid.
 *
 * Example 1:
 *
 * Input: "19:34"
 * Output: "19:39"
 * Explanation: The next closest time choosing from digits 1, 9, 3, 4, is 19:39, which occurs 5 minutes later.
 * It is not 19:33, because this occurs 23 hours and 59 minutes later.
 * Example 2:
 *
 * Input: "23:59"
 * Output: "22:22"
 * Explanation: The next closest time choosing from digits 2, 3, 5, 9, is 22:22.
 * It may be assumed that the returned time is next day's time since it is smaller than the input time numerically.
 */
public class LC681 {
    public String nextClosestTime(String time) {
        int HH = Integer.valueOf(time.substring(0,2));
        int MM = Integer.valueOf(time.substring(3));

        Set<Character> allAvailableChars = new HashSet<>();
        for(Character c: time.toCharArray()) {
            allAvailableChars.add(c);
        }

        int minutes = (HH*60) + MM;
        String nextTime = "";

        while (!isValidNextTime(allAvailableChars,nextTime)) {
            minutes =  minutes + 1;
            nextTime = convertMinToHHMMTime(minutes);
        }

        return nextTime;
    }

    public boolean isValidNextTime(Set<Character> allAvailableChars, String nextTime) {
        if(StringUtils.isEmpty(nextTime)) {
            return false;
        }

        for(Character c: nextTime.toCharArray()) {
            if(!allAvailableChars.contains(c)) {
                return false;
            }
        }

        return true;
    }

    /*
    This is the main stuff in this entire algorithm
       How to convert min to HH:MM ?
        1. Get HH
          minutes/60
          Lets say we have min = 192
          Hr : 192/60 = 3.2 = ~3
          Lets say we have min = 1924
          Hr: 1924/60 = 32.0666666 = ~32 which is > 24
          So in such cases we do %24 to avoid going above 24
          so final equation is
          ---------------------------------------------------
          (minutes/60)%24 = (1924/60) % 24 = 8.066666 = ~8 hr
          ---------------------------------------------------

         2. Get MM
          For that we will use same HH equation but we will consider only decimal numbers (Number after point)
          Example: Lets say min = 1924
           Hr: 1924/60 = 32.0666666
           Now we will consider only 0.066666
           MM: 0.066666 * 60 = 3.9 = ~3
          Final equation is
          ---------------------------------------------------
          double Hr = (minutes/60)%24
          double MM = [Hr - (long) Hr] * 60
          ---------------------------------------------------

          How to Get Full HH:MM:SS ?

          For example, convert 192.25 minutes to hours, minutes, and seconds.

                Start by finding the number of hours.

                192.25 minutes = 192.25 minutes ÷ 60
                192.25 minutes = 3.204167 hours
                full hours = 3

          Find the remaining minutes

                minutes = .204167 hours × 60 minutes
                minutes = 12.25 minutes
                full minutes = 12

          Find the remaining seconds

                seconds = .25 minutes × 60 seconds
                seconds = 15 seconds

          Finish up by rewriting as HH:MM:SS

                time = 3:12:15
     */
    private String convertMinToHHMMTime(int minutes) {
        int HH = (minutes / 60) % 24;
        double hhInDouble = ((double) minutes / 60);
        // The java.lang.Math.round()  which returns the closest long to the argument
        double onlyDecimalFromHr = hhInDouble - Math.round(hhInDouble*1000)/1000;
        int MM = (int) Math.round((onlyDecimalFromHr * 60)*1000)/1000;

        String HHInString = HH < 10 ? "0"+HH : String.valueOf(HH);
        String MMInString = MM < 10 ? "0"+MM : String.valueOf(MM);

        return String.format("%s:%s", HHInString, MMInString);
    }
}
