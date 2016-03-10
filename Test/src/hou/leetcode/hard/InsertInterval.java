package hou.leetcode.hard;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/**
 * @author houweitao
 * @date 2016年3月1日 下午3:24:52
 */

public class InsertInterval {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		List<Integer> list = new LinkedList<>();
		for (int i = 0; i < 10; i++)
			list.add(i);

		for (int i : list) {
			System.out.println(i);
//			list.remove(i);
		}

		List<Interval> intervals = new LinkedList<>();
		intervals.add(new Interval(1, 2));
		intervals.add(new Interval(3, 5));
		intervals.add(new Interval(6, 7));
		intervals.add(new Interval(8, 10));
		intervals.add(new Interval(12, 16));

		System.out.println(intervals);

		Interval newInterval = new Interval(4, 9);

		InsertInterval ii = new InsertInterval();
		System.out.println(ii.insert(intervals, newInterval));
	}

	public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
		List<Interval> ret = new LinkedList<>();

		Collections.sort(intervals, new Comparator<Interval>() {
			@Override
			public int compare(Interval i1, Interval i2) {
				return Integer.compare(i1.start, i2.start);
			}
		});

		for (Interval tar : intervals) {
			if (tar.start > newInterval.end || tar.end < newInterval.start)
				ret.add(tar);
			else {
//				intervals.remove(tar);
				newInterval = merge(tar, newInterval);
			}
		}
		ret.add(newInterval);

		Collections.sort(ret, new Comparator<Interval>() {
			@Override
			public int compare(Interval i1, Interval i2) {
				return Integer.compare(i1.start, i2.start);
			}
		});
		return ret;
	}

	private Interval merge(Interval tar, Interval in) {
		return new Interval(Math.min(in.start, tar.start), Math.max(tar.end, in.end));
	}
}
