package hou.oschina.me.test;

import java.util.HashMap;
import java.util.Map;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;


/**
 * @author houweitao
 * 2015年7月16日 下午9:50:44
 */

public class JsoupLoginHupuEasy {

		public static void main(String[] args) throws Exception {

			JsoupLoginHupuEasy jlh = new JsoupLoginHupuEasy();
			jlh.login();// 输入Iteye的用户名，和密码

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
		public void login() throws Exception {


			// 登陆成功后的cookie信息，可以保存到本地，以后登陆时，只需一次登陆即可
			Map<String, String> map =  new HashMap<>();
			
			map.put("_dacevid3","c848bf5d.52a5.fd37.a1e5.a15ed1eaa721");
			map.put("HUPUSSOID","b830e5f2-4646-4b7c-8342-c0661775fd60");
			map.put("PHPSESSID","u4jr5vkcbtnh1vsppp72jna257");
			map.put("u","14535515|5oiR5Y+q6IO95ZG15ZG1|afe8|28240ffa8e8e7aa3a87a55f19ea272e3|8e8e7aa3a87a55f1");
			map.put("ua","89815856");
			map.put("dacevst","f4d58eab.52d5fcc6|1437055566615");
			map.put("CNZZDATA30020080","cnzz_eid%3D174751465-1437052208-%26ntime%3D1437052208");
			map.put("_cnzz_CV30020080","buzi_cookie%7Cc848bf5d.52a5.fd37.a1e5.a15ed1eaa721%7C-1");
			
			for (String s : map.keySet()) {
				System.out.println(s + "      " + map.get(s));
			}

			Document con3 = Jsoup.connect("http://my.hupu.com").cookies(map).timeout(10000).userAgent(
					"Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.31 (KHTML, like Gecko) Chrome/26.0.1410.64 Safari/537.31")
			.get();
			// 设置cookie和post上面的map数据
			// 打印，登陆成功后的信息
			System.out.println("#########我的首页##########");
			System.out.println(con3);
		}
	}
