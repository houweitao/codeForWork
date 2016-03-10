package hou.leetcode.single;

import java.util.ArrayList;
import java.util.List;

/**
 * @author houweitao
 * @date 2015年11月12日 下午3:44:56
 * @end tired..2015年11月12日17:01:13
 */

public class ZigZagConversion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ZigZagConversion zzc = new ZigZagConversion();
		String s = "abcdefghijklmnretgsfsfsdfsdfgdsgsdgdfhsdfh是的";
//		zzc.convert(s, 3);
		zzc.convertList(s, 7);
	}

	public void convertList(String s, int numRows) {
		List<List<String>> list = new ArrayList<>();

		int l = s.length();
		int width = (numRows * 2) - 2;

		for (int i = 0; i < numRows; i++)
			list.add(new ArrayList<String>());

		for (int i = 0; i < s.length(); i++) {
			if (i % width == 0)
				list.get(0).add(s.charAt(i) + "");
			else if (i % width == (numRows - 1))
				list.get(numRows - 1).add(s.charAt(i) + "");
			else {
				int t = i % width;
				if (t < numRows)
					list.get(t).add(s.charAt(i) + "");
				else {
					t = t - numRows + 1;
					list.get(t).add(s.charAt(i) + "");
				}

				System.out.println(i + "," + t + "," + s.charAt(i));
			}
		}

		for (int i = 0; i < list.size(); i++) {
//			System.out.println(i+":");
			for (int j = 0; j < list.get(i).size(); j++) {
				if (i == 0 || i == numRows - 1)
					System.out.print(list.get(i).get(j) + "   ");
				else
					System.out.print(list.get(i).get(j) + " ");
			}
			System.out.println();
		}

	}

	public String convert(String s, int numRows) {
		if (s.length() == 1 || s.length() == 0)
			return s;

		String res = "";
		char[][] help;

		int l = s.length();
		int width = (numRows * 2) - 2;
		int helpLength = 0;
		if (l % width == 0)
			helpLength = l / width;
		else
			helpLength = l / width + 1;
		help = new char[helpLength][width];

		System.out.println(width + "," + helpLength);
		System.out.println(s.charAt(12));

		help[2][1] = 's';

		for (int i = 0; i < s.length(); i++) {
			int m = (i) / width;
			int n = (i) % width;
			System.out.println(i + ": " + m + "," + n + "," + s.charAt(i));
			help[m][n] = s.charAt(i);
//			System.out.println(i + ": " + m + "," + n + "," + s.charAt(i));
		}

//		for (int i = 0; i < helpLength; i++) {
//			for (int j = 0; j < width; j++) {
//				System.out.print(help[i][j]);
//			}
//			System.out.println();
//		}

		for (int i = 0; i < helpLength; i++) {
			if (i == numRows - 1 || i == 0) {
				for (int j = 0; j < numRows; j++) {
					if (help[i][j] != ' ')
						res = res + help[i][j] + "";
				}
			} else {
				for (int j = 0; j < numRows; j++) {
					System.out.println(i + "," + j);

					if (help[i][j] != ' ')
						res = res + help[i][j] + "";

					try {
						if (help[i][j + numRows - 1] != ' ')
							res = res + help[i][j + numRows - 1] + "";
					} catch (Exception e) {
						System.out.println("error: " + res);
					}
				}
			}
		}

		System.out.println(res);

		return res;
	}
}
