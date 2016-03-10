package hou.JulyAlgorithm;

/**
 * @author houweitao
 * @date 2016年1月18日 上午1:02:29
 * @end 2016年1月18日01:11:15
 * p75
 */

public class RandomOut {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RandomOut out = new RandomOut();
		System.out.println(out.out(100));
	}

	String out(int m) {
		String ret = "";
		int sum = 0;
		int[] space = new int[100];
		for (int i = 0; i < 100; i++)
			space[i] = i + 1;
		for (int i = 0; i < m; i++) {
			int r = help(space, 100 - i);
			ret = ret + r + ",";
			sum = sum + r;
		}
		System.out.println(sum);
		return ret;
	}

	int help(int[] space, int scope) {
		int ret = (int) (Math.random() * scope);
		int tmp = space[ret];
		space[ret] = space[scope - 1];
		space[scope - 1] = tmp;
		return tmp;
	}

}
