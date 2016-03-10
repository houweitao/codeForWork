package hou.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * @author houweitao
 * @date 2015年12月29日 上午12:59:40
 * @TimeLimitExceeded 2015年12月29日01:54:16
 * https://leetcode.com/problems/coin-change/
 */

public class CoinChange {

	int minSize = Integer.MAX_VALUE;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] coins = { 186, 419, 83, 408 };
//		int[] coins = { 83, 186, 408, 419 };
		Arrays.sort(coins);
		CoinChange cc = new CoinChange();
		cc.printList(cc.help(coins, 6249, coins.length - 1));
//		System.out.println(cc.coinChange(coins, 6249));

		System.out.println(cc.coinChangeDP(coins, 6249));
	}

	//much better
	//https://leetcode.com/discuss/76194/c-o-n-amount-time-o-amount-space-dp-solution
	//https://leetcode.com/discuss/76204/simple-java-solution-o-amount-space-amount-time-complexity
	public int coinChangeDP(int[] coins, int amount) {
		int[] record = new int[amount + 1];
		for (int i = 0; i <= amount; i++)
			record[i] = Integer.MAX_VALUE;
		record[0] = 0;

		for (int i = 1; i <= amount; i++) {
			for (int j = 0; j < coins.length; j++) {
				if (i - coins[j] >= 0 && record[i - coins[j]] != Integer.MAX_VALUE) {
					record[i] = Math.min(record[i], record[i - coins[j]] + 1);
				}
			}
			//System.out.println(i + ":  " + record[i]);
		}
		return record[amount] == Integer.MAX_VALUE ? -1 : record[amount];
	}

	//mine
	public int coinChange(int[] coins, int amount) {
		if (amount == 0)
			return 0;
		if (coins.length < 0)
			return -1;
		else if (coins.length == 1 && amount % coins[0] != 0)
			return -1;

		else {
			Arrays.sort(coins);

			List<List<Integer>> ret = help(coins, amount, coins.length - 1);
			if (ret.size() == 0)
				return -1;
			else {
//				int min = Integer.MAX_VALUE;
//				for (int i = 0; i < ret.size(); i++)
//					min = Math.min(min, ret.get(i).size());
//				return min;
				return ret.get(0).size();
			}
		}
	}

	private List<List<Integer>> help(int[] coins, int amount, int lastIndex) {
		List<List<Integer>> ret = new ArrayList<>();
		if (coins[0] > amount)
			return ret;

		for (int i = lastIndex; i >= 0; i--) {
			if (amount == coins[i]) {
				List<Integer> tmp = new ArrayList<>();
				tmp.add(coins[i]);
				ret.add(tmp);
				return ret;
			} else if (amount > coins[i]) {
				List<List<Integer>> next = help(coins, amount - coins[i], i);
				if (next.size() > 0) {
//					System.out.println(next.size());
					for (int j = 0; j < next.size(); j++) {
						List<Integer> tmp = new ArrayList<>();
						tmp.add(coins[i]);
						tmp.addAll(next.get(j));
						ret.add(tmp);

//						return ret;// 只要最短的那一个。
					}
				}
			} else {
				continue;
			}
		}

		return ret;
	}

	void printList(List<List<Integer>> list) {
		for (int i = 0; i < list.size(); i++) {
			System.out.print(i + "，  size: " + list.get(i).size() + " : ");
			for (int j = 0; j < list.get(i).size(); j++) {
				System.out.print(list.get(i).get(j) + " ");
			}
			System.out.println();
		}
		System.out.println();
	}
}
