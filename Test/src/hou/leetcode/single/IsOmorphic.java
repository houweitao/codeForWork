package hou.leetcode.single;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author houweitao
 * 2015年9月6日 上午9:52:19
 * https://leetcode.com/problems/isomorphic-strings/
 * http://blog.csdn.net/xudli/article/details/45386777
 * http://blog.csdn.net/lan_liang/article/details/48226703
 */

public class IsOmorphic {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		IsOmorphic io=new IsOmorphic();
		boolean a = io.IsIsomorphic("add", "egg");
		System.out.println(a);
	}
	
	 boolean IsIsomorphic(String s, String t) {  
//        HashMap<Character, Long> hash1 = new HashMap<Character, Long>();
//        HashMap<Character, Long> hash2 = new HashMap<Character, Long>();
//        
//        for(int i = 0;i < s.length(); i++){  
//            if(!hash1.containsKey(s.charAt(i))){  
//                hash1.put(s.charAt(i), (long) i);  
//                if(hash2.containsKey(t.charAt(i))){  
//                    return false;  
//                }  
//                hash2.put(t.charAt(i),(long) i);  
//            }  
//            else{  
//                if(!hash2.containsKey(t.charAt(i)) || hash2.get(t.charAt(i)) != hash1.get(s.charAt(i))){  
//                    return false;  
//                }  
//                
//                hash1.put(s.charAt(i),(long) i);
//                hash2.put(t.charAt(i),(long) i);
//            }  
//        }  
//          
//        return true;  
		 
		 
		 
	        //init check  
	        if(s==null || t==null) return false;  
	        if(s.length() != t.length()) return false;  
	          
	        Map<Character, Character> map = new HashMap<Character, Character>();  
	        Set<Character> set = new HashSet<Character>();  
	          
	        for(int i=0; i<s.length(); i++) {  
	            char c1 = s.charAt(i);  
	            char c2 = t.charAt(i);  
	              
	            if(map.containsKey(c1)) {  
	                if(map.get(c1) != c2) return false;  
	            } else {  
	                if(set.contains(c2)) return false;  
	                else {  
	                    map.put(c1, c2);  
	                    set.add(c2);  
	                }  
	            }  
	        }  
	        return true;  
    }  
}
