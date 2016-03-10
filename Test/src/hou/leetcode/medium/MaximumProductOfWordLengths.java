package hou.leetcode.medium;

/**
 * @author houweitao
 * @date 2015年12月16日 上午10:33:47
 * https://leetcode.com/problems/maximum-product-of-word-lengths/
 */

public class MaximumProductOfWordLengths {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] words = { "a", "aa", "aaa", "aaaa" };
		MaximumProductOfWordLengths max = new MaximumProductOfWordLengths();
		max.maxProduct(words);
	}

	public int maxProduct(String[] words) {
		int max = 0;

		for (int i = 0; i < words.length; i++) {
			for (int j = i + 1; j < words.length; j++) {
				if (notSame(words[i], words[j])) {
					if (words[i].length() * words[j].length() > max)
						max = words[i].length() * words[j].length();
				}
			}
		}
		System.out.println(max);
		return max;
	}

	private boolean notSame(String a, String b) {
		// TODO Auto-generated method stub
		for (int i = 0; i < a.length(); i++) {
			if (b.contains(a.charAt(i) + "")) {
				return false;
			}
		}
		return true;
	}
}
