package hou.mianjing.me;

import java.util.ArrayList;

/**
 * @author houweitao
 * @date 2015年11月19日 下午1:55:43
 * hou.structrue.tree.PrintAllPaths;//我自己写的
 * http://www.1point3acres.com/bbs/forum.php?mod=redirect&goto=findpost&ptid=148413&pid=2069799
 */

public class LowestCommonAncestorForAnyTree {
	// TODO Auto-generated method stub

	public static void main(String[] args) {
		TreeNode n1 = new TreeNode(1);
		TreeNode n2 = new TreeNode(2);
		TreeNode n3 = new TreeNode(3);
		TreeNode n4 = new TreeNode(4);
		TreeNode n5 = new TreeNode(5);
		TreeNode n6 = new TreeNode(6);
		TreeNode n7 = new TreeNode(7);
		TreeNode n8 = new TreeNode(8);
		TreeNode n9 = new TreeNode(9);
		TreeNode n10 = new TreeNode(10);
		n1.children.add(n2);
		n1.children.add(n3);
		n1.children.add(n4);
		n2.children.add(n5);
		n2.children.add(n6);
		n4.children.add(n7);
//		n5.children.add(n8);
//		n5.children.add(n9);
		n6.children.add(n10);
		n10.children.add(n8);
		TreeNode res = find(n1);
		System.out.println(res.val);

	}

	// 返回的是节点
	public static TreeNode find(TreeNode root) {
		if (root == null || root.children.isEmpty())
			return root;
		return helper(root).node;
	}

	// 递归过程中不仅需要节点还需要深度！所以这里返回的是数据结构result
	public static Result helper(TreeNode root) {
		if (root.children.isEmpty())
			return new Result(root, 1);
		int size = root.children.size();
		int maxDepth = Integer.MIN_VALUE;
		Result r = new Result(root, maxDepth);
		for (int i = 0; i < size; i++) {
			Result tmp = helper(root.children.get(i));
			if (tmp.maxDepth > maxDepth) {
				maxDepth = tmp.maxDepth;
				//update 果然有bug！哈哈被我发现了！2015年12月10日18:39:57
				//之前的版本不能处理单节点最深的情况
				if (maxDepth == 1)
					r.node = root;
				else
					r.node = tmp.node;
				r.maxDepth = tmp.maxDepth + 1;
			} else if (tmp.maxDepth == maxDepth) {
				// 如果有2个树的深度相同，并且他们是最深的树，那么他们的公共节点必是当前节点。
				r.node = root;
			}
		}
		return r;
	}

	//http://blog.csdn.net/sunny2038/article/details/6926079
	//原来我写的内部类是动态的，也就是开头以public class开头。而主程序是public static class main。在Java中，类中的静态方法不能直接调用动态方法。只有将某个内部类修饰为静态类，然后才能够在静态类中调用该类的成员变量与成员方法。所以在不做其他变动的情况下，最简单的解决办法是将public class改为public static class.
	static class TreeNode {
		int val;
		ArrayList<TreeNode> children;

		public TreeNode(int val) {
			this.val = val;
			children = new ArrayList<>();
		}
	}

	static class Result {
		TreeNode node;
		int maxDepth;

		public Result(TreeNode node, int maxDepth) {
			this.node = node;
			this.maxDepth = maxDepth;
		}
	}
}
