package hou.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * @author houweitao
 * @date 2015年12月7日 上午1:43:09
 * @end 2015年12月7日02:17:07
 * beautiful
 * https://leetcode.com/problems/generate-parentheses/
 */

public class GenerateParentheses {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GenerateParentheses gp = new GenerateParentheses();
		List<String> ret = gp.generateParenthesis(4);
		gp.print(ret);

//		gp.print(gp.help(3, 3));
	}

	private void print(List<String> ret) {
		// TODO Auto-generated method stub
		for (int i = 0; i < ret.size(); i++)
			System.out.println(ret.get(i));
	}

	public List<String> generateParenthesis(int n) {
		return help(n, n);
	}

	private List<String> help(int a, int b) {
		List<String> ret = new ArrayList<String>();
		if (a == 0 && b == 0)
			return null;
		else if (b == 0) {
			ret.add("");
			return ret;
		} else if (a == 0) { 
			//就因为这个地方没写对。。粗心了。一开始没用add变量，而是一直添加“)”。坑爹！
			String add = "";
			for (int i = 0; i < b; i++)
				add = add + ")";
			ret.add(add);
			return ret;
		} else {
			//一次只解决一个问题，只缩小一次就可以了。剩下的让接下来的程序去做。
			//这里，要么出( ，要么出) ，只是判断2个能出吗？能出就出。
			
			if (a > 0) {
				List<String> next = help(a - 1, b);
				if (next.size() != 0) {
					for (int i = 0; i < next.size(); i++)
						ret.add("(" + next.get(i));
				}
			}

			if (b > a) {
				List<String> next = help(a, b - 1);
				if (next.size() != 0) {
					for (int i = 0; i < next.size(); i++)
						ret.add(")" + next.get(i));
				}
			}
		}

		return ret;
	}
}
