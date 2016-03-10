package hou.mianjing.me;

/**
 * @author houweitao
 * @date 2016年2月25日 上午10:02:57
 * @end 2016年2月25日10:14:31
 * http://www.1point3acres.com/bbs/thread-173260-1-1.html
 * 一个数组长度为n+1： 1 2 3 4 .... m, m, m+1, m+2, ......n
 * 注意每个数都在[1 - n], 已排序，求出现了两次的那个数，也就是m。
 */

public class FindTwiceNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums={1,2,3,4,4,5,6,7,8,};
		FindTwiceNumber ftn=new FindTwiceNumber();
		System.out.println(ftn.twiceNumber(nums));
	}

	int twiceNumber(int[] nums) {
		if (nums == null || nums.length == 0 || nums.length == 1)
			return -1;
		else {
			int begin = 0, end = nums.length - 1;
			while (begin <= end) {
				int mid = (begin + end) / 2;
				if (nums[mid] == (mid + 1)) {
					if (nums[mid + 1] == nums[mid])
						return nums[mid];
					else {
						begin = mid + 1;
					}
				} else {
					if (nums[mid - 1] == nums[mid])
						return nums[mid];
					else
						end = begin - 1;
				}
			}
			
			return -1;
			
		}
	}

}
