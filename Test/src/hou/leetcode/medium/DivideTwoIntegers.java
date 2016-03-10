package hou.leetcode.medium;

/**
 * @author houweitao
 * @date 2016年2月29日 下午1:17:58
 * @end 2016年2月29日14:12:49
 * 好麻烦。。
 * https://leetcode.com/problems/divide-two-integers
 */

public class DivideTwoIntegers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DivideTwoIntegers dt = new DivideTwoIntegers();
		System.out.println(dt.divide(-2147483648, 2));
	}

	public int divide(int dividend, int divisor) {
		if (dividend == Integer.MIN_VALUE) {
			if (divisor == 0 || divisor == 1)
				return Integer.MIN_VALUE;
			else if (divisor == -1)
				return Integer.MAX_VALUE;
			else if (divisor > 0)
				return divide(dividend + divisor, divisor) - 1;
			else
				return divide(dividend - divisor, divisor) + 1;
		}

		if (divisor == Integer.MIN_VALUE) {
			if (dividend == divisor)
				return 1;
			else
				return 0;
		}
		if (divisor == 0)
			return Integer.MAX_VALUE;
		if (divisor == 1)
			return dividend;
		if (divisor == -1)
			if (dividend != Integer.MIN_VALUE)
				return -dividend;
			else
				return Integer.MAX_VALUE;
		if (dividend == 0)
			return 0;
		boolean same = true;
		if ((dividend > 0 && divisor < 0) || (dividend < 0 && divisor > 0))
			same = false;
		int res = 0;
		int i = 1;

		dividend = Math.abs(dividend);
		divisor = Math.abs(divisor);

		if (dividend < divisor)
			return 0;
		if (dividend == divisor) {
			if (same)
				return 1;
			else
				return -1;
		}

		int tmp = divisor;

		if (divisor < 100000000) {
			while (dividend > divisor) {
				System.out.println(dividend + " : " + divisor);

				dividend = dividend - divisor;
				divisor = divisor + divisor;
				res = res + i;
				i = i + i;
				if (divisor > 100000000)
					break;
			}

			int next = divide(dividend, tmp);

			int ret = next + res;
			if (!same)
				ret = ret * -1;
			return ret;
		} else {
			int time = 0;
			while (dividend > divisor) {
				dividend = dividend - divisor;
				time++;
			}

			if (!same)
				time = time * -1;

			return time;
		}

	}
}
