package hou.leetcode.single;

import java.util.ArrayList;

/**
 * @author houweitao
 * @date 2015年12月14日 上午12:25:18
 */

public class RangeSumQuery2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = { -2, 0, 3, -5, 2, -1 };
		NumArray2 na = new NumArray2(nums);
		System.out.println(na.sumRange(0, 2));
		System.out.println(na.sumRange(2, 5));
	}

}

class NumArray2 {

	ArrayList<Integer> list = new ArrayList<>();

	public NumArray2(int[] nums) {
		if (nums.length > 0) {
			list.add(nums[0]);
			for (int i = 1; i < nums.length; i++) {
				list.add(list.get(i - 1) + nums[i]);
			}

			for (int i = 0; i < list.size(); i++) {
				System.out.println(i + ", " + list.get(i));
			}

		}
	}

	public int sumRange(int i, int j) {
		if (i > 0)
			return (list.get(j) - list.get(i - 1));
		else
			return list.get(j);
	}
}
