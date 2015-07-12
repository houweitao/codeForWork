package code.LeetCode;

/**
 * @author houweitao 2015年7月12日 下午3:01:53
 *         https://leetcode.com/problems/invert-binary-tree/
 */

public class InvertBinaryTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		InvertBinaryTree ibt = new InvertBinaryTree();
//		TreeNode tn = ibt.build(11);
		TreeNode tn = new TreeNode();
		
//		TreeNode left = ibt.build(2);
//		TreeNode right = ibt.build(3);
	
		TreeNode left = new TreeNode(2);
		TreeNode right = new TreeNode(3);
		
//		left.setVal(2);
//		left.left=null;
//		left.right=null;
		
//		right.val = 3;
//		right.left=null;
//		right.right=null;
		
		TreeNode l1=new TreeNode(4);
		TreeNode l2=new TreeNode(5);
		
		left.left=l1;
		left.right = l2;
		
		tn.setVal(1);
		tn.setLeft(left);
		tn.setRight(right);
		
		ibt.treeToString(tn);
//		tn.toString(tn);
		System.out.println("reverse");
		ibt.reverse(tn);
		tn.toString(tn);
//		ibt.treeToString(tn);
	}

	private  TreeNode build(int i) {
		// TODO Auto-generated method stub
		TreeNode tn = null;
		tn.val = 9;
		tn.left = null;
		tn.right = null;
		return tn;
	}
	
	void treeToString(TreeNode tn)
	{
		System.out.println(tn.val);
//		if (tn.left != null)
//			System.out.println(tn.left.val);
//		if (tn.right != null)
//			System.out.println(tn.right.val);

		if (tn.left != null)
			treeToString(tn.left);
		if (tn.right != null)
			treeToString(tn.right);
		
	}

	void reverse(TreeNode tn) {
		if (tn.left != null && tn.right != null) {
			TreeNode tmpTeee = tn.left;
			tn.left = tn.right;
			tn.right = tmpTeee;

			reverse(tn.left);
			reverse(tn.right);
		}
	}
	
	void buildTreeNode(){
		
	}
}
