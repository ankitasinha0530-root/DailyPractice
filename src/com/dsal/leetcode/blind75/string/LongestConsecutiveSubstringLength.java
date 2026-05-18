package com.dsal.leetcode.blind75.string;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

//youtube.com/watch?v=U2ppEzBaMck&pp=ugUEEgJlbg%3D%3D -- Preferred

// https://www.youtube.com/watch?v=FCbOzdHKW18

public class LongestConsecutiveSubstringLength {

    public static void main(String[] args) {

        String str = "abcabcbb";

        System.out.println(longestConsecutiveSubstringLengthHashMap(str));
        System.out.println(longestConsecutiveSubstringLengthHashSet(str));

    }

    private static int longestConsecutiveSubstringLengthHashMap(String str) {

        int maxLength = 0;
        int length = 0;
        int wStart = 0;
        int wEnd = 0;

        Map<Character, Integer> exploredMap = new HashMap<>();

        for (wEnd = 0; wEnd < str.length(); wEnd++) {

            if(exploredMap.containsKey(str.charAt(wEnd)) && exploredMap.get(str.charAt(wEnd)) < wStart){
                wStart = exploredMap.get(str.charAt(wEnd)) + 1;
            }
            length = wEnd - wStart + 1;
            maxLength = Math.max(maxLength, length);
            exploredMap.put(str.charAt(wEnd), wEnd);
        }
        return maxLength;
    }

    private static int longestConsecutiveSubstringLengthHashSet(String str) {

        int windowStart = 0;
        int windowEnd = 0;
        int maxLength = 0;
        int length = 0;

        Set<Character> seen = new HashSet<>();

        for (windowEnd = 0; windowEnd < str.length(); windowEnd++) {

            while(seen.contains(str.charAt(windowEnd))){
                seen.remove(str.charAt(windowEnd));
                windowStart++;
            }
            seen.add(str.charAt(windowEnd));
            length = windowEnd - windowStart + 1;
            maxLength = Math.max(length, maxLength);
        }

        return maxLength;
    }

}
