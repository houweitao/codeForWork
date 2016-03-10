package hou.mianjing.me;

/**
 * @author houweitao 2015年9月10日 上午10:59:43
 */

public class PrintTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Tree tree = new Tree(1);
		tree.left = new Tree(2);
		tree.right = new Tree(3);

		tree.left.left = new Tree(4);
		tree.right.left = new Tree(5);
		tree.left.right=new Tree(10);
		PrintTree pt = new PrintTree();
		pt.printTree(tree);
	}

	void printTree(Tree tree) {
		if (tree == null)
			return;
		// System.out.print(tree.val);

		if (tree.left != null)
			System.out.print(tree.left.val+" ");
		else 
			System.out.print("# ");
		if (tree.right != null)
			System.out.print(tree.right.val+" ");
		else
			System.out.print("# ");

		printTree(tree.left);
		printTree(tree.right);
	}
}
