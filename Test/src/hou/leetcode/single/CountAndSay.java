package hou.leetcode.single;

/**
 * @author houweitao
 * @date 2015年11月2日 下午2:49:58
 */

public class CountAndSay {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CountAndSay cs = new CountAndSay();
		cs.countAndSay(11134555);
	}

	public String countAndSay(int n) {
		if (n < 10)
			return "1" + String.valueOf(n);
//			return String.valueOf(n);

		String out = "";
		String nValue = String.valueOf(n);

		int tmp = 0;
		int now = Integer.parseInt(nValue.charAt(0) + "");
		int count = 1;

		for (int index = 1; index < nValue.length(); index++) {
			tmp = Integer.parseInt(nValue.charAt(index) + "");
			if (tmp == now)
				count++;
			else {
				out = out + String.valueOf(count) + String.valueOf(now);
				now = Integer.parseInt(nValue.charAt(index) + "");
				count = 1;
			}

			if (index == nValue.length() - 1) {
			}
		}
		
		out = out + String.valueOf(count) + String.valueOf(now);

		System.out.println(out);

		return out;

	}
}
