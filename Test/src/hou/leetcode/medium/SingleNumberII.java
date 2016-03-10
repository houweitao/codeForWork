package hou.leetcode.medium;

import java.util.HashMap;

/**
 * @author houweitao
 * @date 2015年11月13日 上午9:59:31
 * @end 2015年11月13日10:18:18
 * https://leetcode.com/problems/single-number-ii/
 */

public class SingleNumberII {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums={1,2,3,4,5,1,2,3,4,5,1,5,2,3,4,5};
		SingleNumberII sn=new SingleNumberII();
		System.out.println(sn.singleNumber(nums));
		sn.singleNumber2(nums);
	}
	
	//https://leetcode.com/discuss/6632/challenge-me-thx
	public int singleNumber2(int[] A) {
	    int ones = 0, twos = 0;
	    for(int i = 0; i < A.length; i++){
	        ones = (ones ^ A[i]) & ~twos;
	        twos = (twos ^ A[i]) & ~ones;
	        
	        System.out.println(i+": "+ones+","+twos);
	    }
	    return ones;
	}

	public int singleNumber(int[] nums) {
		HashMap<Integer, Integer> record = new HashMap<>();
		HashMap<Integer, Boolean> help = new HashMap<>();
		int r = 0;

		for (int i = 0; i < nums.length; i++) {
			boolean a=record.containsKey(nums[i]);
			boolean b=help.containsKey(nums[i]);
			
			if (!a && !b)
				record.put(nums[i], 1);
			else if (a && !b) {
				if (record.get(nums[i]) == 2) {
					help.put(nums[i], true);
					record.remove(nums[i]);
				} else
					record.put(nums[i], record.get(nums[i]) + 1);
			} else if (!a && b) {
				return nums[i];
			}
		}

		if (record.size() != 0) {
			for (Integer res : record.keySet())
				return res;
		}
		return r;
	}
}
