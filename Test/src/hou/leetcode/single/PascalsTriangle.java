package hou.leetcode.single;

import java.util.ArrayList;
import java.util.List;

/**
 * @author houweitao
 * @date 2015年11月24日 上午9:48:26
 * https://leetcode.com/problems/pascals-triangle/
 */

public class PascalsTriangle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PascalsTriangle pt = new PascalsTriangle();
		List<List<Integer>> ret = pt.generate(4);
		pt.printDoubleList(ret);
	}

	public List<List<Integer>> generate(int numRows) {
		List<List<Integer>> ret = new ArrayList<List<Integer>>();

		if (numRows < 1)
			return new ArrayList<List<Integer>>();
		if (numRows == 1) {
			List<Integer> tmp = new ArrayList<>();
			tmp.add(1);
			ret.add(tmp);
			return ret;
		} else if (numRows == 2) {
			List<Integer> tmp = new ArrayList<>();
			tmp.add(1);
			ret.add(tmp);
			List<Integer> tmp2 = new ArrayList<>();
			tmp2.add(1);
			tmp2.add(1);
			ret.add(tmp2);
			return ret;
		} else {
			List<Integer> tmp = new ArrayList<>();
			tmp.add(1);
			ret.add(tmp);
			List<Integer> tmp2 = new ArrayList<>();
			tmp2.add(1);
			tmp2.add(1);
			ret.add(tmp2);
			for (int i = 2; i < numRows; i++) {
				List<Integer> tmpp = new ArrayList<>();
				tmpp.add(1);
				for (int j = 1; j <= i - 1; j++) {
					tmpp.add(ret.get(i - 1).get(j) + ret.get(i - 1).get(j - 1));
				}
				tmpp.add(1);
				ret.add(tmpp);
			}

			return ret;
		}
	}

	void printDoubleList(List<List<Integer>> List) {
		for (int i = 0; i < List.size(); i++) {
			for (int j = 0; j < List.get(i).size(); j++)
				System.out.print(List.get(i).get(j) + ",");
			System.out.println();
		}
		System.out.println(List.size());
	}
}
