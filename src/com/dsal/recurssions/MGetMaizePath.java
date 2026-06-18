package com.dsal.recurssions;

import java.util.ArrayList;
import java.util.List;

public class MGetMaizePath {

    public static void main(String[] args){

        System.out.println(getMaizePath(0, 0, 2, 2));

        System.out.println(getMaizePath(0, 0, 3, 3));

        System.out.println(getMaizePath(0, 0, 2, 5));
    }

    private static List<String> getMaizePath(int sr, int sc, int dr, int dc) {

        if(sr == dr && sc == dc){
            List<String> path = new ArrayList<>();
            path.add("");
            return path;
        }

        List<String> hPaths = new ArrayList<>();
        List<String> vPaths = new ArrayList<>();

        if(sc < dc) {
            hPaths = getMaizePath(sr, sc + 1, dr, dc);
        }
        if(sr < dr) {
            vPaths = getMaizePath(sr + 1, sc, dr, dc);
        }

        List<String> allPaths = new ArrayList<>();

        for (String hPath : hPaths){
            allPaths.add("h" + hPath);
        }

        for (String vPath : vPaths){
            allPaths.add("v" + vPath);
        }
        return allPaths;
    }
}
