package hou.leetcode.single;

/**
 * @author houweitao
 * @date 2015年10月29日 下午3:31:31
 */

public class ClimbingStairs {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ClimbingStairs cs = new ClimbingStairs();
		int count = cs.climbStairs(4);
		System.out.println(count);
	}

	int climbStairs(int n) {
		if (n <= 0)
			return 0;
		if (n == 1)
			return 1;
		if (n == 2)
			return 2;
		else
			return climbStairs(n - 1) + climbStairs(n - 2);
	}
}
