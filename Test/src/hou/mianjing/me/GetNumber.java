package hou.mianjing.me;

/**
 * @author houweitao
 * @date 2016年1月26日 下午3:45:59
 * http://www.1point3acres.com/bbs/thread-167076-1-1.html
 * ABCD*4 = DCBA, what are A, B, C, D
 * @end 2016年1月26日15:59:06
 * 什么鬼。
 */

public class GetNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GetNumber gn = new GetNumber();
		gn.get();
	}

	void get() {
		for (int i = 1; i <= 9999 / 4; i++) {
//			System.out.println(i * 4 + " , " + reverse(i));

			if (i * 4 == reverse(i))
				System.out.println(i);
		}
	}

	int reverse(int num) {
		String reverse = "";
		String before = num + "";
		String[] add = { "0", "00", "000" };
		if (before.length() < 4)
			before = add[3 - before.length()] + before;

		for (int i = before.length() - 1; i >= 0; i--) {
			reverse = reverse + before.charAt(i);
		}

		System.out.println(num+" :  "+before+" -> "+reverse);
		
		return Integer.valueOf(reverse);
	}

}
