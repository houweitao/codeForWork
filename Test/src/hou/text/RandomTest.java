package hou.text;

import java.util.Arrays;

/**
 * @author houweitao
 * @date 2015年12月31日 上午10:53:53
 * @end 2015年12月31日10:59:22
 */

public class RandomTest {
	public static void main(String[] args) {
		RandomTest rt = new RandomTest();
		double[] ret = rt.getRandomNum(100);
		Arrays.sort(ret);
		rt.print(ret);
	}

	double[] getRandomNum(int n) {
		double[] ret = new double[n];
		for (int i = 0; i < n; i++) {
			ret[i] = Math.random();
		}
		return ret;
	}

	void print(double[] ret) {
		for (int i = 0; i < ret.length; i++)
			System.out.println(ret[i]);
	}
}
