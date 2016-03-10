package hou.leetcode.single;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.Stack;

import hou.leetcode.structure.TreeNode;

/**
 * @author houweitao
 * @date 2015年11月23日 下午3:21:53
 * @end 2015年11月23日16:15:26
 * 不知道为啥leetcode not work..尽力了。虽然写得很复杂。。好蛋疼
 * much better: https://leetcode.com/discuss/22538/my-dfs-and-bfs-java-solution
 */

public class BinaryTreeLevelOrderTraversalII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode node = new TreeNode(1);
		node.left=new TreeNode(2);
		node.right=new TreeNode(3);
		node.left.right=new TreeNode(4);
		node.left.right.left=new TreeNode(5);
		node.right.right=new TreeNode(6);

		BinaryTreeLevelOrderTraversalII test = new BinaryTreeLevelOrderTraversalII();
		List<List<Integer>> ret = test.levelOrderBottom(node);
		test.printDoubleList(ret);
	}

	//much better
	 public List<List<Integer>> levelOrderBottomBetter(TreeNode root) {
	        Queue<TreeNode> queue = new LinkedList<TreeNode>();
	        List<List<Integer>> wrapList = new LinkedList<List<Integer>>();

	        if(root == null) return wrapList;

	        queue.offer(root);
	        while(!queue.isEmpty()){
	            int levelNum = queue.size();
	            List<Integer> subList = new LinkedList<Integer>();
	            for(int i=0; i<levelNum; i++) {
	                if(queue.peek().left != null) queue.offer(queue.peek().left);
	                if(queue.peek().right != null) queue.offer(queue.peek().right);
	                subList.add(queue.poll().val);
	            }
	            wrapList.add(0, subList);//原来可以直接这么加！
	        }
	        return wrapList;
	    }
	
	//me
	public List<List<Integer>> levelOrderBottom(TreeNode root) {
		List<List<Integer>> ret = new ArrayList<List<Integer>>();
		Queue<myTreeNode> dep = new LinkedList<myTreeNode>();
		ArrayList<myTreeNode> out = new ArrayList<>();

		if (root == null)
			return new ArrayList<List<Integer>>();
		else {
			dep.offer(new myTreeNode(root, 1));

			while (!dep.isEmpty()) {
				myTreeNode tmp = dep.poll();
				if (tmp.node.right != null)
					dep.offer(new myTreeNode(tmp.node.right, tmp.depth + 1));
				if (tmp.node.left != null)
					dep.offer(new myTreeNode(tmp.node.left, tmp.depth + 1));
				out.add(tmp);
			}

			for (int i = 0; i < out.size(); i++) {
				System.out.println(out.get(i).node.val + "," + out.get(i).depth);
			}

			int size = out.size();
			System.out.println("size: " + size);

			int recentDep = out.get(size - 1).depth;
			ArrayList<Integer> al = new ArrayList<>();

			if (size == 1) {
				al.add(out.get(size - 1).node.val);
				ret.add(al);
				return ret;
			}
			for (int i = size - 1; i >= 0; i--) {
				if (out.get(i).depth != recentDep) {
					ret.add(al);
					al = new ArrayList<>();
//					al.clear();
					al.add(out.get(i).node.val);
					recentDep = out.get(i).depth;
				} else {
					al.add(out.get(i).node.val);
				}
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

class myTreeNode {
	TreeNode node;
	int depth;

	myTreeNode(TreeNode node, int depth) {
		this.depth = depth;
		this.node = node;
	}
}
