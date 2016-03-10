package hou.JulyAlgorithm;

import java.util.LinkedList;
import java.util.List;

/**
 * @author houweitao
 * @date 2016年1月7日 上午12:25:46
 * p72
 * 什么意思乱七八糟
 * @end 2016年1月7日00:35:43
 */

public class AddList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums={5,9,1,7,2,6,3,8,10,4};
		AddList al=new AddList();
		List<List<Integer>> list=al.getList(nums);
		al.printList(list);
	}

	List<List<Integer>> getList(int[] nums) {
		List<List<Integer>> ret = new LinkedList<>();
		if (nums.length == 0 || nums.length == 1)
			return ret;
		else {
			for (int i = 0; i < nums.length - 1; i++) {
				List<Integer> tmp = new LinkedList<>();
				tmp.add(nums[i]);
				for (int j = i + 1; j < nums.length; j++) {
					if (nums[j] > tmp.get(tmp.size() - 1)) {
						tmp.add(nums[j]);
					}
				}

				ret.add(tmp);
			}

			return ret;
		}
	}

	void printList(List<List<Integer>> list) {
		for (int i = 0; i < list.size(); i++) {
			for (int j = 0; j < list.get(i).size(); j++) {
				System.out.print(list.get(i).get(j) + ",");
			}
			System.out.println();
		}
		System.out.println();
	}
}
