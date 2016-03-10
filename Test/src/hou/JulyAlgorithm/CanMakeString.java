package hou.JulyAlgorithm;

/**
 * @author houweitao
 * @date 2016年1月18日 上午1:32:39
 * @end 2016年1月18日01:49:51
 * P167
 */

public class CanMakeString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CanMakeString can = new CanMakeString();

		String first = "aabcc";
		String second = "dbbac";
		String big = "aadbbcbcac";

		System.out.println(can.canMake(first, second, big));
	}

	boolean canMake(String first, String second, String big) {
//		System.out.println(first + "," + second + "," + big);
		if (first == null || first.length() == 0) {
			System.out.println("sss");
			if (second.equals(big))
				return true;
			else
				return false;
		} else if (second == null || second.length() == 0) {
			System.out.println("sss");
			if (first.equals(big))
				return true;
			else
				return false;
		} else if (big.length() != first.length() + second.length())
			return false;
		else if (big.equals(first + second) || big.equals(second + first)) {
			return true;
		} else {
			boolean fir = false, sec = false;
			if (big.charAt(0) == first.charAt(0))
				fir = canMake(first.substring(1), second, big.substring(1));
			if (big.charAt(0) == second.charAt(0))
				sec = canMake(first, second.substring(1), big.substring(1));

			return fir || sec;
		}
	}
}
