package hou.leetcode.single;

import java.util.Stack;

/**
 * @author houweitao
 * @date 2015年12月7日 下午4:02:12
 * @end 2015年12月7日16:10:48
 * https://leetcode.com/problems/implement-queue-using-stacks/
 */

public class ImplementQueueUsingStacks {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

class MyQueue {
	Stack<Integer> s1 = new Stack<Integer>();
	Stack<Integer> s2 = new Stack<Integer>();

	// Push element x to the back of queue.
	public void push(int x) {
		if (s2.isEmpty())
			s1.push(x);
		else {
			while (!s2.isEmpty())
				s1.push(s2.pop());
			s1.push(x);
		}

	}

	// Removes the element from in front of queue.
	public void pop() {
		if (!s1.isEmpty()) {
			while (!s1.isEmpty()) {
				s2.push(s1.pop());
			}
			s2.pop();
		} else if (!s2.isEmpty())
			s2.pop();
	}

	// Get the front element.
	public int peek() {
		if (!s1.isEmpty()) {
			while (!s1.isEmpty()) {
				s2.push(s1.pop());
			}
			return s2.peek();
		} else
			return s2.peek();
	}

	// Return whether the queue is empty.
	public boolean empty() {
		return s1.isEmpty() && s2.isEmpty();
	}
}