package hou.offerWrite;

import java.nio.charset.Charset;

import com.google.common.hash.BloomFilter;
import com.google.common.hash.Funnels;

/**
 * @author houweitao
 * @date 2016年3月7日 下午2:35:22
 */

public class BloomFilterTest {
	public static void main(String[] args) {
		//声明一个布隆过滤器的初始容量包含10000个项目
		int capacity = 5;
		float errorRate = 0.0001F;
		//初始化一个布隆过滤器
		BloomFilter<String> urlSeen = BloomFilter.create(Funnels.stringFunnel(Charset.forName("UTF-8")), capacity,
				errorRate);
		//添加数据进入布隆过滤器
		urlSeen.put("www.baidu.com");
		urlSeen.put("www.google.com");
		urlSeen.put("www.qq.com");
		System.out.println(urlSeen.mightContain("www.qq.com"));

		for (int i = 0; i < 10000; i++) {
			urlSeen.put("ss" + i);
			System.out.println(urlSeen.expectedFpp());
			if (urlSeen.expectedFpp() > errorRate * 100 * 30)
				urlSeen = BloomFilter.create(Funnels.stringFunnel(Charset.forName("UTF-8")), capacity, errorRate);
		}
	}

}
