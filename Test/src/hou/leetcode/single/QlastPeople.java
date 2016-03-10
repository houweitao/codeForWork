package hou.leetcode.single;

import java.util.ArrayList;

/**
 * @author houweitao 2015年8月7日 上午11:05:45
 */

public class QlastPeople {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		QlastPeople qp = new QlastPeople();
		qp.solution(1333);
	}

	void solution(int n) {
		ArrayList<Integer> baoshu = new ArrayList<Integer>();
		int count = 0;
		int out = 0;
		boolean judge = true;
		int j = 0;

		boolean num[] = new boolean[n];

		for (int i = 0; i < n; i++) {
			baoshu.add(i + 1);
			num[i] = true;
		}

		while (judge) {
			if (num[j] == true) {
				count++;
				if (count == 3) {
					count = 0;
					System.out.println(baoshu.get(j));
					// baoshu.remove(j);
					// j--;
					num[j] = false;
//					System.out.println(num[j]);
					out++;
					
//					for(int k=0;k<n;k++)
//						if(num[k]==true)
//							System.out.print(baoshu.get(k)+" ");
//					System.out.println();
				}
			}
			j++;

			if (j == n)
				j = 0;
			if (out == n-1)
				judge = false;
		}

		for(int k=0;k<n;k++)
			if(num[k]==true)
				System.out.println(baoshu.get(k));
	}
}
