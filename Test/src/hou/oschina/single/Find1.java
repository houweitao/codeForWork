package hou.oschina.single;

/**
 * @author houweitao
 * @date 2015年11月5日 上午9:44:02
 * http://www.oschina.net/code/snippet_2247881_51505
 */


/*给一个数字N，计算从0到N，一共出现了多少个1
例如11，算是2个1，111算是3个1*/

public class Find1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		func(99);
	}

	private static int func(long num) {
		int result = 0;

		for (int j = 1; j < num; j++) {
			String str = "" + j;
			for (int i = 0; i < str.length(); i++) {
				if (str.charAt(i) == '1') {
					result++;
				}
			}
		}
		System.out.println(result);
		return result;
	}
}
