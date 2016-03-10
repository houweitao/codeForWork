package hou.guanggu.infosource;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

/**
 * @author houweitao
 * @date 2015年12月24日 上午10:09:32
 * @end 2015年12月24日10:12:32
 * @souce http://www.cnblogs.com/shishm/articles/1614407.html
 */

public class UrlEncodeDecode {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			System.out.println(URLEncoder.encode("漂亮", "GBK"));
			System.out.println(URLDecoder.decode("%C6%AF%C1%C1", "GBK"));
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
