package hou.leetcode.locked;

/**
 * @author houweitao
 * @date 2015年12月11日 上午10:42:14
 * https://leetcode.com/problems/paint-house-ii/
 * http://www.cnblogs.com/easonliu/p/4784858.html
 */

public class PaintHouseII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	int paint(int n, int cost[][]) {
		return help(n, cost, cost.length);
	}

	//思想：动态规划。用forbidden这个参数来实现相邻房子不同颜色。
	//自顶向下
	//如果自底向上的话可以用一个跟cost相同大小的数组，来保存最后一个房子选择这个颜色时的最小花费
	private int help(int n, int cost[][], int forbiden) {
		// TODO Auto-generated method stub
		int min = Integer.MAX_VALUE;
		if (n == 1) {
			for (int i = 0; i < cost.length; i++) {
				if (i != forbiden) {
					min = Math.min(min, cost[0][i]);
				}
			}
			return min;
		} else {
			for (int i = 0; i < cost.length; i++) {
				if (i != forbiden)
					min = Math.min(min, cost[n - 1][i] + help(n - 1, cost, i));
			}
			return min;
		}
	}
}
