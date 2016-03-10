package hou.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

import hou.leetcode.structure.TreeNode;

/**
 * @author houweitao
 * @date 2015年11月24日 下午12:02:58
 * @end 2015年11月24日12:14:22
 * 感觉做这种拼接list的现在很有心得呀~！
 * https://leetcode.com/problems/path-sum-ii/
 */

public class PathSumII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PathSumII pt=new PathSumII();
		TreeNode node = new TreeNode(1);
		node.left = new TreeNode(2);
		node.left.left = new TreeNode(4);
		node.left.right = new TreeNode(5);
		node.right = new TreeNode(3);
		
		List<List<Integer>> ret=pt.pathSum(node, 7);
		System.out.println(ret.size());
		pt.printDoubleList(ret);
	}

	public List<List<Integer>> pathSum(TreeNode root, int sum) {
		List<List<Integer>> ret = new ArrayList<List<Integer>>();

		
		if (root == null)
			return ret;
//		不一定都是正数呀..
//		else if(root.val>sum)
//			return ret;
		else if (root.left == null && root.right == null) {
			if (root.val != sum)
				return ret;
			else {
				ArrayList<Integer> tmp = new ArrayList<>();
				tmp.add(root.val);
				ret.add(tmp);
				return ret;
			}
		} else {
			if (root.left != null) {
				List<List<Integer>> help = pathSum(root.left, sum - root.val);
				if(help.size()>0){
					for(int i=0;i<help.size();i++){
						ArrayList<Integer> tmp = new ArrayList<>();
						tmp.add(root.val);
						tmp.addAll(help.get(i));
						ret.add(tmp);
					}
				}
			}
			if (root.right != null) {
				List<List<Integer>> help = pathSum(root.right, sum - root.val);
				if(help.size()>0){
					for(int i=0;i<help.size();i++){
						ArrayList<Integer> tmp = new ArrayList<>();
						tmp.add(root.val);
						tmp.addAll(help.get(i));
						ret.add(tmp);
					}
				}
			}
		}
		return ret;
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
