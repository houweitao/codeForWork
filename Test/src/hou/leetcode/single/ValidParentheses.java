package hou.leetcode.single;

import java.util.Stack;

/**
 * @author houweitao
 * @date 2015年11月12日 上午11:17:22
 * @end 2015年11月12日11:36:33
 * https://leetcode.com/problems/valid-parentheses/
 */

public class ValidParentheses {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		System.out.println('{' - '}');
		String s = "([]{})";
		ValidParentheses vp = new ValidParentheses();
		System.out.println(vp.isValid(s));
	}

	public boolean isValid(String s) {
		// '(', ')', '{', '}', '[' and ']'
		Stack<Character> a = new Stack<>();
		Stack<Character> b = new Stack<>();

		for (int i = 0; i < s.length(); i++) {
			a.push(s.charAt(i));
		}

		while (!a.isEmpty()) {
			if (!b.isEmpty()) {
				char left = a.peek();
				char right = b.peek();

				if (Math.abs(left - right) == 1 || Math.abs(left - right) == 2) {
					a.pop();
					b.pop();
				} else {
					b.push(a.peek());
					a.pop();
				}
			} else {
				b.push(a.peek());
				a.pop();
			}
		}

		if (b.isEmpty())
			return true;
		else
			return false;
	}
}
