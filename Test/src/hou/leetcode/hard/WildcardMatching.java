package hou.leetcode.hard;

/**
 * @author houweitao
 * @date 2016年2月25日 上午9:44:22
 * @tobecontinued 2016年2月25日10:01:15
 * 很难啊！可能要用到KMP？先放一放吧..
 */

public class WildcardMatching {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	boolean isMatch(String s, String p) {
		if (!p.contains("*")) {
			if (s.length() != p.length())
				return false;
			else {
				for (int i = 0; i < s.length(); i++) {
					if (!(p.charAt(i) == '?' || p.charAt(i) == s.charAt(i)))
						return false;
				}
			}
		} else if(p.equals("*")){
			return true;
		}else{
			return whenHasStar(s,p);
		}
		return false;
	}

	private boolean whenHasStar(String s, String p) {
		String[] split=p.split("*");
		
		if(p.charAt(0)=='*'){
			
		}
		
		
		return false;
	}

}
