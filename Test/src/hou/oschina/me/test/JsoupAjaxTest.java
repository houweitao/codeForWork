package hou.oschina.me.test;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.Connection.Method;
import org.jsoup.Connection.Request;
import org.jsoup.Connection.Response;
import org.jsoup.nodes.Document;

/**
 * @author houweitao
 * 2015年7月16日 下午8:49:21
 * Jsoup处理ajax
 */

public class JsoupAjaxTest {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		Map<String, String> datas = new HashMap<>();
		datas.put("page", "4");
		Connection con2 = Jsoup.connect("http://www.shihuo.cn/shihuo/ajaxYouhui");
		con2.header("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64; rv:29.0) Gecko/20100101 Firefox/29.0");
		// 设置cookie和post上面的map数据
		Response login = con2.ignoreContentType(true).method(Method.POST).data(datas).execute();
		// 打印，登陆成功后的信息
		System.out.println(login.body());
		
//		datas.put("username","%CE%D2%D6%BB%C4%DC%BA%C7%BA%C7");
//		datas.put("password","password");
//		datas.put("rememberme","1");
//		datas.put("charset","gb2312");
//		datas.put("jumpurl","http://my.hupu.com");
//		
//		Connection con2 = Jsoup.connect("http://passport.hupu.com/login?from=myIndex");
//		con2.header("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64; rv:29.0) Gecko/20100101 Firefox/29.0");
//		// 设置cookie和post上面的map数据
//		Response login = con2.ignoreContentType(true).method(Method.POST).data(datas).execute();
//		// 打印，登陆成功后的信息
//		System.out.println(login.body());
//		
//		System.out.println(login.cookies());
//		Map<String, String> map =login.cookies();
//		
//		Document con3 = Jsoup.connect("http://my.hupu.com").cookies(map).timeout(10000).userAgent(
//				"Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.31 (KHTML, like Gecko) Chrome/26.0.1410.64 Safari/537.31")
//		.get();
//		// 设置cookie和post上面的map数据
//		// 打印，登陆成功后的信息
//		System.out.println("#########我的首页##########");
//		System.out.println(con3);
		
		
		
	}

}
