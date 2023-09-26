package org.example.LeetCode;

public class BuyAndSellStock {
    public static int maxProfit(int[] prices) {
        int maxProfit = 0;
        int whenBuyIndex = 0;

        for (int i = 0; i < prices.length; i++) {

            if (prices[whenBuyIndex] > prices[i]) {
                whenBuyIndex = i;
            }

            maxProfit = Math.max(maxProfit, prices[i] - prices[whenBuyIndex]);
        }

        return maxProfit;
    }

    public static void main(String[] args) {
        int[] prices = {7, 1, 5, 3, 6, 4};

        System.out.println(maxProfit(prices));
    }
}
