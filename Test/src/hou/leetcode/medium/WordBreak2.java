package hou.leetcode.medium;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author houweitao
 * @date 2015年12月3日 下午1:30:59
 */

public class WordBreak2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Set<String> wordDict = new HashSet<String>();
		String s = "aaaaaaaa";
		wordDict.add("aaa");
		wordDict.add("aa");
		WordBreak2 wb = new WordBreak2();
		boolean judge = wb.wordBreak(s, wordDict);
		System.out.println(judge);
	}

	public boolean wordBreak(String s, Set<String> dict) {
		List<String> result = new ArrayList<String>();

		if (dict.contains(s)) {
			result.add(s);
			return true;
		} else {
			for (int i = 0; i < s.length(); i++) {
				if (dict.contains(s.substring(0, i + 1))) {
					boolean next = wordBreak(s.substring(i + 1), dict);
					if (next) {
						return next;
					}
				}
			}
		}
		return false;
	}

	private List<String> help(String s, Set<String> wordDict) {
		// TODO Auto-generated method stub
		List<String> ret = new ArrayList<>();

		if (wordDict.contains(s))
			ret.add(s);
		else
			for (int i = 0; i < s.length(); i++) {
				if (wordDict.contains(s.substring(0, i + 1))) {

//					System.out.println(s.substring(0, i + 1));

					List<String> tmp = help(s.substring(i + 1), wordDict);
					if (tmp.size() > 0) {
						ret.add(s.substring(0, i + 1));
						ret.addAll(tmp);
					}
				}

			}
		return ret;
	}
}
