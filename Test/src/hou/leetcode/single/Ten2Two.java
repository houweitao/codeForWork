package hou.leetcode.single;

/**
 * @author houweitao 2015年8月27日 上午11:07:56
 */

public class Ten2Two {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Ten2Two tt = new Ten2Two();
		tt.TenTwo(55);
		System.out.println();
		tt.TwoTen(110111);
	}

	void TenTwo(int number) {
		int n = number;
		int tmp[] = new int[11];
		int i = 0;
		while (n > 1) {
			tmp[i] = n % 2;
			n = n / 2;
			i++;
		}
		tmp[i] = 1;

		for (int j = i; j >= 0; j--)
			System.out.print(tmp[j]);
	}

	void TwoTen(int number) {
		int n = number;
		int result = 0;
		int i=0;
		while (n > 0) {
			
			int tt=(int) Math.pow(2, i);
			
			result=(int) (result+(n%10)*tt);
			System.out.println(result);
			
			n = n / 10;
			
			i++;
		}
		System.out.println(result);
	}
}
