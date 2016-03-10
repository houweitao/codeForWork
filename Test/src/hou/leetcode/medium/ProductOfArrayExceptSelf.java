package hou.leetcode.medium;

import java.util.ArrayList;

/**
 * @author houweitao
 * @date 2015年11月11日 下午2:24:54
 * @end 2015年11月11日14:35:15
 * https://leetcode.com/problems/product-of-array-except-self/
 */

public class ProductOfArrayExceptSelf {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ProductOfArrayExceptSelf product = new ProductOfArrayExceptSelf();
		int[] nums={13,2,0,5};
		product.productExceptSelf2(nums);
		
	}

	public int[] productExceptSelf(int[] nums) {
		int[] product = new int[nums.length];
		int all = 1;
		ArrayList<Integer> zeroList = new ArrayList<Integer>();

		for (int i = 0; i < nums.length; i++) {
			if (nums[i] != 0)
				all = all * nums[i];
			else {
				zeroList.add(i);
			}
		}

		if (zeroList.size() > 1)
			return product;
		else if (zeroList.size() == 1) {
			product[zeroList.get(0)] = all;
		} else {

			for (int i = 0; i < nums.length; i++)
				if (!zeroList.contains(i))
					product[i] = all / nums[i];
			return product;
		}
		return product;
	}

	int[] productExceptSelf2(int[] nums) {
		int[] result = new int[nums.length];
		for (int i = 0, tmp = 1; i < nums.length; i++) {
			result[i] = tmp;
			tmp *= nums[i];

			System.out.print(result[i] + ",");
		}
		System.out.println();
		for (int i = nums.length - 1, tmp = 1; i >= 0; i--) {
			result[i] *= tmp;
			tmp *= nums[i];
			System.out.print(result[i] + ",");
		}
		System.out.println();
		return result;
	}
}
