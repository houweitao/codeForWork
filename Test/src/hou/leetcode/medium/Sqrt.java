package hou.leetcode.medium;

/**
 * @author houweitao
 * @date 2015年11月13日 下午5:00:05
 */

public class Sqrt {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Sqrt sqrt = new Sqrt();
		System.out.println(sqrt.mySqrt(21433));
	}

	public int mySqrt2(int x) {
		int[] tmp = new int[x];
		for (int i = 1; i < x; i++) {
			tmp[i - 1] = (i - 1) * (i - 1);
			if (tmp[i - 1] <= x && i * i > x)
				return i;
		}
		return 0;
	}

	public int mySqrt(int x) {
		int n = x / 2;
		int mark = x;
		while (mark >= 1) {
			mark = mark / 2;
			System.out.println(mark + "," + n + "," + n * n);
			if (n * n > x) {
				n = n - mark;
			} else if (n * n < x)
				n = n + mark;
			else
				return n;
		}
		if (n * n > x)
			while (n * n > x)
				n--;
		else
			while (n * n < x)
				n++;

		return n;
	}
}
