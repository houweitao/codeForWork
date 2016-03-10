package hou.structrue.tree;

/**
 * @author houweitao 2015年8月8日 下午10:24:24
 */

//public class Node {
//	int key;
//	Node left;
//	Node right;
//
//	public Node(int key) {
//		// Node node = new Node();
//		// node.key =key;
//		// node.left=null;
//		// node.right=null;
//		// return node;
//
//		this.key = key;
//	}
//}


class Node
{
    /*
    *   balanceFactor=H(left) - H(right) 
    */
    int key = 0;
    Node left;
    Node right;
    public Node(int key){
        this.key =  key;
    }

    public static Node copy(Node p){
        Node tmp = new Node(p.key);
        tmp.left = p.left;
        tmp.right = p.right;
        return tmp;
    }
}
