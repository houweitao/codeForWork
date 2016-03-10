package hou.lintcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * @author houweitao
 * @date 2016年1月22日 上午10:36:57
 * @end 2016年1月22日10:55:57
 * http://codingmelon.com/2016/01/20/largest-number-lintcode-184/
 */

public class LargestNumber {

	public static void main(String[] args) {
		int[] nums = { 1, 20, 23, 4, 8 };
		LargestNumber ln = new LargestNumber();
		ln.largestNumber(nums);//输出了最小。不过没关系。倒叙就可以了。
	}

	String largestNumber(int[] nums) {
		ArrayList<String> list = new ArrayList<>();
		for (int i = 0; i < nums.length; i++)
			list.add(nums[i] + "");
		Collections.sort(list, new NumComparator());

		String ret = "";
		for (String s : list)
			ret = ret + s;

		System.out.println(ret);
		return ret;
	}

}

class NumComparator implements Comparator<String> {
	@Override
	public int compare(String a, String b) {
		if (big(a, b)) {
			return 1;
		} else
			return 0;
	}

	private boolean big(String a, String b) {
		// TODO Auto-generated method stub
		if (a == null)
			return false;
		else if (b == null)
			return true;
		else {
			if (a.charAt(0) > b.charAt(0))
				return true;
			else if (a.charAt(0) < b.charAt(0))
				return false;
			else
				return big(a.substring(1), b.substring(1));
		}
	}

}