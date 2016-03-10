package hou.leetcode.single;

/**
 * @author houweitao
 * @date 2015年12月30日 下午2:18:38
 * @end 2015年12月30日14:48:16
 * 不知道这个题目想干嘛。
 * https://leetcode.com/problems/compare-version-numbers/
 */

public class CompareVersionNumbers2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CompareVersionNumbers2 version = new CompareVersionNumbers2();
		System.out.println(version.compareVersion("1.0", "1.10"));
	}

	public int compareVersion(String version1, String version2) {
		version1 = version1 + ".0";
		version2 = version2 + ".0";

		String[] v1 = version1.split("\\.");
		String[] v2 = version2.split("\\.");

		int first = compareInt(Integer.valueOf(v1[0]), Integer.valueOf(v2[0]));
		if (first == 0) {
			return compareXiaoshu(v1[1], v2[1]) * (-1);
		} else {
			return first;
		}
	}

	int compareInt(int a, int b) {
		if (a > b)
			return 1;
		else if (a == b)
			return 0;
		else
			return -1;
	}

	int compareXiaoshu(String a, String b) {
		int len = Math.min(a.length(), b.length());

		for (int i = 0; i < len; i++) {
			if (a.charAt(i) - b.charAt(i) > 0)
				return 1;
			else if (a.charAt(i) - b.charAt(i) < 0)
				return -1;
		}

		if (a.length() > len)
			return 1;
		if (b.length() > len)
			return -1;

		return 0;
	}
}
