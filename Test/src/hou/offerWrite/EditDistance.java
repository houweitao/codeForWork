package hou.offerWrite;

/**
 * @author houweitao
 * @date 2016年3月9日 下午3:15:31
 * @end 2016年3月9日15:28:47
 * http://www.guolanzhe.com/?p=363
 * 相当于最长公共子序列了。LCS
 */

public class EditDistance {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String left = "xyxxzxyzxy";
		String right = "zxzyyzxxyxxz";

		EditDistance ed = new EditDistance();
		System.out.println(ed.minDistance(left, right));
	}

	int minDistance(String left, String right) {
		if (left == null && right == null || left.equals(right))
			return 0;
		else if (left == null || left.length() == 0)
			return right.length();
		else if (right == null || right.length() == 0)
			return left.length();
		else {
			int[][] map = new int[left.length() + 1][right.length() + 1];
			for (int i = 0; i < map.length; i++)
				map[i][0] = 0;
			for (int i = 0; i < map[0].length; i++)
				map[0][i] = 0;
			for (int j = 1; j <= right.length(); j++) {
				for (int i = 1; i <= left.length(); i++) {
					if (left.charAt(i - 1) == right.charAt(j - 1)) {
						map[i][j] = map[i - 1][j - 1] + 1;
					} else {
						map[i][j] = Math.max(map[i - 1][j], map[i][j - 1]);
					}
				}
			}

			return Math.max(left.length(), right.length()) - map[left.length()][right.length()];
		}
	}
}
