package hou.leetcode.medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author houweitao
 * @date 2016年2月26日 上午11:21:36
 * @end 2016年2月26日13:13:28
 * 要学会举一反三啊！还有一个方法是我之前的，也是递归。不过比这个笨很多，是左右记录括号数目。
 * https://leetcode.com/problems/different-ways-to-add-parentheses/
 */

public class DifferentWaysToAddParentheses {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String input = "2*3-4*5-8";
		DifferentWaysToAddParentheses dt = new DifferentWaysToAddParentheses();
		System.out.println(dt.diffWaysToCompute(input));
		System.out.println(dt.diffWaysToShow(input));
	}

	public List<Integer> diffWaysToCompute(String input) {
		List<Integer> ret = new LinkedList<>();
		ArrayList<CharPosPair> sign = new ArrayList<>();
		for (int i = 0; i < input.length(); i++) {
			char c = input.charAt(i);
			if (c == '+' || c == '-' || c == '*')
				sign.add(new CharPosPair(c, i));
		}

		if (sign.size() == 0) {
			ret.add(Integer.valueOf(input));
			return ret;
		} else if (sign.size() == 1) {
//			String[] nums = input.split(sign.get(0).c + "");
			int left = string2Int(input.substring(0, sign.get(0).pos));
			int right = string2Int(input.substring(sign.get(0).pos + 1));

			char c = sign.get(0).c;

			int retNum = -1;
			if (c == '+')
				retNum = left + right;
			else if (c == '-')
				retNum = left - right;
			else
				retNum = left * right;
			ret.add(retNum);
		} else {
			for (CharPosPair cpp : sign) {
				char c = cpp.c;
				int pos = cpp.pos;

				String left = input.substring(0, pos);
				String right = input.substring(pos + 1);

				List<Integer> leftResult = diffWaysToCompute(left);
				List<Integer> rightResult = diffWaysToCompute(right);

				int retNum = -1;
				for (Integer l : leftResult) {
					for (Integer r : rightResult) {
						if (c == '+')
							retNum = l + r;
						else if (c == '-')
							retNum = l - r;
						else
							retNum = l * r;
						ret.add(retNum);
					}
				}
			}
		}
		return ret;
	}

	int string2Int(String s) {
		return Integer.valueOf(s);
	}

	public List<String> diffWaysToShow(String input) {
		List<String> ret = new LinkedList<>();
		ArrayList<CharPosPair> sign = new ArrayList<>();
		for (int i = 0; i < input.length(); i++) {
			char c = input.charAt(i);
			if (c == '+' || c == '-' || c == '*')
				sign.add(new CharPosPair(c, i));
		}

		if (sign.size() == 0) {
			ret.add(input);
			return ret;
		} else if (sign.size() == 1) {
			ret.add("(" + input + ")");
			return ret;
		} else {
			for (CharPosPair cpp : sign) {
				char c = cpp.c;
				int pos = cpp.pos;

				String left = input.substring(0, pos);
				String right = input.substring(pos + 1);

				List<String> leftResult = diffWaysToShow(left);
				List<String> rightResult = diffWaysToShow(right);

				for (String l : leftResult) {
					for (String r : rightResult) {
						ret.add("("+l +c+ r+")");
					}
				}
			}
		}
		return ret;
	}

	private class CharPosPair {
		char c;
		int pos;

		CharPosPair(char c, int pos) {
			this.c = c;
			this.pos = pos;
		}
	}
}
