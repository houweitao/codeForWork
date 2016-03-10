package hou.leetcode.single;

/**
 * @author houweitao
 * @date 2015年10月29日 下午3:42:57
 * https://leetcode.com/problems/ugly-number/?sort=votes
 */

public class UglyNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		UglyNumber un = new UglyNumber();
		System.out.println(un.isUgly(8));
	}

	boolean isUgly(int num) {
		int count = 0;
		while (num > 0) {
			if (num % 2 == 0) {
				num = num / 2;
				count++;
			}
			if (num % 3 == 0) {
				num = num / 3;
				count++;
			}
			if (num % 5 == 0) {
				num = num / 5;
				count++;
			}

			if (count == 0) {
				if (num > 2)
					return false;
				if (num == 1)
					return true;
			}

			count = 0;
		}

		return false;

//		for (int i=2; i<6 && num>0; i++)
//		    while (num % i == 0)
//		        num /= i;
//		return num == 1;
	}
}
