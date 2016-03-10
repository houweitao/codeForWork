package hou.csdn.single;

import java.util.Stack;

/**
 * @author houweitao 2015年9月2日 上午9:12:30
 *         http://www.cnblogs.com/wanghui9072229/archive/2011/11/22/2259391.html
 */

public class StackQueen {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StackQueen sq = new StackQueen();

		if (sq.stack1.empty())
			System.out.println("yes");

		sq.stack1.push(2);
		System.out.println(sq.stack1.pop());

		for (int i = 0; i < 10; i++)
			sq.push(i);

		sq.pop();

		System.out.println(sq.pop());
	}

	Stack<Integer> stack1 = new Stack<Integer>();
	Stack<Integer> stack2 = new Stack<Integer>();

	public void push(int node) {
		stack1.push(node);
	}

	public int pop() {
		if (!stack2.empty()) {
			int tmp = stack2.pop();
			System.out.println(tmp);
			return tmp;
		} else {
			while (!stack1.empty())
				stack2.push(stack1.pop());
			return stack2.pop();
		}
	}
}
