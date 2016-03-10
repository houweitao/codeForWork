package hou.leetcode.medium;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author houweitao
 * @date 2015年12月9日 上午9:45:10
 * https://leetcode.com/problems/combination-sum-iii/
 * https://leetcode.com/discuss/62421/simple-and-clean-java-code-backtracking
 */

public class CombinationSumIII2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CombinationSumIII2 cs = new CombinationSumIII2();
		cs.combinationSum3(3, 10);
	}

	public List<List<Integer>> combinationSum3(int k, int n) {
		List<List<Integer>> ret = new ArrayList<>();

		help(ret, new ArrayList<Integer>(), k, 0, n);
		System.out.println(ret.size());
		print(ret);
		return ret;
	}

	//这里跟之前用到的回溯不太一样，。之前都是用个栈，然后当栈非空，进行一些列操作。
	private void help(List<List<Integer>> ret, ArrayList<Integer> arrayList, int k, int start, int n) {
		// TODO Auto-generated method stub
		ArrayList<Integer> tmp = new ArrayList<>(arrayList);

		if (k == 0 && n == 0) {
			ret.add(tmp);
			System.out.println("add..");
//			return;
		} else {

			for (int i = start + 1; i <= 9; i++) {
				arrayList.add(i);
				help(ret, arrayList, k - 1, i, n - i);
				arrayList.remove(arrayList.size() - 1);
			}
		}
	}

	public List<List<Integer>> combinationSum3Me(int k, int n) {
		List<List<Integer>> ret = new ArrayList<>();
		int i = 1;
		Stack<Integer> stack = new Stack<>();
		while (i > 9 && stack.isEmpty()) {
			if (i <= 9) {
				stack.push(i);

				n = n - i;
				if (stack.size() == --k) {
					if (i == n)
						System.out.println("find");
					else {
						stack.pop();
						n = n + i;
						k++;
						int now = stack.pop() + 1;
						i = now + 1;
						stack.push(now + 1);
					}
				} else {
					i++;
				}

			} else {
				int now = stack.pop() + 1;
				i = now + 1;
				stack.push(now + 1);
			}
		}

		print(ret);
		return ret;
	}

	private void print(List<List<Integer>> ret) {
		// TODO Auto-generated method stub
		for (int i = 0; i < ret.size(); i++) {
			for (int j = 0; j < ret.get(i).size(); j++) {
				System.out.print(ret.get(i).get(j) + ",");
			}
			System.out.println();
		}
	}
}
