package hou.leetcode.hard;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * @author houweitao
 * @date 2016年2月11日下午3:36:53
 * @bug 2016年02月11日16:11:45
 */

public class WordBreakIIWithMemory {
	String[] memory = null;

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

		WordBreakIIWithMemory wb = new WordBreakIIWithMemory();

		List<String> list = wb.wordBreak(s, wordDict);
		wb.print(list);

		// List<String> test = new LinkedList<>();
		// System.out.println(test == null);
	}

	public List<String> wordBreak(String s, Set<String> wordDict) {
		if (!easyJudge(s, wordDict))
			return null;
		else {
			memory = new String[s.length()];
			for (int i = 0; i < memory.length; i++)
				memory[i] = ",";
			System.out.println(memory[2] == null);
			return help(s, wordDict, 0);
		}

	}

	private List<String> help(String s, Set<String> wordDict, int pos) {
		// TODO Auto-generated method stub
		List<String> ret = new LinkedList<>();

		for (int i = pos; i < s.length() - 1; i++) {
			// System.out.println(s.substring(pos, i + 1));
			if (wordDict.contains(s.substring(pos, i + 1))) {

				if (!memory[i + 1].equals(",")) {
					String[] result = memory[i + 1].split(",");

					System.out.println("memory: " + memory[i + 1]);

					for (String str : result) {
						ret.add(s.substring(pos, i + 1) + " " + str);
					}
					// return ret;
				} else {

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

						for (String str : ret) {
							if (!memory[pos].contains(str))
								memory[pos] = memory[pos] + "," + str;
						}
					}
				}
			}
		}

		if (wordDict.contains(s.substring(pos))) {
			if (!memory[pos].contains(s.substring(pos)))
				;
			memory[pos] = memory[pos] + "," + s.substring(pos);
			ret.add(s.substring(pos));
		}

		for (String str : ret) {
			memory[pos] = memory[pos] + "," + str;
		}

		for (int i = 0; i < s.length(); i++) {
			System.out.print(memory[i] + "    ");
		}
		System.out.println();

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
