package hou.leetcode.single;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author houweitao
 * @date 2015年11月20日 下午4:22:30
 * @end 2015年11月20日16:30:28
 * https://leetcode.com/problems/implement-stack-using-queues/
 * 使用一个队列的方法：https://leetcode.com/discuss/39898/one-queue-java-solution
 */

public class ImplementStackUsingQueues {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

class MyStack {

	Queue<Integer> q1 = new LinkedList<>();
	Queue<Integer> q2 = new LinkedList<>();

	// Push element x onto stack.
	public void push(int x) {
		q1.offer(x);
	}

	// Removes the element on top of the stack.
	public void pop() {
		while (q1.size() > 1)
			q2.offer(q1.poll());
		q1.clear();
		while (q2.size() > 0)
			q1.offer(q2.poll());
	}

	// Get the top element.
	public int top() {
		while (q1.size() > 1)
			q2.offer(q1.poll());
		int ret = q1.peek();
		q2.offer(q1.poll());
		while (q2.size() > 0)
			q1.offer(q2.poll());
		return ret;
	}

	// Return whether the stack is empty.
	public boolean empty() {
		if (q1.size() == 0)
			return true;
		else
			return false;
	}
}