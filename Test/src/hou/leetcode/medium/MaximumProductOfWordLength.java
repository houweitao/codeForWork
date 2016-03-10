package hou.leetcode.medium;

//@date 2016年02月01日23:06:55
//超时..

public class MaximumProductOfWordLength {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] words = { "abcw", "baz", "foo", "bar", "xtfn", "abcdef" };
		MaximumProductOfWordLength max = new MaximumProductOfWordLength();
		System.out.println(max.maxProduct(words));
	}

	public int maxProduct(String[] words) {
		int max = 0;

		for (int i = 0; i < words.length; i++) {
			for (int j = i + 1; j < words.length; j++) {
				if (different(words[i], words[j])) {
					max = Math.max(max, words[i].length() * words[j].length());
				}
			}
		}
		return max;
	}

	private boolean different(String a, String b) {
		if ((a == null && b != null) || (a != null && b == null))
			return true;

		for (int i = 0; i < a.length(); i++) {
			if (b.contains(a.charAt(i) + ""))
				return false;
		}

		return true;
	}
}
