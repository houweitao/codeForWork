package hou.leetcode.single;

/**
 * @author houweitao 2015年8月3日 下午3:36:22
 *         https://leetcode.com/problems/valid-anagram/
 */

public class ValidAnagram {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "anagram";
		String t = "nagaram";

		ValidAnagram va = new ValidAnagram();

		System.out.println(va.isAnagram(s, t));
	}

	public boolean isAnagram(String s, String t) {
		int[] alphabet = new int[26];
		for (int i = 0; i < s.length(); i++) {
			alphabet[s.charAt(i) - 'a']++;
			System.out.println(s.charAt(i) - 'a');
		}
		
		for(int i=0;i<26;i++)
			System.out.println(i+": "+alphabet[i]);
		
		for (int i = 0; i < t.length(); i++)
			alphabet[t.charAt(i) - 'a']--;
		
		System.out.println();
		for(int i=0;i<26;i++)
			System.out.println(i+": "+alphabet[i]);
		
		
		
		for (int i : alphabet)
			if (i != 0)
				return false;
		return true;
	}

	// public boolean isAnagram(String s, String t) {
	// boolean judge = true;
	//
	// if(s.length()!=t.length())
	// return false;
	// else{
	// for(int i=0;i<s.length();i++)
	// {
	// String tmp=String.valueOf(s.charAt(i));
	// if(!t.contains(tmp))
	// {
	// return false;
	// }
	//
	// for(int j=0;j<t.length();j++){
	// if(t.charAt(j)==s.charAt(i)){
	// t
	// }
	// }
	// }
	// }
	//
	//
	// return judge;
	// }

}
