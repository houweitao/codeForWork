package hou.leetcode.single;

/**
 * @author houweitao
 * @date 2015年10月29日 下午3:23:45
 * wrong
 */

public class NumsOf1Bit {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int n=00000000000000000000000000001011;
		n=11010101;
		NumsOf1Bit num=new NumsOf1Bit();
		System.out.println(num.count1Bit(n));
	}

	int count1Bit(int n){
		System.out.println(n);
		int result=0;
		while(n>0){
			if(n%10==1)
				result++;
			n=n/10;
			System.out.println(n);
		}
		
		return result;
	}
}
