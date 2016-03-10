package hou.csdn.single;

/**
 * @author houweitao 2015年9月8日 下午2:54:21
 *         http://blog.csdn.net/pyz_tech/article/details/23657377
 */

public class JumpFloor {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JumpFloor jf = new JumpFloor();
		System.out.println(jf.jump(5));
	}

	int jump(int n) {
		if (n < 1)
			return 0;
		else if (n == 1)
			return 1;
		else if (n == 2)
			return 2;
		else if (n == 3)
			return 4;
		else
			return jump(n - 1) + jump(n - 2)+ jump(n - 3);

	}
}
