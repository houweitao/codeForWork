package hou.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * @author houweitao
 * @date 2015年11月16日 下午1:43:11
 * @end 2015年11月16日14:20:09
 * happiness!!
 * https://leetcode.com/problems/permutations/
 */

public class Permutations {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Permutations p = new Permutations();
		int[] nums = { 1, 2, 3, 4, 5, 6, 7 };
		List<List<Integer>> out = p.permute(nums);
		for (int i = 0; i < out.size(); i++) {
			for (int j = 0; j < out.get(i).size(); j++)
				System.out.print(out.get(i).get(j) + ",");
			System.out.println();
		}
	}

	public List<List<Integer>> permute(int[] nums) {
		List<Integer> ret = new ArrayList<Integer>();
		List<List<Integer>> retFinal = new ArrayList<List<Integer>>();
		if (nums.length == 0)
			return null;
		else if (nums.length == 1) {
			ret.add(nums[0]);
			retFinal.add(ret);
			return retFinal;
		} else if (nums.length == 2) {
			ret.add(nums[0]);
			ret.add(nums[1]);
			retFinal.add(ret);
			List<Integer> ret2 = new ArrayList<Integer>();
			ret2.add(nums[1]);
			ret2.add(nums[0]);
			retFinal.add(ret2);
		} else {
			List<List<Integer>> tmp = null;
			//关键点
			for (int i = 0; i < nums.length; i++) { 
				tmp = permute(buildNums(nums, i));
				for (int j = 0; j < tmp.size(); j++) {
					tmp.get(j).add(nums[i]);
					retFinal.add(tmp.get(j));//here
				}
			}
//			retFinal = tmp;
		}
		return retFinal;

	}

	int[] buildNums(int[] nums, int pos) {
		int[] n = new int[nums.length - 1];
		int j = 0;
		for (int i = 0; i < n.length; i++) {
			if (j != pos)
				n[i] = nums[j];
			else
				n[i] = nums[++j];
			j++;
		}
		return n;
	}
}
