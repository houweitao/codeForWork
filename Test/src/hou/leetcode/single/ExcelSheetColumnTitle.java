package hou.leetcode.single;

/**
 * @author houweitao
 * @date 2015年11月12日 上午10:15:09
 * https://leetcode.com/problems/excel-sheet-column-title/
 * https://leetcode.com/discuss/34526/share-my-java-solusion
 */

public class ExcelSheetColumnTitle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ExcelSheetColumnTitle esct = new ExcelSheetColumnTitle();
		esct.convertToTitle(26);
		for (int i = 0; i < 100; i++)
			esct.convertToTitle(i);
	}

	public String convertToTitle(int n) {
		int bit;
		int tmp = n;
		String result = "";
		while (n > 0) {
			result = (char) ('A' + (n - 1) % 26) + result;
			n = (n - 1) / 26;

//			bit = n % 26;
//			n = n / 26;
//			if (bit != 0) {
//				result = (char) ('A' + bit - 1) + "" + result;
//			} else
//				result = (char) ('A' + 25) + "" + result;
		}

		System.out.println(tmp + "," + result);
		return result;
	}
}
