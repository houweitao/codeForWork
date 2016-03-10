package hou.leetcode.medium;

import java.util.HashMap;

/**
 * @author houweitao
 * @date 2015年10月30日 下午3:42:09
 */

public class SingleNumberIII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SingleNumberIII sn = new SingleNumberIII();
		int[] nums = { 2, 3, 11, 5, 8, 8, 5, 9 };
		sn.singleNumber(nums);
	}

	int[] singleNumber(int[] nums) {
		HashMap<Integer, Integer> arrayList = new HashMap<Integer, Integer>();

		for (int i = 0; i < nums.length; i++) {
			if (!arrayList.containsKey(nums[i])) {
				arrayList.put(nums[i], 1);
				System.out.println("add "+nums[i]);
			} else {
				arrayList.remove(nums[i]);
				System.out.println("remove "+nums[i]);
			}
		}

		int[] num = new int[arrayList.size()];
		int j = 0;
		for (int tmp : arrayList.keySet()) {
			System.out.println(tmp);
			num[j] = tmp;
			j++;
		}

//		System.out.println(num);
		return num;
	}
}
