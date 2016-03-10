package hou.oschina.me.test;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.jsoup.Connection.Response;
import org.jsoup.Jsoup;

/**
 * @author houweitao
 * 2015年7月16日 上午11:04:06
 */

public class JsoupDownloadImgsTest {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		String imageLocation = "http://img4.douban.com/view/photo/photo/public/p2255910897.jpg";
		
		Map<String, String> map =  new HashMap<>();
		
		
//		map.put("viewed=","26276802_3272929_1406522_2210561_1403307_1403832_2969702_3179588_1138189_25831297");
//		map.put("bid","BO7ZAINftj8");
//		map.put(" ps=y;"
//				+ " ct=y; "
//				+ "ll="118254"; "
//				+ "ap=1; _"
//				+ "pk_ref.100001.8cb4=%5B%22%22%2C%22%22%2C1437054767%2C%22https%3A%2F%2Fwww.baidu.com%2Flink%3Furl%3DtZy4irLUldOKlOiu4SPwbbhG6lm2GyV9yEFkPfE7gIAxW5…%26issp%3D1%26f%3D8%26ie%3Dutf-8%26tn%3Dbaiduhome_pg%26inputT%3D7977%22%5D; __"
//				+ "utmt=1; "
//				+ "ck="l3-Q"; "
//						+ "_pk_id.100001.8cb4=683f0e7c986616a6.1402382207.175.1437054858.1437046938.; "
//						+ "_pk_ses.100001.8cb4=*; push_noty_num=0; push_doumail_num=0; "
//						+ "__utma=30149280.1195990167.1402382210.1437046942.1437054767.195; "
//						+ "__utmb=30149280.4.10.1437054767; __utmc=30149280; "
//						+ "__utmz=30149280.1436588541.190.68.utmcsr=baidu|utmccn=(organic)|utmcmd=organic|utmctr=github%20%E8%BF%98%E6%98%AF%20oschina; __utmv=30149280.5237"";

		
		
		//Open a URL Stream
		Response resultImageResponse = Jsoup.connect(imageLocation).ignoreContentType(true).cookies(map).execute();
		 
		// output here
		FileOutputStream out;
		try {
			out = (new FileOutputStream(new java.io.File("f:/hou/javaDownload/" + "p2255910897.jpg")));
			out.write(resultImageResponse.bodyAsBytes());           
			// resultImageResponse.body() is where the image's contents are.
			out.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("finish..");
	}

}
