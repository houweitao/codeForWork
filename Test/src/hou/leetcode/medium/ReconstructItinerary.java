package hou.leetcode.medium;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

/**
 * @author houweitao
 * @date 2016年3月1日 上午9:54:05
 * @bug 可能找不到。再写一个dfs吧
 * 2016年3月1日10:58:02
 * https://leetcode.com/problems/reconstruct-itinerary/
 */

public class ReconstructItinerary {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[][] tickets =
//			{ { "JFK", "SFO" }, { "JFK", "ATL" }, { "SFO", "ATL" }, { "ATL", "JFK" },{ "ATL", "SFO" } };
//			{{"MUC","LHR"},{"JFK","MUC"},{"SFO","SJC"},{"LHR","SFO"}};
			{{"JFK","KUL"},{"JFK","NRT"},{"NRT","JFK"}};
		
		ReconstructItinerary ri = new ReconstructItinerary();
//		ri.test(tickets);

		System.out.println(ri.findItinerary(tickets));

	}

	void test(String[][] tickets) {
		HashSet<Ticket> hs = new HashSet<>();
		for (int i = 0; i < tickets.length; i++) {
			hs.add(new Ticket(tickets[i][0], tickets[i][1]));
		}
		System.out.println(hs.size());
		hs.remove(new Ticket(tickets[1][0], tickets[1][1]));
		System.out.println(hs.size());

		System.out.println(pre(new Ticket("JFK", "SFO"), new Ticket("JFK", "ATL")).toString());
	}

	public List<String> findItinerary(String[][] tickets) {
		List<String> ret = new LinkedList<>();
		HashSet<Ticket> hs = new HashSet<>();

		for (int i = 0; i < tickets.length; i++) {
			hs.add(new Ticket(tickets[i][0], tickets[i][1]));
		}
		ret.add("JFK");
		String from = "JFK";
		while (!hs.isEmpty()) {
			from = findNext(from, hs);
			ret.add(from);
		}

		return ret;
	}

	private String findNext(String from, HashSet<Ticket> hs) {
		// TODO Auto-generated method stub
		Ticket tar = null;
		for (Ticket ticket : hs) {
			if (ticket.from.equals(from)) {
				if (tar == null)
					tar = ticket;
				else {
					tar = pre(tar, ticket);
				}
			}
		}
		System.out.println(tar.toString());
		hs.remove(tar);
		return tar.to;
	}

	private Ticket pre(Ticket tar, Ticket ticket) {
		String left = tar.to;
		String right = ticket.to;

		for (int i = 0; i < 3; i++) {
			if (left.charAt(i) < right.charAt(i))
				return tar;
			else if (left.charAt(i) > right.charAt(i))
				return ticket;
		}

		return tar;
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
