package hou.leetcode.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * @author houweitao
 * @date 2015年12月31日 上午9:37:18
 * @end 2015年12月31日10:52:01
 * https://leetcode.com/problems/permutations-ii/
 * 一波三折啊..
 */

public class PermutationsII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PermutationsII per = new PermutationsII();
		int[] nums = { 1, 1, 1, 2 };
//		System.out.println(per.makeNew(nums, 0));

		List<List<Integer>> ret = per.permuteUnique(nums);
		per.printList(ret);
	}

	public List<List<Integer>> permuteUnique(int[] nums) {
		List<List<Integer>> ret = new LinkedList<>();
		if (nums.length == 1) {
			List<Integer> tmp = new LinkedList<>();
			tmp.add(nums[0]);
			ret.add(tmp);
			return ret;
		} else {
			ArrayList<int[]> space = new ArrayList<>();

			for (int i = 0; i < nums.length; i++) {
				int[] newArray = makeNew(nums, i);

//				System.out.println("newArray: " + printNum(newArray));

				if (!in(space, newArray)) {
//					System.out.println("不在解空间！加入！  " + printNum(newArray));
					space.add(newArray);
					List<List<Integer>> next = permuteUnique(newArray);
					for (int k = 0; k < next.size(); k++) {
						List<Integer> tmp = new LinkedList<>();
						tmp.addAll(next.get(k));
						tmp.add(nums[i]);
						ret.add(tmp);
					}
				}
			}
			return ret;
		}
	}

	private boolean in(ArrayList<int[]> space, int[] newArray) {
		// TODO Auto-generated method stub
		for (int i = 0; i < space.size(); i++) {
			if (compareArray(space.get(i), newArray)) {
				return true;
			}
		}
		return false;
	}

	private boolean compareArray(int[] a, int[] b) {
		if (a.length != b.length)
			return false;
		else {
			return deal(a, b);
		}
	}

	private boolean deal(int[] a, int[] b) {
		HashMap<Integer, Integer> hm = new HashMap<>();

		for (int i = 0; i < a.length; i++) {
			if (!hm.containsKey(a[i])) {
				hm.put(a[i], 1);
			} else {
				hm.put(a[i], hm.get(a[i]) + 1);
			}
		}

		for (int i = 0; i < b.length; i++) {
			if (hm.containsKey(b[i])) {
				if (hm.get(b[i]) == 1)
					hm.remove(b[i]);
				else
					hm.put(b[i], hm.get(b[i]) - 1);
			} else {
				return false;
			}
		}

		if (hm.size() == 0)
			return true;
		else
			return false;

	}

	//第I个元素和最后一个元素进行交换
	private int[] makeNew(int[] nums, int pos) {
		int[] ret = new int[nums.length - 1];
		for (int i = 0; i < nums.length - 1; i++) {
			if (i == pos)
				ret[i] = nums[nums.length - 1];
			else
				ret[i] = nums[i];
		}
		return ret;
	}

	private void printList(List<List<Integer>> ret) {
		for (int i = 0; i < ret.size(); i++) {
			for (int j = 0; j < ret.get(i).size(); j++) {
				System.out.print(ret.get(i).get(j) + ",");
			}
			System.out.println();
		}
	}

	private String printNum(int[] ret) {
		String str = "";
		for (int i = 0; i < ret.length; i++) {
//			System.out.print(ret[i] + ",");
			str = str + ret[i];
		}

		return str;
	}
}
