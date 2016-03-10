package hou.mianjing.me;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;

/**
 * @author houweitao
 * @date 2015年12月5日 下午7:14:40
 * @end 2015年12月5日19:35:51
 * http://www.1point3acres.com/bbs/thread-156192-1-1.html
 */

public class JudgeAnagrams {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JudgeAnagrams ja = new JudgeAnagrams();
		String s1 = "abccd";
		String s2 = "dccba";
		boolean result = ja.judge(s1, s2);
		System.out.println(result);
		
		String[] strs={"abcd","adcb","sdfas","fsfs"};
		ja.printAllAnagrams(strs);
	}

	void printAllAnagrams(String[] strs) {
		HashMap<String, String> hashMap = new HashMap<String, String>();
		ArrayList<String> mark = new ArrayList<>();
		for (int i = 0; i < strs.length; i++) {
			String tmp = reverseWord(strs[i]);
			if (!hashMap.containsKey(tmp)) {
				hashMap.put(tmp, strs[i]);
			} else {
				System.out.println(strs[i]);
				mark.add(tmp);
			}
		}

		for (Entry<String, String> entry : hashMap.entrySet()) {
			if (mark.contains(entry.getKey()))
				System.out.println(entry.getValue());
		}

	}

	boolean judge(String s1, String s2) {
		if (s1.length() != s2.length())
			return false;
		else {
			if (reverseWord(s1).equals(reverseWord(s2)))
				return true;
			else
				return false;
		}
	}

	String reverseWord(String s) {
		s = s.toLowerCase();
		int[] postion = new int[26];
		for (int i = 0; i < s.length(); i++) {
			int pos = s.charAt(i) - 'a';
			postion[pos]++;
		}

		String ret = "";

		for (int i = 0; i < 26; i++) {
			if (postion[i] != 0) {
				char c = (char) ('a' + i);
				ret = ret + c + postion[i] + "";
			}
		}

		return ret;
	}
}
