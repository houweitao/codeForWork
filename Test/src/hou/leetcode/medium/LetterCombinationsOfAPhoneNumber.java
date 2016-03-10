package hou.leetcode.medium;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * @author houweitao
 * @date 2015年12月31日 上午12:49:32
 * @end 2015年12月31日01:27:10
 * https://leetcode.com/problems/letter-combinations-of-a-phone-number
 */

public class LetterCombinationsOfAPhoneNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LetterCombinationsOfAPhoneNumber lc = new LetterCombinationsOfAPhoneNumber();

		List<String> ret = lc.letterCombinations("23");
		lc.printList(ret);
	}

	public List<String> letterCombinations(String digits) {
		if(digits.length()==0)
			return new LinkedList<String>();
		
		HashMap<Integer, char[]> hm = new HashMap<>();
		char[] c2 = { 'a', 'b', 'c' };
		hm.put(2, c2);
		char[] c3 = { 'd', 'e', 'f' };
		hm.put(3, c3);
		char[] c4 = { 'g', 'h', 'i' };
		hm.put(4, c4);
		char[] c5 = { 'j', 'k', 'l' };
		hm.put(5, c5);
		char[] c6 = { 'm', 'n', 'o' };
		hm.put(6, c6);
		char[] c7 = { 'p', 'q', 'r', 's' };
		hm.put(7, c7);
		char[] c8 = { 't', 'u', 'v' };
		hm.put(8, c8);
		char[] c9 = { 'w', 'x', 'y', 'z' };
		hm.put(9, c9);
		return help(hm, digits, 1);
	}

	public List<String> help(HashMap<Integer, char[]> hm, String digits, int pos) {
		List<String> ret = new LinkedList<>();
		if (pos > digits.length()) {
			ret.add("");
			return ret;
		}

		int target = Integer.valueOf(digits.charAt(pos - 1) + "");
		char[] cur = hm.get(target);
		for (int i = 0; i < cur.length; i++) {
			List<String> next = help(hm, digits, pos + 1);
			for (int j = 0; j < next.size(); j++) {
				List<String> tmp = new LinkedList<>();
				tmp.add(cur[i] + next.get(j));
				ret.addAll(tmp);
			}
		}

		return ret;
	}

	void printList(List<String> ret) {
		for (int i = 0; i < ret.size(); i++)
			System.out.print(ret.get(i) + ",");
	}
}

class Member {
	char[] ch;
}
