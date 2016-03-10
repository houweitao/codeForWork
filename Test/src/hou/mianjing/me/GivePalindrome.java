package hou.mianjing.me;

import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Stack;

/**
 * @author houweitao
 * @date 2015年12月6日 下午2:00:36
 * http://www.1point3acres.com/bbs/thread-156529-1-1.html
 */

public class GivePalindrome {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "accbbbad";
		GivePalindrome gp = new GivePalindrome();
		gp.give(str);
	}

	void give(String str) {
		HashMap<Character, Integer> freq = new HashMap<Character, Integer>();
		for (int i = 0; i < str.length(); i++) {
			if (!freq.containsKey(str.charAt(i)))
				freq.put(str.charAt(i), 1);
			else
				freq.put(str.charAt(i), freq.get(str.charAt(i)) + 1);
		}

		HashMap<Character, Integer> help = new HashMap<Character, Integer>();
		Character tmp = '0';
		int max = Integer.MIN_VALUE;
		for (Entry<Character, Integer> entry : freq.entrySet()) {
			if (entry.getValue() % 2 == 0)
				help.put(entry.getKey(), entry.getValue());
			else {
				if (entry.getValue() > max) {
					tmp = entry.getKey();
					max = entry.getValue();
				}
			}
		}

		help.put(tmp, max);
		Stack<Character> stack = new Stack<Character>();
		Stack<Character> middle = new Stack<Character>();

		String Palindrome = "";
		for (Entry<Character, Integer> entry : help.entrySet()) {
			if (entry.getValue() % 2 == 0) {
				Palindrome = Palindrome + entry.getKey();
				stack.push(entry.getKey());
			} else {
				for (int i = 0; i < entry.getValue(); i++)
					middle.push(entry.getKey());
			}
		}

		while (!middle.isEmpty()) {
			Palindrome = Palindrome + middle.pop();
		}
		while (!stack.isEmpty()) {
			Palindrome = Palindrome + stack.pop();
		}

		System.out.println(Palindrome);
	}
}
