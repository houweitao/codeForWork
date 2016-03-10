package hou.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * @author houweitao
 * @date 2015年12月16日 下午3:41:00
 * @end 2015年12月16日16:09:41
 * https://leetcode.com/problems/palindrome-partitioning
 */

public class PalindromePartitioning {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "bb";
//		System.out.println(": " + s.substring(3));
		PalindromePartitioning pp = new PalindromePartitioning();
		List<List<String>> ret = pp.partition(s);
		pp.printList(ret);
	}

	public List<List<String>> partition(String s) {
		List<List<String>> ret = new ArrayList<>();

		if (s.length() == 0)
			return ret;
		else if (s.length() == 1) {
			List<String> tmp = new ArrayList<>();
			tmp.add(s);
			ret.add(tmp);
			return ret;
		} else {

			if (isPalindrome(s)) {
				List<String> tmp = new ArrayList<>();
				tmp.add(s);
				ret.add(tmp);
			}

			for (int i = 0; i < s.length() - 1; i++) {
				if (isPalindrome(s.substring(0, i + 1))) {
//					System.out.println(s.substring(0, i + 1));
					List<List<String>> next = partition(s.substring(i + 1));
					if (next.size() > 0)
						for (int j = 0; j < next.size(); j++) {
							List<String> tmp = new ArrayList<>();
							tmp.add(s.substring(0, i + 1));
							tmp.addAll(next.get(j));
							ret.add(tmp);
						}
				}
			}

			return ret;
		}
	}

	private boolean isPalindrome(String s) {
		// TODO Auto-generated method stub
		if (s.length() < 1)
			return false;
		else if (s.length() == 1)
			return true;
		else {
			int m = 0, n = s.length() - 1;
			while (m <= n) {
				if (s.charAt(m) == s.charAt(n)) {
					m++;
					n--;
				} else
					return false;
			}
			return true;
		}
	}

	void printList(List<List<String>> ret) {
		for (int i = 0; i < ret.size(); i++) {
			for (int j = 0; j < ret.get(i).size(); j++) {
				System.out.print(ret.get(i).get(j) + ",");
			}
			System.out.println();
		}
		System.out.println();
	}
}
