package hou.leetcode.hard;

/**
 * @author houweitao
 * @date 2015年12月3日 下午4:01:52
 * @notRight 2015年12月3日16:25:47
 * https://leetcode.com/problems/scramble-string/
 */

public class ScrambleString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ScrambleString ss = new ScrambleString();
		System.out.println(ss.isScramble("abcdd", "acddb"));
	}

	public boolean isScramble(String s1, String s2) {
		int[] letters = new int[26];
		for (int i = 0; i < s1.length(); i++) {
			letters[s1.charAt(i) - 'a']++;
			letters[s2.charAt(i) - 'a']--;
		}

		for (int i = 0; i < 26; i++)
			if (letters[i] != 0)
				return false;

		return true;

	}
}
