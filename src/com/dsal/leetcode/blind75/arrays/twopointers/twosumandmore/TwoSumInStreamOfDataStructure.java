package com.dsal.leetcode.blind75.arrays.twopointers.twosumandmore;

import java.util.HashMap;
import java.util.Map;

/**
Operations two methods required
    add(number) method 1 to add the data
    find(target) method 2 find the data

Real Interview Question
Used in:
    live event processing
    trading systems
    analytics systems*/

public class TwoSumInStreamOfDataStructure {

    private final Map<Integer, Integer> mapFreq = new HashMap<>();

    public void add(int value){

        mapFreq.put(value, mapFreq.getOrDefault(value, 0) + 1);
    }

    public boolean findSum(int target){

        for(int num : mapFreq.keySet()){
            int complement = target - num;
            if(complement == num){
                if(mapFreq.get(num) > 1){
                    return true;
                }
            }
            if(mapFreq.containsKey(complement)){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {

        TwoSumInStreamOfDataStructure ds = new TwoSumInStreamOfDataStructure();

        ds.add(1);
        ds.add(3);
        ds.add(5);

        System.out.println(ds.findSum(4));
        System.out.println(ds.findSum(7));


    }


}


