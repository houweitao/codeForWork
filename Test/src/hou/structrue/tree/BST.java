package hou.structrue.tree;

/**
 * @author houweitao
 * 2015年8月8日 下午10:23:02
 */

import java.util.*;

/*
* 二分法查找
*/
public class BST {
	public static Node root = null;

	public static void main(String[] args) {
		System.out.println("Hello World!");
		// int[] values = createValue();
		// int[] values = {10,8,13,4,14,2,6,1,3,5,7};
		// int[] values = {1};
		int[] values = { 10, 8, 4, 2, 6, 1, 3, 5, 7 };
		System.out.println(Arrays.toString(values));
		createBST(values);
		printBST(root);
		System.out.println();
		System.out.print("Pls. select a operation(s for search, a for add, d for delete, q for quit,p for print):");
		Scanner scan = new Scanner(System.in);
		String str = scan.next();
		char select = str.charAt(0);
		while (true) {
			if (select == 'q') {
				break;
			}
			int key = 0;
			switch (select) {

			case 'a':
				System.out.println();
				System.out.print("(a)Input a integer:");
				key = scan.nextInt();
				addNode(key);
				printBST(root);
				break;
			case 'd':
				System.out.println();
				System.out.print("(d)Input a integer:");
				key = scan.nextInt();
				deleteNode(key);
				printBST(root);
				break;
			case 'p':
				printBST(root);
				break;
			case 's':
				System.out.println();
				System.out.print("(s)Input a integer:");
				key = scan.nextInt();
				if (search(key)) {
					System.out.println(key + "存在!");
				} else {
					System.out.println(key + "不存在！");
				}
				break;
			}
			System.out.println();
			System.out.print("Pls. select a operation(s for search, a for add, d for delete, q for quit,p for print):");
			str = scan.next();
			select = str.charAt(0);
		}

	}

	/*
	 * 产生随机的整数数组
	 */
	public static int[] createValue() {
		int size = new Random().nextInt(20);
		while (size == 0) {
			size = new Random().nextInt(20);
		}
		int[] values = new int[size];
		for (int i = 0; i < size; i++) {
			values[i] = new Random().nextInt(20000);
		}
		return values;
	}

	/*
	 * 构造BST
	 * 
	 */
	public static void createBST(int[] value) {

		for (int i = 0; i < value.length; i++) {
			addNode(value[i]);
		}
	}

	/*
	 * 中序遍历BST
	 */
	public static void printBST(Node p) {
		if (p == null) {
			return;
		} else {
			printBST(p.left);
			System.out.print(p.key + ",");
			printBST(p.right);
		}
		// System.out.println();
	}

	/*
	 * 查找
	 */
	public static boolean search(int key) {
		Node p = root;
		while (p != null) {
			if (p.key == key) {
				return true;
			} else if (key < p.key) {
				p = p.left;
			} else {
				p = p.right;
			}

		}
		return false;
	}

	/*
	 * 添加节点
	 */
	public static boolean addNode(int key) {
		// BST 是空树
		if (root == null) {
			root = new Node(key);
		} else {
			Node p = root;
			while (true) {
				int tmp = p.key;
				if (key == tmp) {
					return false;
				} else if (key < p.key) {
					if (p.left == null) {
						Node q = new Node(key);
						p.left = q;
						return true;
					} else {
						p = p.left;
					}
				} else {
					if (p.right == null) {
						Node q = new Node(key);
						p.right = q;
						return true;
					} else {
						p = p.right;
					}
				}
			}
		}
		return true;
	}

	/*
	 * 删除节点
	 */
	public static boolean deleteNode(int key) {
		Node q = null;
		Node p = root;
		// 标识当前节点是父节点的左节点（true）
		// 还是父节点的右节点（false）
		boolean flag = false;
		while (p != null) {
			System.out.println("p.key:" + p.key);
			if (p.key == key) {
				// p是叶子节点
				if (p.left == null && p.right == null) {
					if (q == null) {
						root = null;
					} else {
						if (flag) {
							q.left = null;
						} else {
							q.right = null;
						}
					}
				}
				// p的左子树或右子树是空
				else if (p.left == null || p.right == null) {
					if (q == null) {
						root = (p.left == null ? p.right : p.left);
					} else {
						if (flag) {
							q.left = (p.left == null ? p.right : p.left);
						} else {
							q.right = (p.left == null ? p.right : p.left);
						}
					}
				}
				// 左右子树都不为空
				else {
					Node k = p.left;
					while (k.right != null) {
						k = k.right;
					}
					if (q == null) {
						k.right = p.right;
						root = p.left;
					} else {
						k.right = p.right;
						q.left = p.left;
					}
				}
				return true;
			} else if (key < p.key) {
				q = p;
				p = p.left;
				flag = true;
			} else {
				q = p;
				p = p.right;
				flag = false;
			}
		}
		return false;
	}
}
