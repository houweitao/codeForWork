package hou.mianjing.me;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import hou.mianjing.me.LowestCommonAncestorForAnyTree.TreeNode;

/**
 * @author houweitao
 * @date 2016年1月10日 下午3:50:37
 * @noDO 2016年1月10日16:14:24
 * 原理知道但是太麻烦了。这里完全没体现出hashmap的优势。需要equals hashcode之类的函数。先不做了。
 * http://www.1point3acres.com/bbs/thread-162900-1-1.html
 */

public class MakeTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	HashMap<TreeNode, Integer> getTree(List<Couple> nodeList) {
		HashMap<TreeNode, Integer> ret = new HashMap<TreeNode, Integer>();
		HashMap<TreeNode, Integer> nodes = new HashMap<TreeNode, Integer>();

		for (int i = 0; i < nodeList.size(); i++) {
			if(!dealHashMap(ret,nodeList.get(i))){
				ret.put(getNode(nodes,nodeList.get(i)), 1);
			}
		}
		return ret;
	}

	boolean dealHashMap(HashMap<TreeNode, Integer> hm, Couple couple) {
		for (TreeNode node : hm.keySet()) {
			if (node.val == couple.a)
				return true;
		}
		return false;
	}

	TreeNode getNode(HashMap<TreeNode, Integer> nodes, Couple couple) {
		for (TreeNode node : nodes.keySet()) {
			if (node.val == couple.a) {
				node.children.add(new TreeNode(couple.b));
				return node;
			}
		}
		TreeNode ret = new TreeNode(couple.a);
		ret.children.add(new TreeNode(couple.b));
		nodes.put(ret, 1);
		return ret;
	}
	
	static class TreeNode {
		int val;
		ArrayList<TreeNode> children;

		public TreeNode(int val) {
			this.val = val;
			children = new ArrayList<>();
		}
	}

}

class Couple {
	int a;
	int b;

	Couple(int a, int b) {
		this.a = a;
		this.b = b;
	}

	Couple() {
		this.a = (int) (Math.random() * 10);
		this.b = (int) (Math.random() * 10);
	}
}
