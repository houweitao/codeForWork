package hou.mianjing.me;

import java.util.ArrayList;

/**
 * @author houweitao 2015年9月9日 下午3:07:23 给一个String要你compress, 方法如下: 如果是
 *         aaabbccccbaddd 就回传 a3b2c4bad3 不用考虑特殊符号, 只考虑lowercase letter
 */

public class StringCompress {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "aaabbccccbadddw";
		StringCompress sc = new StringCompress();
		sc.stringCompress(s);
	}

	void stringCompress(String s) {
		ArrayList<Character> result = new ArrayList<Character>();
		int num = 1;
		for (int i = 0; i < s.length() - 1; i++) {
			if (s.charAt(i + 1) == s.charAt(i)) {
				num++;
				if (i == s.length() - 2) {
					result.add(s.charAt(i));
					result.add((char) (num + '0'));  
				}
			} else {
				
				if (i == s.length() - 2 && num==1) {
					result.add(s.charAt(i));
				}
				
				result.add(s.charAt(i));
				if (num > 1) {
					char ch = (char) (num + '0');
					result.add(ch);
				}
				num = 1;
			}
		}
		
		for(int i=s.length()-1;i>=0;i--){
			if (s.charAt(i) == s.charAt(i-1)) {
				num++;
			}
			else{
				result.add(s.charAt(i));
				if (num > 1) {
					char ch = (char) (num + '0');
					result.add(ch);
				}
				break;
			}
		}

		for (int i = 0; i < result.size(); i++)
			System.out.print(result.get(i));
	}
}
