package hou.leetcode.medium;

import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map.Entry;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

/**
 * @author houweitao
 * @date 2016年3月1日 上午10:58:21
 * @end 2016年3月1日11:26:46
 * 好像nice
 * https://leetcode.com/problems/reconstruct-itinerary/
 * @notEnd 2016年3月1日11:38:16 timeout
 */

public class ReconstructItinerary2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[][] tickets =
//				{ { "JFK", "SFO" }, { "JFK", "ATL" }, { "SFO", "ATL" }, { "ATL", "JFK" },{ "ATL", "SFO" } };
//				{{"MUC","LHR"},{"JFK","MUC"},{"SFO","SJC"},{"LHR","SFO"}};
//		{ { "JFK", "KUL" }, { "JFK", "NRT" }, { "NRT", "JFK" } };

		{ { "JFK", "SFO" }, { "JFK", "ATL" }, { "SFO", "ATL" }, { "ATL", "JFK" }, { "ATL", "SFO" } };
		ReconstructItinerary2 ri = new ReconstructItinerary2();
		System.out.println(ri.findItinerary(tickets));
	}

	public List<String> findItinerary(String[][] tickets) {
		List<String> ret = new LinkedList<>();
		Stack<Ticket> stack = new Stack<>();
		HashMap<Ticket, Queue<Ticket>> path = new HashMap<>();
		HashSet<Ticket> hs = new HashSet<>();
		for (int i = 0; i < tickets.length; i++) {
			hs.add(new Ticket(tickets[i][0], tickets[i][1]));
		}

		String from = "JFK";
		Ticket begin = new Ticket("begin", from);
		Queue<Ticket> queen = findPath(hs, from);
		path.put(begin, queen);

		stack.push(begin);

		while (!stack.isEmpty()) {
			Queue<Ticket> option = path.get(stack.peek());

			if (option.size() > 0) {
				Ticket first = option.poll();
//				while (stack.contains(first)) {
//					first = option.poll();
//				}
				if (first != null) {
					Queue<Ticket> next = findPath(hs, first.to);

					path.put(first, next);
					stack.push(first);
					if (stack.size() == hs.size() + 1) {
						for (int i = 0; i < stack.size(); i++) {
							ret.add(stack.get(i).to);
						}
						System.out.println(stack);
						return ret;
					}
				}
			} else {
				System.out.println(stack);
				stack.pop();
			}

		}
		
		for(Entry<Ticket, Queue<Ticket>> entry:path.entrySet()){
			System.out.println(entry.getKey()+" : "+entry.getValue());
		}
		
		return ret;
	}

	private Queue<Ticket> findPath(HashSet<Ticket> hs, String from) {
		// TODO Auto-generated method stub
		Comparator<Ticket> ticketComparator = new TicketComparator();
		Queue<Ticket> myQueue = new PriorityQueue<Ticket>(hs.size(), ticketComparator);

		for (Ticket ticket : hs) {
			if (ticket.from.equals(from)) {
				myQueue.add(ticket);
			}
		}

		return myQueue;
	}

	private int preTicket(Ticket tar, Ticket ticket) {
		String left = tar.to;
		String right = ticket.to;

		for (int i = 0; i < 3; i++) {
			if (left.charAt(i) < right.charAt(i))
				return -1;
			else if (left.charAt(i) > right.charAt(i))
				return 1;
		}
		return 0;
	}

	private class TicketComparator implements Comparator<Ticket> {
		@Override
		public int compare(Ticket a, Ticket b) {
			return preTicket(a, b);
		}
	}

	private class Ticket {
		String from;
		String to;

		Ticket(String from, String to) {
			this.from = from;
			this.to = to;
		}

		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return from + " " + to;
		}

		@Override
		public int hashCode() {
			String str = from + to;
			int ret = 0;
			for (int i = 0; i < str.length(); i++) {
				ret = ret + str.charAt(i) - 'A';
			}

			return ret;
		}

		@Override
		public boolean equals(Object obj) {
			boolean bres = false;
			if (obj instanceof Ticket) {
				Ticket o = (Ticket) obj;
				bres = (this.from.equals(o.from)) & (this.to.equals(o.to));
			}
			return bres;
		}
	}
}
