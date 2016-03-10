package hou.JulyAlgorithm;

import java.util.LinkedList;
import java.util.List;

/**
 * @author houweitao
 * @date 2016年1月3日 下午10:35:43
 * @end 2016年1月3日23:18:46
 * p12
 */

public class SubString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[] map = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's',
				't', 'u', 'v', 'w', 'x', 'y', 'z' };
		SubString ss = new SubString();
		List<String> ret = ss.Recursion(3, map, -1);
		ss.printList(ret);

		System.out.println((char) ('z' - 2));

		List<String> retStack=ss.getResult(map, 5);
//		ss.printList(retStack);
		System.out.println(retStack.size());
		
//		for(int i=1;i<26;i++){
//			List<String> tmp=ss.getResult(map, i);
//			System.out.println(i+": "+tmp.size());
//		}
	}

	// 递归方法。2016年1月3日22:52:08
	List<String> Recursion(int len, char[] map, int begin) {
		List<String> ret = new LinkedList<>();
		if (len == 1) {
			for (int i = begin + 1; i < map.length; i++) {
				ret.add(map[i] + "");
			}
			return ret;
		} else {
			for (int i = begin + 1; i <= 26 - len; i++) {
				List<String> next = Recursion(len - 1, map, i);
				for (int k = 0; k < next.size(); k++) {
					ret.add(map[i] + next.get(k));
				}
			}
			return ret;
		}
	}

	// 类似栈的方法。和八皇后类似。
	List<String> getResult(char[] map, int len) {
		List<String> ret = new LinkedList<>();
		char[] res = new char[len];

		int k = 0;
		res[0] = 'a';
		while (k >= 0) {
			while (res[k] <= (char) ('z' + k - len + 1)) {
				char now = res[k];
				if (k == len - 1) {
					printArray(res);
					ret.add(getStr(res));
					res[k] = (char) (res[k] + 1);
				} else {
					res[++k] = (char) (now + 1);
				}
			}
			k--;
			if (k >= 0)
				res[k] = (char) (res[k] + 1);
		}

		return ret;
	}

	private String getStr(char[] res) {
		// TODO Auto-generated method stub
		String ret = "";
		for (int i = 0; i < res.length; i++)
			ret = ret + res[i];
		return ret;
	}

	private void printArray(char[] res) {
		// TODO Auto-generated method stub
		for (int i = 0; i < res.length; i++) {
			System.out.print(res[i] + ",");
		}
		System.out.println();
	}

	void printList(List<String> list) {
		for (int i = 0; i < list.size(); i++) {
			System.out.print(list.get(i) + ", ");
		}
		System.out.println();
		System.out.println(list.get(0).length() + ": " + list.size());
	}
}
