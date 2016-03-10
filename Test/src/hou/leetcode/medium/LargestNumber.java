package hou.leetcode.medium;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author houweitao
 * @date 2015年11月17日 上午10:29:41
 * https://leetcode.com/problems/largest-number/
 * 關於比較：http://www.programcreek.com/2011/12/examples-to-demonstrate-comparable-vs-comparator-in-java/
 */

public class LargestNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = { 3, 30, 34, 5, 9 };
		System.out.println("123".compareTo("213"));
		
	}
	
	//https://leetcode.com/discuss/23422/my-java-solution-to-share
	//另一个也不错：https://leetcode.com/discuss/21587/simple-solution-with-java-o-nlogn-and-no-need-for-biginteger
	public String largestNumber(int[] num) {
		if (num == null || num.length == 0)
			return "";
		String[] Snum = new String[num.length];
		for (int i = 0; i < num.length; i++)
			Snum[i] = num[i] + "";

		Comparator<String> comp = new Comparator<String>() {
			@Override
			public int compare(String str1, String str2) {
				String s1 = str1 + str2;
				String s2 = str2 + str1;
				return s1.compareTo(s2);
			}
		};

		Arrays.sort(Snum, comp);
		if (Snum[Snum.length - 1].charAt(0) == '0')
			return "0";

		StringBuilder sb = new StringBuilder();

		for (String s : Snum)
			sb.insert(0, s);

		return sb.toString();

	}

//	public String largestNumber(int[] nums) {
//		HashMap<Integer, Integer> hm = new HashMap<>();
//		for (int i = 0; i < nums.length; i++) {
//			int first = Integer.valueOf(String.valueOf(nums[i]).indexOf(0)+"");
//			Arrays.s
//		}
//
//		return "";
//	}
}
