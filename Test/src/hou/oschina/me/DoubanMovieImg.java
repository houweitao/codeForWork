package hou.oschina.me;

import java.io.BufferedInputStream;
import java.io.File;
//import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.Connection.Method;
import org.jsoup.Connection.Response;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 * @author houweitao 2015年7月16日 上午12:09:10
 */

public class DoubanMovieImg {
	void Crawler(String url, ArrayList<String> imgList, Map<String, String> cookies) {
		Document doc;
		try {
			doc =
			// Jsoup.connect(url).followRedirects(true).timeout(10000)
			// .userAgent("Mozilla/4.0 (compatible; MSIE 6.0; Windows NT
			// 5.0)").get();

			Jsoup.connect(url).cookies(cookies).timeout(10000)
					.userAgent(
							"Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.31 (KHTML, like Gecko) Chrome/26.0.1410.64 Safari/537.31")
					.get();

			Elements media = doc.select("div.cover").select("img[src]");
			for (Element src : media) {
				// if (src.tagName().equals("img"))
				// System.out.println("images:" + src);
				String img = src.attr("abs:src");
				img = img.replace("thumb", "photo");

				// Response resultImageResponse =
				// Jsoup.connect(img).cookies(cookies).ignoreContentType(true).execute();
				//
				// String[] website = img.split("//");
				// // printShuzu(website);
				// String[] names = website[1].split("/");
				// // printShuzu(names);
				// String fileName = names[names.length - 1];
				//
				// // output here
				// FileOutputStream out;
				// try {
				// out = (new FileOutputStream(new
				// java.io.File("f:/hou/javaDownload/" + fileName)));
				// out.write(resultImageResponse.bodyAsBytes());
				// // resultImageResponse.body() is where the image's contents
				// are.
				// out.close();
				// } catch (FileNotFoundException e) {
				// // TODO Auto-generated catch block
				// e.printStackTrace();
				// }
				//

				System.out.println(img);
				imgList.add(img);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private void downloadPicture(ArrayList<String> imgList, String taskName) {
		FileOutputStream fos = null;
		BufferedInputStream bis = null;
		HttpURLConnection httpUrl = null;
		URL url = null;
		int BUFFER_SIZE = 1024;
		byte[] buf = new byte[BUFFER_SIZE];
		int size = 0;
		String rootPath = "f:/hou/javaDownload/" + taskName + "/";
		File f = new File(rootPath);
		if (!f.exists()) {
			f.mkdirs();
		}

		for (String destUrl : imgList) {
			try {

				String[] website = destUrl.split("//");
				// printShuzu(website);
				String[] names = website[1].split("/");
				// printShuzu(names);
				String fileName = names[names.length - 1];

				url = new URL(destUrl);
				httpUrl = (HttpURLConnection) url.openConnection();
				httpUrl.connect();
				bis = new BufferedInputStream(httpUrl.getInputStream());
				fos = new FileOutputStream(rootPath + fileName);
				while ((size = bis.read(buf)) != -1) {
					fos.write(buf, 0, size);
				}
				System.out.println("download..." + destUrl);
				fos.flush();
			} catch (IOException e) {
				e.printStackTrace();
			} catch (ClassCastException e) {
				e.printStackTrace();
			} finally {
				try {
					fos.close();
					bis.close();
					httpUrl.disconnect();
				} catch (IOException e) {
					e.printStackTrace();
				} catch (NullPointerException e) {
					e.printStackTrace();
				}
			}
		}
	}

	Map<String, String> getCookies(String userName, String pwd) throws Exception {

		Connection con = Jsoup.connect("http://www.douban.com/login");// 获取连接
		con.header("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64; rv:29.0) Gecko/20100101 Firefox/29.0");// 配置模拟浏览器
		Response rs = con.execute();// 获取响应
		Document d1 = Jsoup.parse(rs.body());// 转换为Dom树

		// System.out.println(d1.select("body"));

		List<Element> et = d1.select("#lzform");// 获取form表单，可以通过查看页面源码代码得知

		// 获取，cooking和表单属性，下面map存放post时的数据
		Map<String, String> datas = new HashMap<>();
		for (Element e : et.get(0).getAllElements()) {
			if (e.attr("name").equals("form_email")) {
				e.attr("value", userName);// 设置用户名
			}

			if (e.attr("name").equals("form_password")) {
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
		Connection con2 = Jsoup.connect("http://www.douban.com/login");
		con2.header("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64; rv:29.0) Gecko/20100101 Firefox/29.0");
		// 设置cookie和post上面的map数据
		Response login = con2.ignoreContentType(true).method(Method.POST).data(datas).cookies(rs.cookies()).execute();
		// 打印，登陆成功后的信息
		System.out.println(login.body());

		Map<String, String> map = login.cookies();
		for (String s : map.keySet()) {
			System.out.println(s + "      " + map.get(s));
		}

		System.out.println(login.cookies());
		return map;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DoubanMovieImg ooxx = new DoubanMovieImg();

		Map<String, String> cookies = null;
		try {
			cookies = ooxx.getCookies("hou103880@163.com", "password");
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		System.out.println(cookies);

		String taskName = "douban";
		for (int i = 0; i < 360; i = i + 40) {
			ArrayList<String> imgList = new ArrayList<String>();
			String url = "http://movie.douban.com/subject/1419936/photos?type=S&start=" + i
					+ "&sortby=vote&size=a&subtype=a";
			System.out.println("正在下载:" + url);
			ooxx.Crawler(url, imgList, cookies);
			ooxx.downloadPicture(imgList, taskName);

			try {
				Thread.sleep(3000);// 括号里面的5000代表5000毫秒，也就是5秒，可以该成你需要的时间
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}

}
