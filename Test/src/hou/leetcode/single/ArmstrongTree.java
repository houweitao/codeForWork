package hou.leetcode.single;

/**
 * @author houweitao 2015年8月8日 下午1:44:28
 */

public class ArmstrongTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// System.out.println(2 ^ 5);

		ArmstrongTree at = new ArmstrongTree();
		System.out.println(at.isArmstrong(153));
		
		for(int i=1;i<10000;i++)
			if(at.isArmstrong(i))
				System.out.print(i+" ");
	}

	boolean isArmstrong(int n) {
		int count = 0;
		int nn=n;
		while (nn > 0) {
			int tmp = nn % 10;
			count = count + tmp * tmp * tmp;
			nn = nn / 10;
		}

		if (count == n)
			return true;
		else
			return false;
	}
}
