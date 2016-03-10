package hou.leetcode.medium;

/**
 * @author houweitao
 * @date 2015年11月3日 下午3:02:35
 * https://leetcode.com/problems/longest-increasing-subsequence/ 
 * not finish
 */

public class LongestIncreasingSubsequence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = { 10, 9, 2, 5, 3, 7, 101, 4 };
		LongestIncreasingSubsequence lis = new LongestIncreasingSubsequence();
		lis.lengthOfLIS(nums);
		lis.lengthOfLIS2(nums);
		lis.lengthOfLIS3(nums);
		lis.lengthOfLISMe(nums);
	}

	public int lengthOfLIS(int[] nums) {
		int len = 1;
		int lenTmp = 1;
		int now = nums[0];

		for (int i = 1; i < nums.length; i++) {
			if (nums[i] > now) {
				lenTmp++;
				now = nums[i];
			} else {
				if (lenTmp > len)
					len = lenTmp;
				lenTmp = 1;
				now = nums[i];
			}
		}
		System.out.println(len);
		return len;
	}

	// csdn http://blog.csdn.net/foreverling/article/details/49620349

	/*
	 * 动态规划+二分搜索O(nlgn)。 用一个附加数组保存递增序列的尾元素，依次遍历原数组中的元素，将其插入到附加数组中的正确位置，
	 * 若插入最后一个元素之后，则更新最长递增子序列的长度。
	 */
	int lengthOfLIS2(int[] nums) {
		if (nums.length == 0) {
			return 0;
		}
		int tail[] = new int[nums.length];
		tail[0] = nums[0];
		int len = 1;
		for (int i = 0; i < nums.length; i++) {
			int left = 0;
			int right = len - 1;
			while (left <= right) {
				int mid = (left + right) / 2;
				if (tail[mid] < nums[i]) {
					left = mid + 1;
				} else {
					right = mid - 1;
				}
			}
			tail[left] = nums[i];
			if (left == len) {
				++len;
			}

			for (int ii = 0; ii < nums.length; ii++)
				System.out.print(tail[ii] + " ");
			System.out.println();
		}

		for (int i = 0; i < nums.length; i++)
			System.out.println(tail[i]);
		System.out.println(len);
		return len;
	}

	// https://leetcode.com/discuss/67572/o-nlogn-and-o-n-2-java-solutions

	public int lengthOfLIS3(int[] nums) {
		if (nums.length == 0)
			return 0;
		int len = 0, N = nums.length;
		int[] tailTable = new int[N];
		tailTable[len++] = nums[0];
		for (int i = 1; i < N; i++) {
			if (nums[i] < tailTable[0])
				tailTable[0] = nums[i];
			else if (nums[i] > tailTable[len - 1])
				tailTable[len++] = nums[i];
			else {
				tailTable[binarySearch(tailTable, 0, len - 1, nums[i])] = nums[i];
			}

			for (int ii = 0; ii < nums.length; ii++)
				System.out.print(tailTable[ii] + ",");
			System.out.println();
		}
		System.out.println(len);
		return len;
	}

	private int binarySearch(int[] tails, int start, int end, int target) {
		while (start < end) {
			int mid = start + (end - start) / 2;
			if (tails[mid] >= target)
				end = mid;
			else
				start = mid + 1;
		}
		return end;
	}

	public int lengthOfLISMe(int[] nums) {
		if (nums.length == 0)
			return 0;

		int len = 0;
		int[] tail = new int[nums.length];
		tail[0] = nums[0];
		len++;

		boolean changed = false;
		int[] result = null;
		for (int i = 1; i < nums.length; i++) {
			
			System.out.println(changed);
			
			if (tail[0] > nums[i])
				tail[0] = nums[i];
			else if (tail[len - 1] < nums[i]) {
				tail[len] = nums[i];
				len++;

//				if (!changed) {
//					result = tail;
//				}

//				System.out.println("me:"+len+","+nums[i]);
			} else {
				int change = bSearch(tail, 0, len - 1, nums[i]);

				if (change == len - 1)
					changed = false;
				else
					changed = true;
				
				tail[change] = nums[i];
			}

			for (int ii = 0; ii < nums.length; ii++)
				System.out.print(tail[ii] + ",");
			System.out.println();
		}
		System.out.println("me:" + len);
		
//		for(int j=0;j<result.length;j++)
//			System.out.print(result[j] + ", ");
		return len;

	}

	private int bSearch(int[] tail, int begin, int end, int target) {
		// TODO Auto-generated method stub
		while (begin < end) {
			int mid = (begin + end) / 2;
			if (tail[mid] >= target)
				end = mid;
			else
				begin = mid + 1;
		}
		return end;
	}
}
