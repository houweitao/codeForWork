package hou.csdn.single;

/**
 * @author houweitao
 * 2015年9月17日 下午2:51:20
 * http://blog.csdn.net/aaawqqq/article/details/22813459
 */

public class GoodAndGbc {
	String str = new String("good");  
    char[] ch  = { 'a', 'b', 'c' };  
  
    public static void main(String[] args) {  
    	GoodAndGbc ex = new GoodAndGbc();  
        ex.change(ex.str, ex.ch);  
        System.out.print(ex.str + " and ");  
        System.out.print(ex.ch);  
    }  
  
    public void change(String str, char ch[]) {  
        str = "test ok ";  
        ch[0] = 'g';  
        
        System.out.print(str);  
        System.out.print(ch);  
        System.out.println();  
    }  
}
