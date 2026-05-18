package com.dsal.leetcode.blind75.string;

public class MinmLengthSubStringForATargetStr {

    public static void main(String[] args) {

        String str = "ADOBECODEBANC", target = "ABC";
        System.out.println(minmLengthSubStringForATargetStr(str, target));
    }

    private static String minmLengthSubStringForATargetStr(String str, String target) {

        int wEnd = 0;
        int wStart = 0;
        int minStart = 0;
        int minWindowLength = Integer.MAX_VALUE;
        int[] freqCountS = new int[256];
        int[] freqCountT = new int[256];

        for (int i = 0; i < target.length(); i++) {
            freqCountT[target.charAt(i)]++;
        }

//        for (char ch : target.toCharArray()) {
//            freqCountT[ch]++;
//        }
        for (wEnd = 0; wEnd < str.length(); wEnd++) {
            freqCountS[str.charAt(wEnd)]++;
            while (ifContains(freqCountS, freqCountT)) {
                if (wEnd - wStart + 1 < minWindowLength) {
                    minWindowLength = wEnd - wStart + 1;
                    minStart = wStart;
                }
                freqCountS[str.charAt(wStart)]--;
                wStart++;
            }
        }
        return minWindowLength == Integer.MAX_VALUE ? "" : str.substring(minStart, minWindowLength + minStart);
    }

    private static boolean ifContains(int[] freqCountS, int[] freqCountT) {
        for (int i = 0; i < 256; i++) {
            if (freqCountT[i] > freqCountS[i]) {
                return false;
            }
        }
        return true;
    }
}

