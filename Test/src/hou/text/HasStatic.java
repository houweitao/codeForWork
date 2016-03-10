package hou.text;

/**
 * @author houweitao
 * @date 2016年3月1日 上午9:21:46
 * http://www.nowcoder.com/question/next?pid=2238&qid=15319&tid=2487221
 */

public class HasStatic {
	private static int x = 100;

	public static void main(String args[]) {
		HasStatic hs1 = new HasStatic();
		hs1.x++;
		System.out.println(x);
		HasStatic hs2 = new HasStatic();
		hs2.x++;
		System.out.println(x);
		hs1 = new HasStatic();
		hs1.x++;
		System.out.println(x);
		HasStatic.x--;
		System.out.println(HasStatic.x);

		System.out.println(x);

		System.out.println(hs1.x);
	}
}
