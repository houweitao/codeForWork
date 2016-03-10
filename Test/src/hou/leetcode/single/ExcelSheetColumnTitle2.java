package hou.leetcode.single;

/**
 * @author houweitao
 * @date 2015年12月30日 上午9:51:38
 * @source https://leetcode.com/problems/excel-sheet-column-title/
 * @gui... 2015年12月30日10:15:39
 * @success 2015年12月30日10:30:59
 */

public class ExcelSheetColumnTitle2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ExcelSheetColumnTitle2 title = new ExcelSheetColumnTitle2();

		for (int i = 0; i < 1000; i++)
			System.out.println(i + ": " + title.convertToTitle(i));
	}

	public String convertToTitle(int n) {
		String ret = "";
		while (n > 26) {
			int mo = n % 26;
			char tmp;
			if (mo != 0)
				tmp = (char) (n % 26 + 'A' - 1);
			else
				tmp = 'Z';
			ret = tmp + ret;
			n = (n - 1) / 26;
		}
		ret = (char) (n + 'A' - 1) + ret;
		return ret;
	}
}
