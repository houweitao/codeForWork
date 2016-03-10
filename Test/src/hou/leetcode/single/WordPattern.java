package hou.leetcode.single;

import java.util.ArrayList;
import java.util.HashMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author houweitao
 * @date 2015年10月30日 上午9:53:32
 * https://leetcode.com/problems/word-pattern/
 * 字符串的相等！！
 * http://blog.chinaunix.net/uid-20681545-id-184559.html
 */

public class WordPattern {
	static final Logger logger = LoggerFactory.getLogger(WordPattern.class);

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		logger.info("begin");
		String pattern = "abba";
		String str = "dog cat cat dog";

		WordPattern wp = new WordPattern();
		System.out.println(wp.wordPattern(pattern, str));

	}

	public boolean wordPattern(String pattern, String str) {
		int length = pattern.length();
		String[] strs = str.split(" ");
//		System.out.println(strs.length);
		if (strs.length != length)
			return false;

		HashMap<Character, String> hs = new HashMap<Character, String>();
		ArrayList<String> al = new ArrayList<String>();

		for (int i = 0; i < length; i++) {
			if (!hs.containsKey(pattern.charAt(i))) {
				hs.put(pattern.charAt(i), strs[i]);
				if (!al.contains(strs[i])) {
					al.add(strs[i]);
					logger.info("add: "+i+","+pattern.charAt(i)+","+strs[i]);
				} else {
					logger.info("2");
					return false;
				}
			} else if (!hs.get(pattern.charAt(i)).equals(strs[i])) {
				logger.info(i+","+pattern.charAt(i)+","+hs.get(pattern.charAt(i)) + "," + strs[i]);
				logger.info("here");
//				System.out.println(hs.get(pattern.charAt(i)) == strs[i]);
				return false;
			}
		}

		for (char s : hs.keySet()) {
			System.out.println(s + ": " + hs.get(s));
		}

		return true;
	}
}
