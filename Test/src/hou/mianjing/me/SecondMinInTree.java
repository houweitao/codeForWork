package hou.mianjing.me;

/**
 * @author houweitao
 * @date 2015年12月10日 下午5:02:33
 * http://www.1point3acres.com/bbs/thread-157915-1-1.html
 */

/*
give a tournment tree, the parent is the smallest of its children, the number of children is 0 or 2, find the second smallest one
e.g: 
               2
         2            3
     2     4       3    5
     
so the second smallest one is 3

follow up: the number of children is larger than 2
把寻找min和secMin结点的方式改为了遍历
*/

public class SecondMinInTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNodeThis root = new TreeNodeThis(1);
		root.left = new TreeNodeThis(1);
		root.left.left = new TreeNodeThis(1);
		root.left.left.left = new TreeNodeThis(1);
		root.left.left.right = new TreeNodeThis(3);
		root.left.right = new TreeNodeThis(4);
		root.left.right.left = new TreeNodeThis(4);
		root.left.right.right = new TreeNodeThis(6);

		root.right = new TreeNodeThis(5);
		root.right.left = new TreeNodeThis(5);
		root.right.right = new TreeNodeThis(7);

		SecondMinInTree sm = new SecondMinInTree();
		TreeNodeThis ret = sm.findSecMin(root);
		System.out.println(ret.val);
	}

	TreeNodeThis findSecMin(TreeNodeThis root) {
		if (root.left == null || root == null)
			return null;
		else if (root.left.left == null)
			return root.right;
		else if (root.right.val < findSecMin(root.left).val)
			return root.right;
		else
			return findSecMin(root.left);
	}
}

class TreeNodeThis {
	int val;
	TreeNodeThis left;
	TreeNodeThis right;

	TreeNodeThis(int val) {
		this.val = val;
	}
}
