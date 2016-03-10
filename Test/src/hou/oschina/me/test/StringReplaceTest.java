package hou.oschina.me.test;

/**
 * @author houweitao 2015年7月16日 上午9:22:08
 */

public class StringReplaceTest {
	public static void main(String[] args) {
//		String url = "http://img3.douban.com/view/photo/thumb/public/p787206054.jpg";
		String url = "thumppp";
		url=url.replaceAll("thump", "raw");
		System.out.println(url);
	}
}
