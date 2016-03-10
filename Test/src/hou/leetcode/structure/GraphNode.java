package hou.leetcode.structure;

import java.util.LinkedList;

/**
 *@author houweitao
 *@date 2016年3月2日下午10:09:35
 */

public class GraphNode {
	public String val;
	public LinkedList<GraphNode> neighbor;
	
	public GraphNode(String val) {
		this.val=val;
		neighbor=new LinkedList<>();
	}
	
	@Override
	public int hashCode() {
		int ret=0;
		for(int i=0;i<val.length();i++)
			ret=ret+val.charAt(i)-'a';
		
		return ret;
	}
	
	@Override
	public boolean equals(Object obj) {
		GraphNode g=(GraphNode)obj;
		return this.val.equals(g.val);
	}
}
