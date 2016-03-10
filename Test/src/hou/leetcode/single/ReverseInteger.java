package hou.leetcode.single;

/**
 * @author houweitao 2015年8月2日 下午2:32:10
 *         https://leetcode.com/problems/reverse-integer/
 */

public class ReverseInteger {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ReverseInteger ri = new ReverseInteger();
		ri.reverse(15342);

	}

	public int reverse(int x) {
		boolean postive = true;
		if (x < 0) {
			postive = false;
			x = -x;
		}
		long rev = 0;
		while (x > 0) {
			rev = rev * 10 + x % 10;

			if (rev > Integer.MAX_VALUE)
				return 0;
			if (rev < Integer.MIN_VALUE)
				return 0;

			x = x / 10;
		}
		if (!postive)
			rev = -rev;
		System.out.println(rev);
		return (int)rev;
	}

}
