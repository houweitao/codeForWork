package hou.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author houweitao
 * @date 2015年12月4日 下午3:52:40
 * @end 2015年12月4日16:12:03
 * https://leetcode.com/problems/subsets/
 */

//I 服了 U

/*Input:
[4,1,0]
Output:
[[4,1,0],[4,1],[4,0],[4],[1,0],[1],[0],[]]
Expected:
[[],[4],[1],[1,4],[0],[0,4],[0,1],[0,1,4]]

*/
public class Subsets {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = { 1, 2, 3 };
		Subsets subsets = new Subsets();
		List<List<Integer>> ret = subsets.subsets(nums);
		subsets.print(ret);
	}

	private void print(List<List<Integer>> ret) {
		// TODO Auto-generated method stub
		for (int i = 0; i < ret.size(); i++) {
			for (int j = 0; j < ret.get(i).size(); j++) {
				System.out.print(ret.get(i).get(j) + ",");
			}
			System.out.println();
		}
	}

	// mine
	// 从顶向下
	public List<List<Integer>> subsets(int[] nums) {
		List<List<Integer>> ret = new ArrayList<List<Integer>>();
		ArrayList<Integer> tmp = new ArrayList<>();
		
		Arrays.sort(nums);
		if (nums.length == 0) {
			ret.add(tmp);
			return ret;
		} else if (nums.length == 1) {
			ret.add(tmp);
			ArrayList<Integer> tmp2 = new ArrayList<>();
			tmp.add(nums[0]);
			ret.add(tmp2);
			return ret;
		} else {
			int[] nextNums = new int[nums.length - 1];
			for (int i = 0; i < nums.length - 1; i++)
				nextNums[i] = nums[i];
			List<List<Integer>> next = subsets(nextNums);
			for (int i = 0; i < next.size(); i++) {
				ArrayList<Integer> tmp2 = new ArrayList<>();
				tmp2.addAll(next.get(i));
				tmp2.add(nums[nums.length - 1]);
				ret.add(tmp2);
				ret.add(next.get(i));
			}
			return ret;
		}
	}
	
	// https://leetcode.com/discuss/25696/simple-java-solution-with-for-each-loops
	//从底向上
	public List<List<Integer>> subsets2(int[] S) {
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<Integer>());

        Arrays.sort(S);
        for(int i : S) {
            List<List<Integer>> tmp = new ArrayList<>();
            for(List<Integer> sub : res) {
                List<Integer> a = new ArrayList<>(sub);
                a.add(i);
                tmp.add(a);
            }
            res.addAll(tmp);
        }
        return res;
    }
}
