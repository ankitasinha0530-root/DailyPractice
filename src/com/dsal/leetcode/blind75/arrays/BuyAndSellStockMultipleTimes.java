package com.dsal.leetcode.blind75.arrays;

public class BuyAndSellStockMultipleTimes {
/**
    Algorithm :
    1. Check if each elemnet is smaller than the right element if yes then buy and then sell
    2. the difference between them is the profit
    3. keep on adding the profit until reaches the end of the array
 */

    public static void main(String[] args) {

        int[] prices = {7,1,5,2,6,4};
        System.out.println("when prices " + maxProfitBuyAndSellStockMultiple(prices));

        int[] price = {7,1,5,3,6,4};
        System.out.println("when prices " + maxProfitBuyAndSellStockMultiple(price));

        int[] prices1 = {7,6,5,2,1,4};
        System.out.println("when prices1 " + maxProfitBuyAndSellStockMultiple(prices1));

        int[] prices2 = {1, 2, 3 ,4 ,5 };
        System.out.println("when prices2 " + maxProfitBuyAndSellStockMultiple(prices2));

    }

    private static int maxProfitBuyAndSellStockMultiple(int[] prices) {

        int profit = 0;

        for (int i = 1; i < prices.length; i++) {

            if(prices[i] > prices[i-1]){
                profit += prices[i] - prices[i-1];
            }
        }
        return profit;


    }

}
