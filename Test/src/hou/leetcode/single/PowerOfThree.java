package hou.leetcode.single;

/**
 * @author houweitao
 * @date 2016年1月28日 下午3:56:27
 * @end 2016年1月28日16:01:36
 * https://leetcode.com/problems/power-of-three/
 */

public class PowerOfThree {

	public static void main(String[] args) {
		PowerOfThree three = new PowerOfThree();
		for (int i = 0; i < 100; i++) {
			if (three.isPowerOfThree(i))
				System.out.println(i + ": " + true);
			else
				System.out.println(i + ": " + false);
		}
	}

	public boolean isPowerOfThree(int n) {
		if (n < 0)
			return false;

		while (n > 0 && n % 3 == 0) {
			n = n / 3;
		}

		if (n != 1)
			return false;
		else
			return true;
	}
}
