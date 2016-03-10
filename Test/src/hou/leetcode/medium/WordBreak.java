package hou.leetcode.medium;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * @author houweitao
 * @date 2015年11月13日 下午4:33:06
 * not work
 */

public class WordBreak {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Set<String> wordDict = new HashSet<String>();
		String s = "leetcode";
		wordDict.add("leet");
		wordDict.add("code");
		WordBreak wb = new WordBreak();
		boolean judge = wb.wordBreak(s, wordDict);
		System.out.println(judge);
	}

	public boolean wordBreak(String s, Set<String> wordDict) {

//		Iterator<String> it = wordDict.iterator();
//		while (it.hasNext()) {
//			String str = it.next();
//			if(s.contains(str))
//			System.out.println(str);
//		}
		StringBuffer sb = new StringBuffer(s);
		String str = "";

		for (int i = 1; i < sb.length()+1; i++) {
			str = sb.substring(0, i);
			System.out.print(i + ": " + str + "  ");
			if (wordDict.contains(str)) {
				wordDict.remove(sb);
				sb.delete(0, i);
				System.out.println("sb: "+sb+","+sb.length());
				if (sb.length() == 0)
					return true;
				i = 0;
			}
			System.out.println();
		}

		return false;
	}
}
