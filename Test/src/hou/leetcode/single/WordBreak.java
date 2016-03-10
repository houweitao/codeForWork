package hou.leetcode.single;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 * @author houweitao
 * @date 2015年10月28日 上午9:37:41
 * https://leetcode.com/problems/word-break-ii/
 * https://leetcode.com/discuss/27464/my-concise-answer
 */

public class WordBreak {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WordBreak wb = new WordBreak();
		//		wb.testSubString("1234567890");

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

		System.out.println();

		result = wb.wordBreak2(s, dict);
		for (String re : result) {
			System.out.println(re);
		}
	}

	void testSubString(String s) {
		int i = s.length();
		System.out.println(s);
		System.out.println(s.substring(i - 3));
		System.out.println(s.substring(3, 7));
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

		for (int i = 0; i < s.length() - 1; i++) {
			if (dict.contains(s.substring(0, i + 1))) {
				List<String> strs = wordBreak(s.substring(i + 1, s.length()), dict);
				if (strs.size() != 0)
//					System.out.println(strs.size());
//					for(int j=0;j<strs.size();j++)
//						System.out.print(strs.get(j)+",");
//				System.out.println();
				for (Iterator<String> it = strs.iterator(); it.hasNext();) {
					String tmp = it.next();
//						System.out.println("0," + i + ": " + s.substring(0, i + 1) + " next: " + tmp);
					result.add(s.substring(0, i + 1) + " " + tmp);
//						System.out.println(".." + tmp + "..");
				}                                                                                                               
			}

//			else
//				System.out.println("no exist");
		}
		if (dict.contains(s))
			result.add(s);
		return result;
	}

	public List<String> wordBreak2(String s, Set<String> dict) {
		List<String> result = new ArrayList<String>();

		for (int i = 0; i < s.length(); i++) {
			if (dict.contains(s.substring(0, i + 1))) {
				List<String> list = wordBreak2(s.substring(i + 1, s.length()), dict);
				if (list.size() != 0) {
//					result.add(s.substring(0, i + 1) + " " + list.get(0));
//					System.out.println(list.size());
					for (Iterator<String> it = list.iterator(); it.hasNext();) {
						String tmp = it.next();
//						System.out.println("0," + i + ": " + s.substring(0, i + 1) + " next: " + tmp);
						result.add(s.substring(0, i + 1) + " " + tmp);
//						System.out.println(".." + tmp + "..");
					}

				}
			}
		}
		if (dict.contains(s))
			result.add(s);
		return result;
	}
}
