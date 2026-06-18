package com.dsal.recurssions;

import java.util.ArrayList;
import java.util.List;

public class LGetStairsPath {

    public static void main(String[] args){
        System.out.println(getStairPaths(5));
    }

    private static List<String> getStairPaths(int n) {

        if(n == 0){
            List<String> result = new ArrayList<>();
            result.add("");
            return result;
        }
        if(n < 0){
            return new ArrayList<>();
        }

        List<String> path1 = getStairPaths(n-1);
        List<String> path2 = getStairPaths(n-2);
        List<String> path3 = getStairPaths(n-3);

        List<String> allPaths = new ArrayList<>();

        for (String path : path1){
            allPaths.add(1 + path);
        }
        for (String path : path2){
            allPaths.add(2 + path);
        }
        for (String path : path3){
            allPaths.add(3 + path);
        }
        return allPaths;
    }
}
