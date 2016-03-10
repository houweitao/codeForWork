package hou.offerWrite;

import java.util.HashSet;

/**
 * @author houweitao
 * @date 2016年3月8日 上午9:47:22
 * @end 2016年3月8日10:20:56
 * http://www.ruanyifeng.com/blog/2013/05/Knuth%E2%80%93Morris%E2%80%93Pratt_algorithm.html
 */

public class MyKMP {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyKMP kmp = new MyKMP();
		int[] ret = kmp.getMap("abcdabd");
		for (int i : ret)
			System.out.print(i + " ");
		System.out.println();

		System.out.println(kmp.kmp("bbc abcdb abcdabdabde", "abcdabd"));
	}

	int kmp(String str, String s) {
		int[] ret = null;
		ret = getMap(str);

		for (int i = 0; i < str.length() - s.length() + 1; i++) {
			if (str.charAt(i) == s.charAt(0)) {
				System.out.println(i);
				int same = 1;
				for (int j = i + 1, k = 1; j < str.length(); j++) {
					if (str.charAt(j) == s.charAt(k)) {
						k++;
						same++;

//						System.out.println(k + " =? " + s.length());
						if (k == s.length())
							return i;
					} else {
						i = i + ret[same - 1];
						System.out.println(same + ".. " + (i - ret[same - 1]) + "," + i);
						break;
					}
				}
			}
		}

		return -1;
	}

	int[] getMap(String s) {
		int[] ret = new int[s.length()];

		for (int i = 1; i < s.length(); i++) {
			ret[i] = get(s.substring(0, i + 1));
		}

		return ret;
	}

	private int get(String s) {
		HashSet<String> hs = new HashSet<>();
		//后缀
		for (int i = 0; i < s.length() - 1; i++) {
			hs.add(s.substring(i + 1));
		}

		int size = 0;
		for (int i = 0; i < s.length() - 1; i++) {
//			System.out.println(s.substring(0, i + 1));
			if (hs.contains(s.substring(0, i + 1))) {
//				System.out.println(s.substring(0, i + 1));
				size = Math.max(size, s.substring(0, i + 1).length());
			}
		}

//		System.out.println(hs);
//		System.out.println(s + ":" + size);
//		System.out.println();

		return s.length() - size;
	}
}
