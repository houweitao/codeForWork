package hou.leetcode.single;

/**
 * @author houweitao
 * @date 2015年12月2日 上午1:11:59
 * @tips 递归比循环占资源多多了..
 * https://leetcode.com/problems/first-bad-version/
 * https://leetcode.com/discuss/62255/o-lgn-simple-java-solution
 */

public class FirstBadVersion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FirstBadVersion fbv = new FirstBadVersion();
		System.out.println(fbv.firstBadVersion(2126753390));
	}

	public int firstBadVersionBetter(int n) {
	    int start = 1, end = n;
	    while (start < end) {
	        int mid = start + (end-start) / 2;
	        if (!isBadVersion(mid)) start = mid + 1;
	        else end = mid;            
	    }        
	    return start;
	}
	
	
	public int firstBadVersion(int n) {
		return help(1, n);
	}

	private int help(int begin, int end) {
		System.out.println(begin + " to " + end);

		if (begin == end)
			if (isBadVersion(begin))
				return begin;
			else
				return begin + 1;

		if (begin + 1 == end) {
			if (isBadVersion(begin))
				return begin;
			else if (isBadVersion(end))
				return end;
			else
				return end + 1;
		}

		int mid = (begin + end) / 2;
		if (isBadVersion(mid)) {
			return help(begin, mid - 1);
		} else {
			return help(mid + 1, end);
		}
	}

	boolean isBadVersion(int version) {
		if (version > 2126753390)
			return true;
		else
			return false;
	}

}
