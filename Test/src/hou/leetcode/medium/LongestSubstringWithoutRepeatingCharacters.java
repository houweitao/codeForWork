package hou.leetcode.medium;

/**
 * @author houweitao
 * @date 2015年12月1日 上午12:54:27
 * @end 2015年12月1日01:14:36
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/
 */

public class LongestSubstringWithoutRepeatingCharacters {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LongestSubstringWithoutRepeatingCharacters max = new LongestSubstringWithoutRepeatingCharacters();
		System.out.println(max.lengthOfLongestSubstring("abc"));
	}

	public int lengthOfLongestSubstring(String s) {
		if (s.length() < 2)
			return s.length();

		int i = 0, j = 1;
		int max = Integer.MIN_VALUE;
		int markPlace = -1;
		String tmp = new String();
		while (j < s.length()+1) {
			markPlace = i - 1;
			tmp = s.substring(i, j);
			if (tmp.length() > max)
				max = tmp.length();

			if (j != s.length())//这里！注意边界问题
				for (int k = i; k < j; k++) {
					if (s.charAt(k) == s.charAt(j)) {
						markPlace = k;
						break;
					}
				}

			i = markPlace + 1;
			j++;

		}

		return max;
	}
}
