package hou.leetcode.single;

/**
 * @author houweitao
 * @date 2015年10月30日 上午11:59:31
 * https://leetcode.com/problems/remove-element/
 * https://leetcode.com/discuss/3753/my-solution-for-your-reference
 */
//很巧妙的方法..见过好几次了 要记住！

public class RemoveElement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A = { 1, 2, 3, 4, 5, 6, 1, 2, 3, 4 };
		int val = 2;
		RemoveElement re = new RemoveElement();
		re.removeElement(A, val);
	}

//	later re do
//	2015年11月17日15:23:56
	int removeElementLater(int[] nums, int a) {
		int j = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] != a) {
				nums[j] = nums[i];
				j++;
			}
		}
		return j;
	}

//	before methods..
	int removeElement(int A[], int elem) {
		int begin = 0;
		int n = A.length;
		for (int i = 0; i < n; i++)
			if (A[i] != elem)
				A[begin++] = A[i];
		System.out.println(begin);
		return begin;
	}
}
