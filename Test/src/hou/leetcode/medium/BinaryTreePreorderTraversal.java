package hou.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

import hou.leetcode.structure.TreeNode;

/**
 * @author houweitao
 * @date 2015年11月18日 下午4:20:50
 * @end 2015年11月18日16:33:37
 * https://leetcode.com/problems/binary-tree-preorder-traversal/
 */

public class BinaryTreePreorderTraversal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinaryTreePreorderTraversal btpt=new BinaryTreePreorderTraversal();
		List<Integer> ret=new ArrayList<>();
		TreeNode node=new TreeNode(1);
		node.left=new TreeNode(2);
		node.right=new TreeNode(3);
		node.left.right=new TreeNode(4);
		node.left.right.left=new TreeNode(5);
		node.right.right=new TreeNode(6);
		
		ret=btpt.preorderTraversal(node);
		for(int i=0;i<ret.size();i++)
			System.out.print(ret.get(i)+",");
	}

	ArrayList<Integer> al=new ArrayList<>();
	public List<Integer> preorderTraversal(TreeNode root) {
		if(root==null)
			return al;
		else{
			al.add(root.val);
			preorderTraversal(root.left);
			preorderTraversal(root.right);
			return al;
		}
	}
}
