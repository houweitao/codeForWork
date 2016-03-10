package hou.oschina.me;

/**
 * @author houweitao 2015年7月15日 上午10:29:10
 */

public class DealURL {

	static void printShuzu(String[] shuzu) {
		for (int i = 0; i < shuzu.length; i++) {
			System.out.println(shuzu[i]);
		}
		System.out.println();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String url = "http://ww4.sinaimg.cn/mw600/005SJH8qgw1eu2kjfrzidj30dw0kuwgj.jpg";

		String[] website = url.split("//");
		printShuzu(website);
		String[] names = website[1].split("/");
		printShuzu(names);
		
		System.out.println(names[names.length-1]);

	}

}
