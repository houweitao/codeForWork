package hou.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * @author houweitao
 * @date 2015年12月13日 下午2:44:09
 * https://leetcode.com/problems/3sum/
 */

public class Three3Sum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = { 7,-1,14,-12,-8,7,2,-15,8,8,-8,-14,-4,-5,7,9,11,-4,-15,-6,1,-14,4,3,10,-5,2,1,6,11,2,-2,-5,-7,-6,2,-15,11,-6,8,-4,2,1,-1,4,-6,-15,1,5,-15,10,14,9,-8,-6,4,-6,11,12,-15,7,-1,-9,9,-1,0,-4,-1,-12,-2,14,-9,7,0,-3,-4,1,-2,12,14,-10,0,5,14,-1,14,3,8,10,-8,8,-5,-2,6,-11,12,13,-7,-12,8,6,-13,14,-2,-5,-11,1,3,-6};
		Three3Sum ts = new Three3Sum();
		ts.threeSum2(nums);
	}

	public List<List<Integer>> threeSum(int[] nums) {
		List<List<Integer>> ret = new ArrayList<>();

		for (int i = 0; i < nums.length; i++) {
			HashMap<Integer, Integer> hs = new HashMap<Integer, Integer>();
			for (int j = i + 1; j < nums.length; j++) {
				if (!hs.containsKey(nums[j])) {
					hs.put(-nums[i] - nums[j], j);
				} else {
					List<Integer> list = new ArrayList<>();
					list.add(nums[i]);
					list.add(nums[hs.get(nums[j])]);
					list.add(nums[j]);

					ret.add(list);
				}
			}
		}

		print(ret);
		return ret;
	}

	public List<List<Integer>> threeSum2(int[] nums) {
		List<List<Integer>> ret = new ArrayList<>();
		Arrays.sort(nums);

		for (int i = 0; i < nums.length - 2; i++) {
			int m = i + 1, n = nums.length - 1;

			while (m < n) {
				if (nums[m] + nums[n] > -nums[i]) {
					n--;
				} else if (nums[m] + nums[n] < -nums[i]) {
					m++;
				} else {
					List<Integer> list = new ArrayList<>();
					list.add(nums[i]);
					list.add(nums[m]);
					list.add(nums[n]);

//					System.out.println("add: " + nums[i] + "," + nums[m] + "," + nums[n]);

					ret.add(list);
					
					m++;
					n--;
				}
			}
		}
		print(ret);
		return ret;
	}

	private void print(List<List<Integer>> ret) {
		// TODO Auto-generated method stub
		System.out.println("print result:");
		for (int i = 0; i < ret.size(); i++) {
			for (int j = 0; j < ret.get(i).size(); j++) {
				System.out.print(ret.get(i).get(j) + ",");
			}
			System.out.println();
		}
	}
}
