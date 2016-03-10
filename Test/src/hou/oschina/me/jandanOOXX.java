package hou.oschina.me;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 * @author houweitao 2015年7月15日 上午9:50:20
 */

public class jandanOOXX {

	// ArrayList<String>

	void Crawler(String url, ArrayList<String> imgList) {
		Document doc;
		try {
			doc =
			// Jsoup.connect(url).followRedirects(true).timeout(10000)
			// .userAgent("Mozilla/4.0 (compatible; MSIE 6.0; Windows NT
			// 5.0)").get();

			Jsoup.connect(url).timeout(10000)
					.userAgent(
							"Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.31 (KHTML, like Gecko) Chrome/26.0.1410.64 Safari/537.31")
					.get();

			Elements media = doc.select("img[src]");
			for (Element src : media) {
				// if (src.tagName().equals("img"))
				// System.out.println("images:" + src);
				String img = src.attr("abs:src");
				System.out.println(img);
				imgList.add(img);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private void downloadPicture(ArrayList<String> imgList) {
		FileOutputStream fos = null;
		BufferedInputStream bis = null;
		HttpURLConnection httpUrl = null;
		URL url = null;
		int BUFFER_SIZE = 1024;
		byte[] buf = new byte[BUFFER_SIZE];
		int size = 0;
		String rootPath = "f:/hou/javaDownload/jiandan/";

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

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		jandanOOXX ooxx = new jandanOOXX();

		for (int i = 1599; i > 1400; i--) {
			ArrayList<String> imgList = new ArrayList<String>();
			String url = "http://jandan.net/ooxx/page-";
			url = url + i;
			System.out.println("正在下载:" + url);
			ooxx.Crawler(url, imgList);
			ooxx.downloadPicture(imgList);

			try {
				Thread.sleep(3000);// 括号里面的5000代表5000毫秒，也就是5秒，可以该成你需要的时间
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}

}
