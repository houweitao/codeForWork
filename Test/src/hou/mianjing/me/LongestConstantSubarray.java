package hou.mianjing.me;

import java.util.ArrayList;

/**
 * @author houweitao
 * @date 2016年1月7日 下午4:15:37
 * @end 2016年1月7日16:34:06
 * @source http://www.1point3acres.com/bbs/thread-162004-1-1.html
 * @描述 给一串字符串找出里面仅含两个不同字母的最长子串并返回，比如abcababbacb， 返回 ababba。
 */

public class LongestConstantSubarray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "abcababbacb";
		LongestConstantSubarray sub = new LongestConstantSubarray();
		System.out.println(sub.getSub(str));
	}

	String getSub(String str) {
		String ret = "";
		if (str.length() == 0)
			return null;
		else if (str.length() == 1)
			return ret;
		else {
			ArrayList<Character> list = new ArrayList<>();
			int maxSize = 0;
			int begin = 0;
			for (int i = 0; i < str.length(); i++) {
				System.out.println(list);
				if (!list.contains(str.charAt(i))) {
					System.out.println("not contain " + str.charAt(i));
					if (list.size() >= 2) {
						if (maxSize < (i - begin + 1)) {
							ret = str.substring(begin, i);
							maxSize = i - begin + 1;
						}
						if (list.get(0).equals(str.charAt(i - 1)))
							list.remove(1);
						else
							list.remove(0);
						begin = i - 1;
					}
					list.add(str.charAt(i));
				}
			}

			return ret;
		}
	}
}
