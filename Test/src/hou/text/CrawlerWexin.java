package hou.text;

import java.io.IOException;
import java.util.Date;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 * @author houweitao
 * @date 2015年11月9日 下午3:11:21
 */

public class CrawlerWexin {
	int threadCount = 20;
	boolean killThread = false;
	public final Object signal = new Object();
	int count = 0, error = 0;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CrawlerWexin cw = new CrawlerWexin();
		String url = "http://mp.weixin.qq.com/s?__biz=MzAwNjU0MDI4Ng==&mid=400343998&idx=5&sn=dee0db45d247611e12c75f39cb1d0b3f&3rd=MzA3MDU4NTYzMw==&scene=6#rd";

//		long start = System.currentTimeMillis();
//		for (int i = 0; i < 300; i++) {
//			cw.crawler(url);
//			System.out.println(i);
//		}
//		long end = System.currentTimeMillis();
//		System.out.println((end - start) / 1000);

		//微信搜索
		url = "http://weixin.sogou.com/weixin?query=%E6%AD%A6%E6%B1%89&fr=sgsearch&ie=utf8&type=2&w=01019900&sut=1457&sst0=1447052984307&lkt=0%2C0%2C0";
		
		//微信文章	
//		url = "http://mp.weixin.qq.com/s?__biz=MzA4NDQ4NTQ4MQ==&mid=400304192&idx=2&sn=5487ace0a1abc50c2773bff641c557c1&3rd=MzA3MDU4NTYzMw==&scene=6#rd";
//		url = "https://www.baidu.com/s?ie=utf-8&f=8&rsv_bp=1&rsv_idx=2&tn=baiduhome_pg&wd=%E6%AD%A6%E6%B1%89%E5%A4%A7%E5%AD%A6&rsv_spt=1&oq=%E6%AD%A6%E6%B1%89&rsv_pq=e6a9af300000f2e9&rsv_t=0200YI4Jcg6vohyCpg6HOPB%2Bq4x901Wryddlq%2BVlpPU4%2BZ9XpEKM7Kv1sUR6hI9TZtFF&rsv_enter=1&rsv_sug3=5&rsv_sug1=1&bs=%E6%AD%A6%E6%B1%89";
		
		url="http://weixin.sogou.com/websearch/art.jsp?sg=-kjBTUzEYBAW8Kq-2kSOv1c1kGPZV4PxJ0kwl3Xm36Y5CZnDXZBfWWfQMA-_ADcdSoW4IL53zHT8LOIfeyrLkBF76fFFVpyskrIW05PZl-56odDp4HcnXPn0oAw5IHCrnutrop8fhaSueySZ6U3sGlEaT8gtbw_dFeMnVz4lYD6aEtRl_A9ZYALtyRT2fI5JRi35Ks75U4zlJ_dyDEZPv1tgQRJ7Ffj1r31ADFdMPPYTvo7wMk0gP5-RIe03ZJGWqxMlbOIvhDiXUqHaSCP_twRK8uni87Ady6rGmVCuxuQ.&url=p0OVDH8R4SHyUySb8E88hkJm8GF_McJfBfynRTbN8wjPha0kmXqjle_Eh_u5_ro_nNYrvY8Fv6IHxPEHVsDZe2Q3JxMQ3374Y4O9a7WVU33R5JvefiA4sNwbgDVAU9-c5_d9OyQ9yt1Yy-5x5In7jJFmExjqCxhpkyjFvwP6PuGcQ64lGQ2ZDMuqxplQrsbk";
		cw.begin(url);
		
//		cw.crawler("http://baike.baidu.com/link?url=BiDOWenjkOTga_11pyuuFKT1I9lvzUsjz5uXJsMJz93TiExqRWP05B-sQqulkqP8weBFvGHRTlvmbADpHlLhWq");
		
//		cw.crawler(url);
	}

	void begin(final String url) {
		for (int i = 0; i < threadCount; i++) {
			new Thread(new Runnable() {
				public void run() {
					while (!killThread) {
						System.out.println("当前进入" + Thread.currentThread().getName());
//						crawler("http://mp.weixin.qq.com/s?__biz=MzAwNjU0MDI4Ng==&mid=400343998&idx=5&sn=dee0db45d247611e12c75f39cb1d0b3f&3rd=MzA3MDU4NTYzMw==&scene=6#rd");
						crawler(url);
						synchronized (signal) {
							System.out.println(++count);
						}
					}
				}
			}, "thread-" + i).start();
		}
	}

	void crawler(String url) {
		try {
			Document doc = Jsoup.connect(url).followRedirects(true).timeout(10000)
					.userAgent("Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.0)").get();

			System.out.println(doc.title());
			System.out.println(doc.text());
//			System.out.println(doc);

			Elements links = doc.select("a[href]");
			for (Element link : links) {
				String str = link.attr("abs:href");
				System.out.println(str);
			}

			if (doc.toString().contains("验证码")) {
				System.out.println(++error);
				System.out.println(doc.toString());
				try {
					Thread.sleep(10000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
