package demo;

public class Array108 {
    public static void main(String[] args) {
        int[] prices = {1,2};
        int i = maxProfit(prices);
        System.out.println(i);
    }
    public static int maxProfit(int[] prices) {
        int maxProfit = 0;
        int minPrice = Integer.MAX_VALUE;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minPrice) {
                minPrice = prices[i];
            } else {
                maxProfit = Math.max(maxProfit, prices[i] - minPrice);
            }

        }
        return maxProfit;
    }
}
