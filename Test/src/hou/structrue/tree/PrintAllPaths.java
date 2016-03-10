package hou.structrue.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author houweitao
 * @date 2015年11月19日 下午12:51:14
 * @end 2015年11月19日13:40:52
 * http://www.1point3acres.com/bbs/thread-148413-1-1.html
 * 求一颗任意树（不一定是二叉树）所有最深叶子节点（数量可以是大于等于1的任意值，取决于树的结构）的最深公共前驱节点。
 */

public class PrintAllPaths {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PrintAllPaths pp = new PrintAllPaths();
		Node node = pp.buildNode();
		List<List<Node>> ret = pp.printPath(node);

		System.out.println(node.key + ret.size());

		for (int i = 0; i < ret.size(); i++) {
			for (int j = 0; j < ret.get(i).size(); j++) {
				System.out.print(ret.get(i).get(j).key + ",");
			}
			System.out.println();
		}

		List<List<Node>> finalList = new ArrayList<List<Node>>();
		int maxLength = 0;
		for (int i = 0; i < ret.size(); i++) {
			if (ret.get(i).size() > maxLength) {
				maxLength = ret.get(i).size();
				finalList.clear();
				finalList.add(ret.get(i));
			} else if (ret.get(i).size() == maxLength) {
				finalList.add(ret.get(i));
			}
		}

		Node parent = pp.getCommonParrent(finalList);
		System.out.println("parent:" + parent.key);

	}

	private Node getCommonParrent(List<List<Node>> finalList) {
		// TODO Auto-generated method stub
		int size = finalList.size();
		if (size == 1)
			return finalList.get(0).get(0);
		else {
			Node cur = finalList.get(0).get(0);
			Node pre = null;
			for (int j = 0; j < finalList.get(0).size(); j++) {
				for (int i = 0; i < finalList.size(); i++) {
					if (finalList.get(i).get(j) != cur) {
						return pre;
					}
				}
				pre = cur;
				if (j != finalList.get(0).size() - 1)
					cur = finalList.get(0).get(j + 1);
			}
		}
		return null;
	}

//	这里可以剪枝，如果右子树的长度明显比左子树要短，那么直接排除即可。
	List<List<Node>> printPath(Node node) {
		List<List<Node>> ret = new ArrayList<List<Node>>();
//		ArrayList<Node> tmp = new ArrayList<Node>();

		if (node == null)
			return ret;
		else if (node.left == null && node.right == null) {
			ArrayList<Node> tmp = new ArrayList<Node>();
			tmp.add(node);
			ret.add(tmp);
			return ret;
		} else {
			List<List<Node>> left = printPath(node.left);
			if (!left.isEmpty()) {
				for (int i = 0; i < left.size(); i++) {
					ArrayList<Node> tmp = new ArrayList<Node>();
					tmp.add(node);
					tmp.addAll(left.get(i));
					ret.add(tmp);
				}
			}

			List<List<Node>> right = printPath(node.right);
			if (!right.isEmpty()) {
				for (int i = 0; i < right.size(); i++) {
					ArrayList<Node> tmp = new ArrayList<Node>();
					tmp.add(node);
					tmp.addAll(right.get(i));
					ret.add(tmp);
				}
			}
		}

		return ret;
	}

	Node buildNode() {
		Node node = new Node(3);

		node.left = new Node(9);

		node.left.left = new Node(200);
		node.right = new Node(20);
		node.right.left = new Node(15);
		node.right.right = new Node(7);
		node.right.right.left = new Node(70);

		node.right.left.left = new Node(100);
		node.right.left.right = new Node(101);

		return node;
	}
}
