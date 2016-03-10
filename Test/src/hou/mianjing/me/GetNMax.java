package hou.mianjing.me;

/**
 * @author houweitao
 * @date 2015年11月10日 上午10:24:04
 * http://www.1point3acres.com/bbs/thread-147244-1-1.html
 */

public class GetNMax {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GetNMax gnm=new GetNMax();
		
		int[][] nums={{1,4,700,3},{2,5,10,6}};
		
		System.out.println(gnm.getmaxsum(nums, 3));
	}

	// somthing wrong..
	public int getmaxsum(int[][] nums, int n) {
		int[][] dp = new int[nums.length + 1][n + 1];
		for (int k = 1; k <= n; k++) {
			for (int i = 1; i <= nums.length; i++) {
				int len = nums[i - 1].length, sum = 0;
				for (int j = 0; j < len && j < k; j++) {
					sum += nums[i - 1][j];
					dp[i][k] = Math.max(dp[i][k], sum + dp[i - 1][k - j - 1]);
				}
			}
		}
		return dp[nums.length][n];
	}
}
