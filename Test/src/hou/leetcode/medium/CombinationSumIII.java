package hou.leetcode.medium;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author houweitao
 * @date 2015年12月9日 上午12:41:59
 * https://leetcode.com/problems/combination-sum-iii/
 */

public class CombinationSumIII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CombinationSumIII cs = new CombinationSumIII();
		List<List<Integer>> ret = cs.combinationSumDP(3, 9);
		cs.print(ret);
	}

	public List<List<Integer>> combinationSumDP(int k, int n) {
		List<List<Integer>> ret = new ArrayList<List<Integer>>();

		if (k == 0 || n < 1)
			return ret;
		else if (k == 1) {
			if (n <= 1 || n > 9)
				return ret;
			else {
				List<Integer> tmp = new ArrayList<>();
				tmp.add(n);
				ret.add(tmp);
				return ret;
			}
		} else {
			Stack<Integer> stack = new Stack<>();
			int pos = 0;
			int target = n - 1;
			stack.push(1);
			pos = stack.peek();
			while (!stack.isEmpty()) {
//				pos = stack.peek();
//				System.out.println("赋值");
				System.out.println("pos: " + pos);

				if (pos == 9) {
					if (target == 9)
						System.out.println("find~~~");
					else
						stack.pop();
				}

				if (9 - pos >= k - stack.size() + 1) {
					for (int i = pos + 1; i <= 9; i++) {
						stack.push(i);
						System.out.println("push " + i + ". size: " + stack.size());
						pos++;
						target = target - i;
						if (stack.size() == k) {
							if (stack.peek() == target) {
								System.out.println("find!!");
								stack.pop();
								target = target + i;
								pos++;
							} else {
								stack.pop();
								target = target + i;
								break;
							}
						} else {
//							stack.pop();
							break;
						}
					}
				} else {
					stack.pop();
				}
			}
			return ret;
		}

	}

	public List<List<Integer>> combinationSum3(int k, int n) {
		return help(k, n, 0);
	}

	public List<List<Integer>> help(int k, int n, int last) {
		List<List<Integer>> ret = new ArrayList<List<Integer>>();

		if (k == 0 || n < 1)
			return ret;
		else if (k == 1) {
			if (n <= last || n > 9)
				return ret;
			else {
				List<Integer> tmp = new ArrayList<>();
				tmp.add(n);
				ret.add(tmp);
				return ret;
			}
		} else {
			for (int i = last + 1; i < n / k + 1; i++) {
				List<List<Integer>> next = help(k - 1, n - i, i);

				for (int j = 0; j < next.size(); j++) {
					List<Integer> tmp = new ArrayList<>();
					tmp.add(i);
					tmp.addAll(next.get(j));
					ret.add(tmp);
				}
			}

			return ret;
		}
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
