package hou.mianjing.me;

import java.util.HashMap;

/**
 * @author houweitao
 * 2015年9月21日 下午2:23:22
 * http://www.1point3acres.com/bbs/thread-141907-1-1.html
 */

public class RemoveDuplicateCharacters {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RemoveDuplicateCharacters rdc=new RemoveDuplicateCharacters();
		String str="Welcome";
		rdc.removeDuplicateCharacters(str);
	}

	void removeDuplicateCharacters(String str){
		HashMap<Character,Integer> charMap=new HashMap<Character, Integer>();
		char[] ch=str.toCharArray();
		
		for(int i=0;i<ch.length;i++)
		{
			if(!charMap.containsKey(ch[i]))
				charMap.put(ch[i], 1);
			else
			{
				int tmp = charMap.get(ch[i]);
				charMap.remove(ch[i]);
				charMap.put(ch[i],tmp+1);
			}
		}
		
//		for(char c:charMap.keySet())
//		{
//			if(charMap.get(c)==1)
//				System.out.print(c);
//		}
		
		for(int i=0;i<ch.length;i++)
		{
			if(charMap.get(ch[i])==1)
				System.out.print(ch[i]);
		}
	}
}
