package hou.leetcode.single;

/**
 * @author houweitao
 * @date 2015年11月11日 下午2:37:40
 */

public class ExcelSheetColumnNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		System.out.println('B' - 'A');
		
		ExcelSheetColumnNumber escn=new ExcelSheetColumnNumber();
		escn.titleToNumber("AB");
	}

	public int titleToNumber(String s) {
		int n = 0;
		int mi = 0;

		if (s.length() == 0)
			return 0;

		while (s.length() > 1) {
			n = n + (s.charAt(s.length()-1) - 'A' + 1) * (int) Math.pow(26, mi);
			mi++;
			s=s.substring(0, s.length()-1);
			
			System.out.println("mi, "+mi+"    n, "+n+"    s, "+s);
		}
		n = n + (s.charAt(s.length()-1) - 'A' + 1) * (int) Math.pow(26, mi);
		
		System.out.println(n);
		return n;
	}
}
