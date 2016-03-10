package hou.mianjing.me;

/**
 * @author houweitao
 * @date 2016年2月12日上午1:41:27
 * @end 2016年02月12日01:57:24
 * @Source http://www.1point3acres.com/bbs/thread-170305-1-1.html
 * @ps 好像记录下路径，用01的方式会更好些。。
 */

public class DistanceOfNode {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	int getDis(BTreeNode root, BTreeNode first, BTreeNode second) {
		NodeDep f = dep(root, first);
		NodeDep s = dep(root, second);

		if (f.dir == Dir.self)
			return s.dep;
		else if (s.dir == Dir.self)
			return f.dep;
		else if (f.dir != s.dir)
			return f.dep + s.dep;
		else {
			if (f.dir == Dir.left)
				return getDis(root.left, first, second);
			else
				return getDis(root.right, first, second);
		}
	}

	NodeDep dep(BTreeNode root, BTreeNode find) {
		if (root == null)
			return null;
		else if (root.val == find.val)
			return new NodeDep(Dir.self, 0);
		else {
			NodeDep left = dep(root.left, find);
			NodeDep right = dep(root.right, find);

			if (left != null) {
				left.dir = Dir.left;
				left.dep++;
				return left;
			} else if (right != null) {
				right.dir = Dir.right;
				right.dep++;
				return right;
			} else
				return null;
		}
	}

}

class NodeDep {
	Dir dir;
	int dep;

	NodeDep(Dir dir, int dep) {
		this.dep = dep;
		this.dir = dir;
	}
}

enum Dir {
	self, left, right
}