package hou.HappyAlgorithm;

/**
 * @author houweitao
 * @date 2015年12月28日 上午10:03:42
 */

public class RandomTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double sum = 0;
		for (int i = 0; i < 100; i++) {
			double p = Math.random();
			System.out.println(p);
			sum = sum + p;
		}
		System.out.println(sum / 100);
	}

}
