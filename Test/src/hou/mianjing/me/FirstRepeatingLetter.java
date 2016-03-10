package hou.mianjing.me;

import java.util.HashMap;
import java.util.Map.Entry;

/**
 * @author houweitao 2015年9月7日 上午9:10:02
 *         http://www.1point3acres.com/bbs/thread-141103-1-1.html
 */

public class FirstRepeatingLetter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FirstRepeatingLetter frl = new FirstRepeatingLetter();
		System.out.println(frl.getFirstRepet("abcba"));
	}

	char getFirstRepet(String s) {

		// hashmap的put是删除原来重新放入！

		HashMap<Character, Integer> LetterList = new HashMap<Character, Integer>();
		for (int i = 0; i < s.length(); i++) {
			if (!LetterList.containsKey(s.charAt(i))) {
				LetterList.put(s.charAt(i), 1);
				System.out.println("put:" + s.charAt(i) + " num ：1");
			} else {
				LetterList.put(s.charAt(i), LetterList.get(s.charAt(i)) + 1);
				System.out.println("put:" + s.charAt(i) + " num " + LetterList.get(s.charAt(i)) + 1);
			}
		}

		for (Entry<Character, Integer> entry : LetterList.entrySet()) {
			// entry.getKey();
			// entry.getValue();

			System.out.println(entry.getKey() + " " + entry.getValue());

			if (entry.getValue() != 1)
				return entry.getKey();
		}
		return '0';
	}
}
