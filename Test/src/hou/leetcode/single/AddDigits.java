package hou.leetcode.single;

/**
 * @author houweitao 2015年9月1日 上午9:57:17
 *         https://leetcode.com/problems/add-digits/
 *         http://blog.csdn.net/u012243115/article/details/48133139
 */

public class AddDigits {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		AddDigits ad = new AddDigits();
		ad.addDigits(1923242346);

	}

	public int addDigits(int num) {
		while(num>9){
			int tmp=0;
			while(num>9){
				tmp=num%10+tmp;
				num=num/10;
			}
			tmp=tmp+num;
			num=tmp;
			
			System.out.println(num);
		}
		System.out.println(num);
		return num;
		
	}
}
