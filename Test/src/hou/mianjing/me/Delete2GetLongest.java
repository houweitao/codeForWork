package hou.mianjing.me;

/**
 * @author houweitao
 * @date 2016年1月8日 下午4:24:06
 * @end 2016年1月8日16:36:54
 * http://www.1point3acres.com/bbs/thread-162355-1-1.html
 */

public class Delete2GetLongest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "appple";
		String[] dictionary = { "apple", "ape" };

		Delete2GetLongest get = new Delete2GetLongest();
		System.out.println(get.canConvert("apple", "al"));
		System.out.println(get.getLongest(str, dictionary));
	}

	String getLongest(String str, String[] dictionary) {
		int max = Integer.MIN_VALUE;
		String ret = "";
		if (str.length() == 0)
			return ret;

		for (String dic : dictionary) {
			if (dic.equals(str))
				return str;
			if (canConvert(str, dic)) {
				if (dic.length() > max) {
					max = dic.length();
					ret = dic;
				}
			}
		}
		return ret;
	}

	private boolean canConvert(String str, String dic) {
		if (dic.length() > str.length())
			return false;
		else if (str.equals(dic))
			return true;
		else {
			for (int i = 0; i <= str.length() - dic.length(); i++) {
				if (str.charAt(i) == dic.charAt(0)) {
					for (int j = i, k = 0; j < str.length(); j++) {
						//j: str's index; k: dic's index
						if (str.charAt(j) == dic.charAt(k)) {
							k++;
						}
						if (k == dic.length())
							return true;
					}
				}
			}
			return false;
		}
	}

}
