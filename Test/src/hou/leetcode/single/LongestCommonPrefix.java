package hou.leetcode.single;

/**
 * @author houweitao
 * @date 2015年11月20日 上午11:49:02
 * @end 2015年11月20日12:06:13
 * https://leetcode.com/problems/longest-common-prefix/
 */

public class LongestCommonPrefix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String s = "12345";
		System.out.println(s.substring(0, 1));
		String[] strs = { "ab", "ac" };
		LongestCommonPrefix l = new LongestCommonPrefix();
		System.out.println(l.longestCommonPrefix(strs));
	}

	public String longestCommonPrefix(String[] strs) {
		if (strs.length == 0)
			return "";
		else if (strs.length == 1)
			return strs[0];
		else {
			String judge = strs[0];
			for (int j = 0; j < judge.length(); j++) {
				for (int i = 1; i < strs.length; i++) {
					if (strs[i].length() > j) {
						if (strs[i].charAt(j) != judge.charAt(j)) {
							return judge.substring(0, j);
						}
					} else
						return judge.substring(0, Math.min(strs[i].length(), judge.length()));
				}
			}
		}
		return strs[0];
	}
}
