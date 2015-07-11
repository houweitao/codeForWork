package code.LeetCode;

/**
 * @author houweitao 2015年7月11日 上午11:33:59
 *         https://leetcode.com/problems/longest-palindromic-substring/
 */

public class LongestPalindromicSubstring {

	public int longestPalindrome(String s) {
		int maxLength = 1;
		int start = 0;
		int length = s.length();
		int low, high;

		for (int i = 1; i < length; i++) {
			low = i - 1;
			high = i;
			while (low >= 0 && high < length && s.charAt(low) == s.charAt(high)) {
				if (high - low + 1 > maxLength) {
					start = low;
					maxLength = high - low + 1;
				}

				--low;
				++high;
			}

			low = i - 1;
			high = i + 1;
			while (low >= 0 && high < length && s.charAt(low) == s.charAt(high)) {
				if (high - low + 1 > maxLength) {
					start = low;
					maxLength = high - low + 1;
				}

				--low;
				++high;
			}
		}

		System.out.println("Start point:"+start+" "+s.charAt(start));
		
//		s.substring(start, start+maxLength);
		System.out.println(s.substring(start, start+maxLength));
		return maxLength;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "abcdedcb3a";
		
		System.out.println(s.length());
//		System.out.println(s.charAt(3));
		
		LongestPalindromicSubstring lps = new LongestPalindromicSubstring();
		int length = lps.longestPalindrome(s);
		System.out.println(length);

	}

}
