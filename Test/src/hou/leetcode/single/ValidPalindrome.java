package hou.leetcode.single;

/**
 * @author houweitao
 * @date 2015年11月12日 上午10:39:42
 * https://leetcode.com/problems/valid-palindrome/
 * 判断一个字符串是否是回文
 */

public class ValidPalindrome {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int i = 0;
//		while (i < 60) {
//			System.out.println(i + "," + (char) ('A' + i));
//			i++;
//		}

		ValidPalindrome vp = new ValidPalindrome();
		String s = "A man, a plan, a canal: Panama";
		
		System.out.println(vp.isPalindrome(s));

	}

//	创造新的字符串花了太多时间？？是的。这里不管他是不是回文，先走了一遍，其实大部分的字符串可以不用一遍就可以判断出
	public boolean isPalindrome(String s) {
		if (s.length() == 0)
			return true;

		String after = "";
		for (int i = 0; i < s.length(); i++) {
			int dis = s.charAt(i) - 'A';
			if (dis > -1 && dis < 26 || dis > 31 && dis < 58)
				after = after + s.charAt(i);
		}

		System.out.println(after);
		after = after.toLowerCase();

		if (after.length() == 0 || after.length() == 1)
			return true;

		int i = 0, j = after.length() - 1;
		while (i < j) {
			if (after.charAt(i) == after.charAt(j)) {
				i++;
				j--;
			} else
				return false;
		}

		return true;
	}
	
//	https://leetcode.com/discuss/68630/clean-java-solution-10ms
	public boolean isPalindrome2(String s) {

	    s = s.toLowerCase();
	    int i = 0;
	    int j = s.length() - 1;

	    while (i < s.length()-1 && j >= i){
	        if (!isValid(s.charAt(i))){
	            i++;
	            continue;
	        }
	        if (!isValid(s.charAt(j))){
	            j--;
	            continue;
	        }
	        if (s.charAt(i) != s.charAt(j)){
	            return false;
	        }
	        i++;
	        j--;
	    }
	    return true;
	}

	private boolean isValid(char c){
	    return (c >= 'a' && c <= 'z') || (c >= '0' && c <= '9');
	}
}
