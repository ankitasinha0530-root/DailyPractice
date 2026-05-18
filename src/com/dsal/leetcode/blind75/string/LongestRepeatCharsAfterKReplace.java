package com.dsal.leetcode.blind75.string;

// https://www.youtube.com/watch?v=ExY8svHF_Eo

public class LongestRepeatCharsAfterKReplace {

    public static void main(String[] args) {

        String str = "AABABBA";
        System.out.println(longestRepeatCharsAfterKReplace(str, 2));
    }

    private static int longestRepeatCharsAfterKReplace(String str, int k) {

        int wStart = 0;
        int wEnd = 0;
        int maxFreq = 0;
        int maxWindowLength = 0;
        int[] freqCount = new int[26];

        for (wEnd = 0; wEnd < str.length() ; wEnd++) {
// Update the frequency of Current Character
            freqCount[str.charAt(wEnd) - 'A']++;
            // Update the MAx Frequency
            maxFreq = Math.max(maxFreq, freqCount[str.charAt(wEnd) - 'A']);

            int windowLength = wEnd - wStart + 1; // calculate the windowlength;
/**
        if windowLength - maxFreq > k,then reduce/Shrink the window :
          Reduce the count of character at wStart and increment the wStart by 1 as we are shrinking the window*/
            if(windowLength - maxFreq > k){
                freqCount[str.charAt(wStart) - 'A']--;
                wStart++;
            }
            windowLength = wEnd - wStart + 1;
            maxWindowLength = Math.max(maxWindowLength, windowLength);
        }
        return maxWindowLength;
    }
}
