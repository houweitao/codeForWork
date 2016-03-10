package hou.leetcode.medium;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author houweitao
 * @date 2015年12月3日 下午2:29:57
 * @end 2015年12月3日14:35:12
 * 再次做好快~happy
 * https://leetcode.com/problems/word-break-ii/
 */

public class WordBreakII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WordBreakII wb = new WordBreakII();
		Set<String> dict = new HashSet<String>();
		dict.add("cat");
		dict.add("cats");
		dict.add("and");
		dict.add("sand");
		dict.add("dog");

		String s = "catsanddogcatsanddog";

		List<String> result = wb.wordBreak(s, dict);
		for (String re : result) {
			System.out.println(re);
		}
	}

	public List<String> wordBreak(String s, Set<String> dict) {
		List<String> result = new ArrayList<String>();

		for (int j = s.length() - 1; j >= 0; j--) {
			if (dict.contains(s.substring(j)))
				break;
			else {
				if (j == 0) {
					System.out.println("no exist..");
					return result;
				}
			}
		}

		if (dict.contains(s)) {
			result.add(s);
			return result;
		} else {
			for (int i = 0; i < s.length(); i++) {
				if (dict.contains(s.substring(0, i + 1))) {
					List<String> next = wordBreak(s.substring(i + 1), dict);
					if (next.size() != 0) {
						for (String nextStr : next) {
							result.add(s.substring(0, i + 1) + " " + nextStr);
						}
					}
				}
			}

			return result;
		}
	}
}
