package hou.leetcode.single;

/**
 * @author houweitao 2015年7月16日 下午2:28:09
 */

public class InorderandPostorderTree {

	public String getTree(String inOrder, String postOrder) {
		String preOrder = null;
		int inLength = inOrder.length();
		int postLength = postOrder.length();

//		char rootPost = findRootPost(postOrder.charAt(inLength - 1), inOrder);

		char root = postOrder.charAt(postLength - 1);
		char left = findLeft(inOrder, postOrder);
		System.out.println(left);
		
		return preOrder;
	}

	private char findLeft(String inOrder, String postOrder) {
		// TODO Auto-generated method stub
		char root = postOrder.charAt(postOrder.length() - 1);
		int rootDot = 0;
		char rootPost = 0;
		char rootPostPre = 0;
		
		for (int i = 1; i < inOrder.length(); i++) {
			if (inOrder.charAt(i) == root) {
				rootDot = i;
				if (i != inOrder.length() - 1)
					rootPost = inOrder.charAt(i + 1);
				break;
			}
		}

		if (rootPost == 0)
				return 0;
		
		for (int i = 1; i < postOrder.length(); i++) {
			if (postOrder.charAt(i) == rootPost) {
				rootDot = i;
				if (i != postOrder.length() - 1)
					rootPostPre = inOrder.charAt(i - 1);
			}
		}
		
		return rootPostPre;
	}

//	private char findRootPost(char s, String inOrder) {
//		// TODO Auto-generated method stub
//
//		return null;
//	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
//		String inorder="8,4,2,5,9,1,10,";
		
		InorderandPostorderTree test = new InorderandPostorderTree();
//		test.getTree(inOrder, postOrder)

	}

}
