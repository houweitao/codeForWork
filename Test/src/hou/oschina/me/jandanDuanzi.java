package hou.oschina.me;

import java.io.IOException;
import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 * @author houweitao 2015年7月15日 上午11:08:28
 */

public class jandanDuanzi {

	void Crawler(String url) {
		try {
			Document doc =

			 Jsoup.connect(url).followRedirects(true).timeout(10000)
			 .userAgent("Mozilla/4.0 (compatible; MSIE 6.0; Windows NT5.0)").get();

//			Jsoup.connect(url)
//					.userAgent(
//							"Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.31 (KHTML, like Gecko) Chrome/26.0.1410.64 Safari/537.31")
//					.get();

//			System.out.println(doc);

			Elements links = doc.select("div.row");

			for (Element link : links) {
				System.out.println("");
				System.out.println(link.select("strong").text());
				System.out.println(link.select("p").text());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String url = "http://jandan.net/duan/page-501";

		jandanDuanzi jd = new jandanDuanzi();
		jd.Crawler(url);

	}

}
