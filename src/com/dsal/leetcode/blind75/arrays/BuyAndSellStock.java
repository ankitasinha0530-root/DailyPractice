package com.dsal.leetcode.blind75.arrays;

public class BuyAndSellStock {

    public static void main(String[] args) {

        int[] prices = {7,1,5,2,6,4};
        System.out.println("when prices " + maxProfitBuyAndSellStock(prices));
        System.out.println("when prices maxProfitBuyAndSellStock = " + maxProfitBuyAndSellStock2(prices));

        int[] prices1 = {7,6,5,2,1,4};
        System.out.println("when prices1 " + maxProfitBuyAndSellStock(prices1));
        System.out.println("when prices1 maxProfitBuyAndSellStock = " + maxProfitBuyAndSellStock2(prices1));

    }

    private static int maxProfitBuyAndSellStock(int[] prices) {

        int maxProfit = Integer.MIN_VALUE;
        int minSoFar = prices[0];

        for (int price : prices) {
            minSoFar = Math.min(minSoFar, price); //
            int profit = price - minSoFar;
            maxProfit = Math.max(maxProfit, profit);
        }

        return maxProfit;

    }

    private static int maxProfitBuyAndSellStock2(int[] prices) {

        int maxProfit = Integer.MIN_VALUE;

        int left = 0;
        int right = 1;

        while (right < prices.length){

            if(prices[left] < prices[right]){
                int profit = prices[right] - prices[left];
                maxProfit = Math.max(maxProfit, profit);
            }else {
                left ++; // increase left only when value of left is greater than value of right
            }
            right++;
        }
        return maxProfit;

    }
}
