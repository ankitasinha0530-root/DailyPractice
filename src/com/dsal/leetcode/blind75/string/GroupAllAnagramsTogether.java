package com.dsal.leetcode.blind75.string;

import java.util.*;

public class GroupAllAnagramsTogether {

    public static void main(String[] args) {

        String[] stringArr = {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(groupAnagrams(stringArr));
        System.out.println(groupAnagrams2(stringArr));
    }

    private static List<List<String>> groupAnagrams(String[] stringArr) {

        Map<String, List<String>> resultMap = new HashMap<>();

        for (String str : stringArr){

            // Count Frequency
            int[] freqMap = new int[256];

            for(char ch : str.toCharArray()){
                freqMap[ch]++;
            }

            //create UniqueKey
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < freqMap.length; i++) {
                if (freqMap[i] != 0){
                    sb.append((char) i);
                    sb.append(freqMap[i]);
                }
            }
//            char ch = 'a';
//            for (int val : freqMap) {
//                if(val != 0){
//                    sb.append(ch);
//                    sb.append(val);
//                }
//                ch++;
//            }
            String key = sb.toString();
            // if key is present it will append int the value list,
            // if key is absent, it will create a new string and add to the list
            resultMap.computeIfAbsent(key, k -> new ArrayList<>()).add(str);
        }
        return new ArrayList<>(resultMap.values());
    }

    private static List<List<String>> groupAnagrams2(String[] stringArr) {

        Map<String, List<String>> resultMap = new HashMap<>();

        for(String str : stringArr){

            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);

            if(!resultMap.containsKey(key)){
                resultMap.put(key, new ArrayList<>());
            }
            resultMap.get(key).add(str);
        }
        return new ArrayList<>(resultMap.values());
    }
}
