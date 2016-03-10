package hou.leetcode.hard;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

/**
 * @author houweitao
 * @date 2016年3月2日下午11:04:37
 * @end 2016年03月03日00:06:00
 */

public class WordLadderII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] words = { "hot", "dot", "dog", "lot", "log", "cit", "cig" };
		Set<String> wordList = new HashSet<>();
		for (String s : words)
			wordList.add(s);

		String beginWord = "hit", endWord = "cog";
		WordLadderII w = new WordLadderII();
		System.out.println(w.findLadders(beginWord, endWord, wordList));
	}

	public List<List<String>> findLadders(String beginWord, String endWord, Set<String> wordList) {
		List<String> beginGroup = getNeighbor(beginWord, wordList);
		List<String> endGroup = getNeighbor(endWord, wordList);
		HashMap<String, List<String>> map = initGraph(wordList);

		System.out.println("beginGroup: " + beginGroup);
		System.out.println("endGroup: " + endGroup);
		for (Entry<String, List<String>> entry : map.entrySet()) {
			System.out.println(entry.getKey() + " : " + entry.getValue());
		}

		List<List<String>> ret = new LinkedList<>();

		for (String begin : beginGroup) {
			List<String> list = new LinkedList<>();
			list.add(begin);
			ret.add(list);
		}
		List<List<String>> next = new LinkedList<>();
		for (int i = 0; i < ret.size(); i++) {
			List<List<String>> cur = help(ret.get(i), endGroup, map);
			next.addAll(cur);
		}

		// for (int i = 0; i < next.size(); i++) {
		// next.get(i).add(0, beginWord);
		// next.get(i).add(next.get(i).size() - 1, endWord);
		// }

		int min = Integer.MAX_VALUE;
		ret.clear();
		for (int i = 0; i < next.size(); i++) {
			List<String> list = next.get(i);
			System.out.println(list);
			if (min == list.size()) {
				list.add(0, beginWord);
				list.add(endWord);
				ret.add(list);
			} else if (min > list.size()) {
				min = list.size();
				ret.clear();
				list.add(0, beginWord);
				list.add(endWord);
				ret.add(list);
			}
		}

		return ret;

	}

	private List<List<String>> help(List<String> list, List<String> endGroup, HashMap<String, List<String>> map) {
		// TODO Auto-generated method stub
		List<List<String>> ret = new LinkedList<>();
		String beginWord = list.get(list.size() - 1);

		List<String> next = map.get(beginWord);

		for (String s : next) {
			if (!list.contains(s)) {
				List<String> l = new LinkedList<>();
				l.addAll(list);
				l.add(s);
				if (endGroup.contains(s)) {
					ret.add(l);
				} else {
					ret.addAll(help(l, endGroup, map));
				}
			}
		}

		return ret;
	}

	HashMap<String, List<String>> initGraph(Set<String> wordList) {
		HashMap<String, List<String>> ret = new HashMap<>();
		for (String s1 : wordList) {
			ret.put(s1, new LinkedList<String>());
			for (String s2 : wordList) {
				if (yes(s1, s2))
					ret.get(s1).add(s2);
			}
		}
		return ret;
	}

	List<String> getNeighbor(String seed, Set<String> wordList) {
		List<String> ret = new LinkedList<>();

		for (String s : wordList) {
			if (yes(seed, s)) {
				ret.add(s);
			}
		}
		return ret;
	}

	private boolean yes(String s1, String s2) {
		if (s1.equals(s2) || s1.length() != s2.length())
			return false;
		else {
			int sameNum = 0;
			for (int i = 0; i < s1.length(); i++) {
				if (s1.charAt(i) == s2.charAt(i))
					sameNum++;
			}

			if (sameNum + 1 == s1.length())
				return true;
			else
				return false;
		}

	}
}
