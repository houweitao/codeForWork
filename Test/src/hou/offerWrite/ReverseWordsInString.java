package hou.offerWrite;

/**
 * @author houweitao
 * @date 2016年3月1日 下午3:01:35
 * @end 2016年3月1日15:09:01
 */

public class ReverseWordsInString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ReverseWordsInString re=new ReverseWordsInString();
		String str="i have a dream";
		re.reverseSentence(str);
	}

	String reverseSentence(String str) {
		String[] toRe = reverseWord(str).split(" ");
		String ret = "";
		for (String s : toRe) {
			ret = ret + reverseWord(s) + " ";
		}
		System.out.println(ret);
		return ret;
	}

	String reverseWord(String str) {
		String s = "";
		for (int i = str.length() - 1; i >= 0; i--) {
			s = s + str.charAt(i);
		}
		return s;
	}

}
