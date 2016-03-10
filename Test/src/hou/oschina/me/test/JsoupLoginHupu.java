package hou.oschina.me.test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.Connection.Method;
import org.jsoup.Connection.Response;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

/**
 * @author houweitao 2015年7月16日 上午11:25:11
 */

public class JsoupLoginHupu {

	public static void main(String[] args) throws Exception {

		JsoupLoginHupu jlh = new JsoupLoginHupu();
		jlh.login("userId", "password");// 输入Iteye的用户名，和密码

	}

	/**
	 * 模拟登陆hoopchina
	 * 
	 * @param userName
	 *            用户名
	 * @param pwd
	 *            密码
	 *            
	 *            ctrl+shift+j，然后输入document.cookie回车
	 * 
	 **/
	public void login(String userName, String pwd) throws Exception {

		// 第一次请求
		Connection con = Jsoup.connect("http://my.hupu.com/");// 获取连接
		con.header("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64; rv:29.0) Gecko/20100101 Firefox/29.0");// 配置模拟浏览器
		Response rs = con.execute();// 获取响应
		Document d1 = Jsoup.parse(rs.body());// 转换为Dom树

		// System.out.println(d1.select("body"));

		List<Element> et = d1.select("#index_reg");// 获取form表单，可以通过查看页面源码代码得知

		 System.out.println(et);
		
		// 获取，cooking和表单属性，下面map存放post时的数据
		Map<String, String> datas = new HashMap<>();
		for (Element e : et.get(0).getAllElements()) {
			if (e.attr("name").equals("username")) {
				e.attr("value", userName);// 设置用户名
			}

			if (e.attr("name").equals("password")) {
				e.attr("value", pwd); // 设置用户密码
			}

			if (e.attr("name").length() > 0) {// 排除空值表单属性
				datas.put(e.attr("name"), e.attr("value"));
			}
		}

		/**
		 * 第二次请求，post表单数据，以及cookie信息
		 * 
		 **/
		Connection con2 = Jsoup.connect("http://my.hupu.com/login");
		con2.header("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64; rv:29.0) Gecko/20100101 Firefox/29.0");
		// 设置cookie和post上面的map数据
		Response login = con2.ignoreContentType(true).method(Method.POST).data(datas).cookies(rs.cookies()).execute();
		// 打印，登陆成功后的信息
		System.out.println(login.body());

		// 登陆成功后的cookie信息，可以保存到本地，以后登陆时，只需一次登陆即可
		Map<String, String> map =  
//				new HashMap<>();
				login.cookies();
		
//		map.put("_dacevid3","c848bf5d.52a5.fd37.a1e5.a15ed1eaa721");
//		map.put("HUPUSSOID","b830e5f2-4646-4b7c-8342-c0661775fd60");
//		map.put("PHPSESSID","u4jr5vkcbtnh1vsppp72jna257");
//		map.put("u","14535515|5oiR5Y+q6IO95ZG15ZG1|afe8|28240ffa8e8e7aa3a87a55f19ea272e3|8e8e7aa3a87a55f1");
//		map.put("ua","89815856");
//		map.put("dacevst","f4d58eab.52d5fcc6|1437055566615");
//		map.put("CNZZDATA30020080","cnzz_eid%3D174751465-1437052208-%26ntime%3D1437052208");
//		map.put("_cnzz_CV30020080","buzi_cookie%7Cc848bf5d.52a5.fd37.a1e5.a15ed1eaa721%7C-1");
		
		for (String s : map.keySet()) {
			System.out.println(s + "      " + map.get(s));
		}
		 System.out.println("cookie:"+login.cookies().toString());

		Document con3 = Jsoup.connect("http://my.hupu.com").cookies(map).timeout(10000).userAgent(
				"Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.31 (KHTML, like Gecko) Chrome/26.0.1410.64 Safari/537.31")
		.get();
		// 设置cookie和post上面的map数据
		// 打印，登陆成功后的信息
		System.out.println("#########我的首页##########");
//		System.out.println(con3);
	}
}
