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

import hou.oschina.single.JsoupLoginIteye;

/**
 * @author houweitao
 * 2015年7月16日 上午10:21:47
 */

public class JsoupLoginCSDN {


		public static void main(String[] args) throws Exception {

			JsoupLoginCSDN jli = new JsoupLoginCSDN();
			jli.login("hou103880@163.com", "password");// 输入Iteye的用户名，和密码

		}

		/**
		 * 模拟登陆Iteye
		 * 
		 * @param userName
		 *            用户名
		 * @param pwd
		 *            密码
		 * 
		 **/
		public void login(String userName, String pwd) throws Exception {

			// 第一次请求
			Connection con = Jsoup.connect("https://passport.csdn.net/account/login");// 获取连接
			con.header("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64; rv:29.0) Gecko/20100101 Firefox/29.0");// 配置模拟浏览器
			Response rs = con.execute();// 获取响应
			Document d1 = Jsoup.parse(rs.body());// 转换为Dom树
			
//			System.out.println(d1.select("body"));
			
			List<Element> et = d1.select("#fm1");// 获取form表单，可以通过查看页面源码代码得知

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
			Connection con2 = Jsoup.connect("https://passport.csdn.net/account/login");
			con2.header("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64; rv:29.0) Gecko/20100101 Firefox/29.0");
			// 设置cookie和post上面的map数据
			Response login = con2.ignoreContentType(true).method(Method.POST).data(datas).cookies(rs.cookies()).execute();
			// 打印，登陆成功后的信息
			System.out.println(login.body());

			// 登陆成功后的cookie信息，可以保存到本地，以后登陆时，只需一次登陆即可
			Map<String, String> map = login.cookies();
			for (String s : map.keySet()) {
				System.out.println(s + "      " + map.get(s));
			}
//			System.out.println("cookie:"+login.cookies().toString());
			
			
			Document con3 = Jsoup.connect("http://msg.csdn.net/letters").cookies(map).timeout(10000).get();
//			con3.header("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64; rv:29.0) Gecko/20100101 Firefox/29.0");
			// 设置cookie和post上面的map数据
//			Response letter = con3.ignoreContentType(true).method(Method.POST).data(datas).cookies(login.cookies()).execute();
			// 打印，登陆成功后的信息
			System.out.println("#########我的私信##########");
			System.out.println(con3);

			// 登陆成功后的cookie信息，可以保存到本地，以后登陆时，只需一次登陆即可
//			Map<String, String> map = login.cookies();
//			for (String s : map.keySet()) {
//				System.out.println(s + "      " + map.get(s));
//			}
		}
	}
