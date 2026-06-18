package com.dsal.recurssions;

import java.util.ArrayList;
import java.util.List;

public class MGetMaizePathWithJump {

    public static void main(String[] args){

        System.out.println(getMaizePathWithJump(1, 1, 3, 3));
        System.out.println(getMaizePathWithJump(1, 1, 4, 4));
        System.out.println(getMaizePathWithJump(1, 1, 3, 6));

//        System.out.println(getMaizePathWithJumpV2(0, 0, 2, 2));
//        System.out.println(getMaizePathWithJumpV2(0, 0, 3, 3));
//        System.out.println(getMaizePathWithJumpV2(0, 0, 2, 5));

    }

    private static List<String> getMaizePathWithJump(int sr, int sc, int dr, int dc) {

        if(sr == dr && sc == dc){
            List<String> paths = new ArrayList<>();
            paths.add("");
            return paths;
        }

        List<String> paths = new ArrayList<>();

        for (int moveSize = 1; moveSize <= dc - sc; moveSize++) {
            List<String> hPaths = getMaizePathWithJump(sr, sc + moveSize, dr, dc);
            for (String hPath : hPaths){
                paths.add("h" + moveSize + hPath);
            }
        }

        for (int moveSize = 1; moveSize <= dr - sr; moveSize++) {
            List<String> vPaths = getMaizePathWithJump(sr + moveSize, sc, dr, dc);
            for (String vPath : vPaths){
                paths.add("v" + moveSize + vPath);
            }
        }

        for (int moveSize = 1; moveSize <= dr - sr && moveSize <= dc - sc; moveSize++) {
            List<String> dPaths = getMaizePathWithJump(sr + moveSize, sc + moveSize, dr, dc);
            for (String dPath : dPaths){
                paths.add("d" + moveSize + dPath);
            }
        }

        return paths;
    }

    private static List<String> getMaizePathWithJumpV2(int sr, int sc, int dr, int dc) {

        if(sr == dr && sc == dc){
            List<String> paths = new ArrayList<>();
            paths.add("");
            return paths;
        }
        List<String> hPaths = new ArrayList<>();
        List<String> dPaths = new ArrayList<>();
        List<String> vPaths = new ArrayList<>();

        for (int i = 0; i < dc && sc < dc; i++) {
            hPaths = getMaizePathWithJumpV2(sr, sc + 1, dr, dc);
        }
        for (int i = 0; i < dr && i < dc && sc < dc && sr < dr; i++) {
            dPaths = getMaizePathWithJumpV2(sr + 1, sc + 1, dr, dc);
        }
        for (int i = 0; i < dr  && sr < dr; i++) {
            vPaths = getMaizePathWithJumpV2(sr + 1, sc, dr, dc);
        }

        List<String> allPaths = new ArrayList<>();

        for (String path : hPaths){
            allPaths.add("h" + path);
        }

        for (String path : dPaths){
            allPaths.add("d" + path);
        }

        for (String path : vPaths){
            allPaths.add("v" + path);
        }

        return allPaths;
    }

}
