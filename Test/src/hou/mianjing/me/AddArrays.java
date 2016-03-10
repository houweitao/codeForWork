package hou.mianjing.me;

import java.util.ArrayList;

/**
 * @author houweitao
 * @date 2016年2月23日 下午3:00:06
 * 实现两个array相加，也就是bigint addition 例如[6,3,5] [3,8,3] 要得到[1,0,1,8]
 * http://www.1point3acres.com/bbs/thread-161045-1-1.html
 * @end 2016年2月23日15:24:03
 */

public class AddArrays {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] one = { 5, 3, 6 };
		int[] two = { 3, 8, 2 };

		AddArrays aa = new AddArrays();
		int[] ret = aa.add(one, two);
		for (Integer i : ret)
			System.out.print(i + " , ");
		System.out.println();

		ArrayList<Integer> l1 = new ArrayList<>();
		ArrayList<Integer> l2 = new ArrayList<>();

		l1.add(6);
		l1.add(3);
		l1.add(5);
		l2.add(3);
		l2.add(8);
		l2.add(3);

		ArrayList<Integer> result = aa.add(l1, l2);
		System.out.println(result);

	}

	ArrayList<Integer> add(ArrayList<Integer> one, ArrayList<Integer> two) {
		if (one.size() == 0)
			return two;
		else if (two.size() == 0)
			return one;
		else {
			ArrayList<Integer> ret = new ArrayList<Integer>();
			int[] first = new int[one.size()];
			int[] second = new int[two.size()];
			for (int i = 0; i < one.size(); i++) {
				first[i] = one.get(one.size() - 1 - i);
			}
			for (int i = 0; i < two.size(); i++) {
				second[i] = two.get(two.size() - 1 - i);
			}

			int[] third = add(first, second);

			if(third[third.length-1]!=0)
				ret.add(third[third.length-1]);
			
			for (int i = third.length - 2; i >= 0; i--)
				ret.add(third[i]);

			return ret;
		}
	}

	int[] add(int[] one, int[] two) {
		int maxL = Math.max(one.length, two.length);
		int minL = Math.min(one.length, two.length);

		int[] ret = new int[maxL + 1];

		for (int i = 0; i < maxL; i++) {
			int curSum = one[i] + two[i];
			ret[i] = ret[i] + curSum;

			if (ret[i] >= 10) {
				ret[i + 1] = ret[i + 1] + ret[i] / 10;
				ret[i] = ret[i] % 10;
			}
		}

		return ret;
	}

}
