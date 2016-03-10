package hou.leetcode.single;

/**
 * @author houweitao 2015年7月31日 下午4:03:48
 */

public class PowerofTwo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PowerofTwo pt = new PowerofTwo();
		System.out.println(pt.isPowerOfTwo(128));
	}

	public boolean isPowerOfTwo(int n) {
		if (n == 0)
			return false;
		else if (n == 1)
			return true;

		else {
			boolean judge = false;
			while (n % 2 == 0) {
				n = n / 2;
				if (n == 1)
					judge = true;
			}

			return judge;
		}
	}
}
