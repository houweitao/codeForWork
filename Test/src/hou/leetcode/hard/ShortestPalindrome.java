package hou.leetcode.hard;

/**
 * @author houweitao
 * @date 2015年12月25日 下午3:36:11
 * @end 2015年12月25日16:30:40
 * 超时了..
 * https://leetcode.com/problems/shortest-palindrome?sort=answers
 */

public class ShortestPalindrome {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "abcdefgg";
		ShortestPalindrome sp = new ShortestPalindrome();
		System.out.println(sp.judgePalindrome(s, 6, true));

		System.out.println(sp.shortestPalindrome(s));
		System.out.println(sp.better(s));
	}

	//better
	public String better(String s) {
		int j = 0;
		for (int i = s.length() - 1; i >= 0; i--) {
			if (s.charAt(i) == s.charAt(j)) {
				j += 1;
			}
		}
		if (j == s.length()) {
			return s;
		}
		String suffix = s.substring(j);
		return new StringBuffer(suffix).reverse().toString() + shortestPalindrome(s.substring(0, j)) + suffix;
	}

	//mine
	public String shortestPalindrome(String s) {
		if (s.length() == 0)
			return "";
		if (s.length() == 1)
			return s;

		int bestPlace = 0;
		int shortest = Integer.MAX_VALUE;
		boolean jiou = true;
		for (int i = 0; i < s.length(); i++) {
			if (judgePalindrome(s, i, true)) {
				int curShortest = Integer.MAX_VALUE;
				if (s.length() - 1 - i > i)
					curShortest = s.length() - 1 - 2 * i;
				else
					curShortest = -1 * (s.length() - 1 - 2 * i);

				if (curShortest < shortest) {
					shortest = curShortest;
					bestPlace = i;
					jiou = true;
				}
			}
			if (judgePalindrome(s, i, false)) {
				int curShortest = Integer.MAX_VALUE;
				if (s.length() > 2 * i)
					curShortest = s.length() - 2 * i - 2;
				else
					curShortest = -1 * (s.length() - 2 * i - 2);

				if (curShortest < shortest) {
					shortest = curShortest;
					bestPlace = i;
					jiou = false;
				}
			}
		}

		System.out.println(bestPlace + "," + jiou);

		if (jiou) {
			if (bestPlace < s.length() - 1 - bestPlace)
				return reverseStr(s.substring(bestPlace + 1)) + s.substring(bestPlace);
			else
				return s.substring(0, bestPlace + 1) + reverseStr(s.substring(0, bestPlace));
		} else {
			if (bestPlace < s.length() - 2 - bestPlace)
				return reverseStr(s.substring(bestPlace + 1)) + s.substring(bestPlace + 1);
			else
				return s.substring(0, bestPlace + 1) + reverseStr(s.substring(0, bestPlace + 1));
		}
	}

	boolean judgePalindrome(String s, int index, boolean isJishu) {
		if (isJishu) {
			for (int i = 1; i < Integer.MAX_VALUE; i++) {
				if (index + i >= s.length() || index - i < 0)
					return true;
				if (s.charAt(index + i) != s.charAt(index - i))
					return false;
			}
		} else {
			for (int i = 0; i < Integer.MAX_VALUE; i++) {
				if (index + i + 1 >= s.length() || index - i < 0)
					return true;
				if (s.charAt(index + i + 1) != s.charAt(index - i))
					return false;
			}
		}
		return true;
	}

	String reverseStr(String s) {
		String ret = "";
		for (int i = s.length() - 1; i >= 0; i--)
			ret = ret + s.charAt(i);

		return ret;
	}
}
