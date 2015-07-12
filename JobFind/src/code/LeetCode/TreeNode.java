package code.LeetCode;

/**
 * @author houweitao 2015年7月12日 下午3:34:11
 */

public class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	public void toString(TreeNode tn) {
		System.out.println(tn.val);
//		if (tn.left != null)
//			System.out.println(tn.left.val);
//		if (tn.right != null)
//			System.out.println(tn.right.val);

		if (tn.left != null)
			toString(tn.left);
		if (tn.right != null)
			toString(tn.right);

	}

	public void build(int val, TreeNode left, TreeNode right) {
		this.val = val;
		this.left = left;
		this.right = right;
	}

	public void build(int val) {
		this.val = val;
	}

	public int getVal() {
		return val;
	}

	public void setVal(int val) {
		this.val = val;
	}

	public TreeNode getLeft() {
		return left;
	}

	public void setLeft(TreeNode left) {
		this.left = left;
	}

	public TreeNode getRight() {
		return right;
	}

	public void setRight(TreeNode right) {
		this.right = right;
	}

	TreeNode(int x) {
		val = x;
	}

	TreeNode() {
		val = 0;
	}
}
