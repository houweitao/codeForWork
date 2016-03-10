package hou.leetcode.medium;

import java.util.LinkedList;

/**
 * @author houweitao
 * @date 2015年12月14日 下午1:14:51
 * @bad 2015年12月14日13:58:30
 * https://leetcode.com/problems/remove-duplicate-letters/
 */

public class RemoveDuplicateLetters {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "bcabc";
		RemoveDuplicateLetters removeDuplicateLetters = new RemoveDuplicateLetters();
		System.out.println(removeDuplicateLetters.removeDuplicateLetters(s));
	}

	public String removeDuplicateLetters(String s) {
		if (s.length() < 0)
			return "";
		else {
			LinkedList<Character> list = new LinkedList<>();
			for (int i = 0; i < s.length(); i++) {
				System.out.println(i);

				if (!list.contains(s.charAt(i))) {
					list.add(s.charAt(i));
				} else {
					boolean after = false;
					int mark = -1;
					for (int j = 0; j < list.size(); j++) {
						if (after) {
							System.out.println(list.get(j) + " - " + s.charAt(i) + " = " + (list.get(j) - s.charAt(i)));

							if (list.get(j) - s.charAt(i) < 0) {
								list.remove(mark);
								list.add(s.charAt(i));
								j--;
								break;
							}
						} else {
							if (list.get(j) - s.charAt(i) == 0) {
								after = true;
								mark = j;
							}
						}
					}
				}
				print(list);
			}

			String ret = "";
			for (int i = 0; i < list.size(); i++)
				ret = ret + list.get(i);
			return ret;
		}
	}

	private void print(LinkedList<Character> list) {
		// TODO Auto-generated method stub
		for (int i = 0; i < list.size(); i++)
			System.out.print(list.get(i) + ",");
		System.out.println();
	}
}
