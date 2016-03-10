package hou.leetcode.single;

import java.util.Hashtable;

/**
 * @author houweitao 2015年7月15日 下午4:00:35
 * http://blog.csdn.net/baidu_22502417/article/details/46876091
 */

public class HappyNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		HappyNumber hn = new HappyNumber();

		System.out.println(hn.isHappy(19));
	}

	public boolean isHappy(int n) {
		boolean happyNum = false;
		Hashtable<Integer, Boolean> badNumDic = new Hashtable<Integer, Boolean>();
		int sum = 0;
		while (!happyNum) {
			sum = 0;
			while (n > 0) {
				sum += (n % 10) * (n % 10);
				n = n / 10;
			}
			System.out.println(sum);
			if (sum != 1) {
				if (badNumDic.containsKey(sum))
					break;
				badNumDic.put(sum, false);
			} else {
				happyNum = true;
			}
			n = sum;
		}
		
		System.out.println(badNumDic.containsKey(82));
		return happyNum;
	}
}
