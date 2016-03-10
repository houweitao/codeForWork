package hou.leetcode.medium;

/**
 * @author houweitao
 * @date 2015年11月16日 上午11:25:04
 * @end 2015年11月16日11:55:06
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
 */

public class BestTimeToBuyAndSellStock {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] prices = { 3, 1, 2, 13, 3, 16 };
		BestTimeToBuyAndSellStock sell = new BestTimeToBuyAndSellStock();
		System.out.println(sell.maxProfit(prices));
	}

	public int maxProfit(int[] prices) {
		if (prices.length == 0)
			return 0;
		else if(prices.length==1)
			return Math.max(prices[0]*-1, 0);
		int min = 0;
		int maxEndHere = 0;
		min = prices[0];
		for (int i = 1; i < prices.length; i++) {
			maxEndHere = Math.max(maxEndHere, prices[i] - min);
			if (prices[i] < min)
				min = prices[i];

//			System.out.println(min + "," + maxEndHere);
		}

		return maxEndHere;
	}
}
