package hou.leetcode.medium;

/**
 * @author houweitao
 * @date 2015年11月24日 下午1:09:06
 * https://leetcode.com/problems/add-two-numbers/
 * @..日了狗 2015年11月24日14:11:30
 * @再日.. 2015年11月24日14:35:19
 */

public class AddTwoNumbers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode l1 = new ListNode(1);
//		l1.next = new ListNode(8);
//		l1.next.next = new ListNode(0);

		ListNode l2 = new ListNode(9);
		l2.next = new ListNode(9);
//		l2.next.next = new ListNode(4);

		AddTwoNumbers ant = new AddTwoNumbers();
		ListNode ret = ant.addTwoNumbers(l1, l2);
		
		while (ret != null) {
			System.out.print(ret.val + ",");
			ret = ret.next;
		}
	}

	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode ret = new ListNode(0);
		ListNode help = ret;

		if (l1 == null && l2 == null)
			return null;
		else {
			int nextAdd = 0;
			while (l1 != null && l2 != null) {
				int tmp = l1.val + l2.val + nextAdd;
				if (tmp >= 10) {
					nextAdd = tmp / 10;
					tmp = tmp % 10;
				} else
					nextAdd = 0;
				
				ListNode n=new ListNode(tmp);
				ret.next = n;
				ret=ret.next;
				l1 = l1.next;
				l2 = l2.next;
			}

			if(l1==null&&l2==null&&nextAdd!=0){
				ret.next=new ListNode(nextAdd);
			}
				
			
			if (l1 != null) {
				l1.val=l1.val+nextAdd;
				int add=0;
				if(l1.val>=10)
				{
					add=l1.val/10;
					l1.val=l1.val%10;
				}
				ret.next = l1;
			}
			if (l2 != null) {
				l2.val=l2.val+nextAdd;
				
				ret.next = l2;
			}
		}
		return dealList(help.next);

	}
	
	ListNode dealList(ListNode list){
		ListNode ret=list;
		ListNode p=list,q=list.next;
		while(q!=null){
			if(q.val!=0)
				p=q;
			q=q.next;
		}
		p.next=null;
		
		return ret;
	}
	
}
