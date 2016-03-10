package hou.leetcode.single;

/**
 * @author houweitao 2015年8月5日 下午3:26:50
 */

public class MaximumProductSubarray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		MaximumProductSubarray mps = new MaximumProductSubarray();
		
		int nums[] = {1,2,-3,4,5,-9};
		
		mps.maxProduct(nums);
	}

	public int maxProduct(int[] nums) {
		
		int tmp = 1;
		int result=1;
		
		if(nums.length==1)
			return nums[0];
		if(nums[0]==0)
			return 0;
		
		for(int i=0;i<nums.length;i++)
		{
			tmp=tmp*nums[i];
			if(tmp>result)
				result =tmp;
		}
		System.out.println(result);
		return result;
	}
}
