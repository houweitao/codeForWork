package hou.leetcode.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author houweitao
 * @date 2015年12月11日 下午3:01:16
 * https://leetcode.com/problems/anagrams/
 * http://www.1point3acres.com/bbs/thread-157956-1-1.html
 */

public class GroupAnagrams {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GroupAnagrams ga = new GroupAnagrams();
		System.out.println(ga.dealStr("aabac"));
	}

	public List<List<String>> groupAnagrams(String[] strs) {
		HashMap<String, ArrayList<String>> hm = new HashMap<>();
		List<List<String>> ret = new ArrayList<>();
		for (int i = 0; i < strs.length; i++) {
			String tmp = dealStr(strs[i]);
			if (hm.containsKey(tmp)) {
				hm.get(tmp).add(strs[i]);
			} else {
				ArrayList<String> use = new ArrayList<>();
				use.add(strs[i]);
				hm.put(tmp, use);
			}
		}

		for (String s : hm.keySet()) {
			ret.add(hm.get(s));
		}
		return ret;
	}

	private String dealStr(String str) {
		// TODO Auto-generated method stub
		int[] record = new int[26];
		for (int i = 0; i < str.length(); i++) {
			record[str.charAt(i) - 'a']++;
		}
		String ret = "";
		for (int i = 0; i < 26; i++) {
			if (record[i] != 0) {
				ret = ret + record[i] + (char) ('a' + i);
			}
		}

		return ret;
	}
}
