package hou.leetcode.hard;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * @author houweitao
 * @date 2016年2月11日下午2:51:24
 */

public class WordBreakII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "catsanddog";
		String[] dict = { "cat", "cats", "sand", "and", "dog", "og", "d" };
		Set<String> wordDict = new HashSet<>();
		for (String str : dict)
			wordDict.add(str);

		s="aaaaaaaaaaaaa";
		wordDict.add("a");
		wordDict.add("aa");
		
		System.out.println(s.substring(1, 3));

		WordBreakII wb = new WordBreakII();

		List<String> list = wb.wordBreak(s, wordDict);
		wb.print(list);

		// List<String> test = new LinkedList<>();
		// System.out.println(test == null);
	}

	public List<String> wordBreak(String s, Set<String> wordDict) {
		if (!easyJudge(s, wordDict))
			return null;
		else {
			System.out.println("..");
			return help(s, wordDict, 0);
		}

	}

	private List<String> help(String s, Set<String> wordDict, int pos) {
		// TODO Auto-generated method stub
		List<String> ret = new LinkedList<>();

		for (int i = pos; i < s.length() - 1; i++) {
			// System.out.println(s.substring(pos, i + 1));
			if (wordDict.contains(s.substring(pos, i + 1))) {
				List<String> next = help(s, wordDict, i + 1);

				if (next != null && next.size() > 0) {
					String add = "";
					// System.out.println("size: " + next.size());
					String cur = s.substring(pos, i + 1);

					for (String str : next) {
						add = cur + " " + str;
						// System.out.println("add: " + add);
						ret.add(add);
					}
				}
			}
		}

		if (wordDict.contains(s.substring(pos)))
			ret.add(s.substring(pos));

		return ret;
	}

	private boolean easyJudge(String s, Set<String> wordDict) {
		// TODO Auto-generated method stub
		if (s.length() == 0)
			return false;
		else {
			for (int i = s.length() - 1; i >= 0; i--) {
				if (wordDict.contains(s.substring(i)))
					return true;
			}
			return false;
		}
	}

	void print(List<String> list) {
		if (list == null || list.size() == 0) {
			System.out.println("null");
			return;
		}

		for (String s : list) {
			System.out.println(s);
		}
	}
}
