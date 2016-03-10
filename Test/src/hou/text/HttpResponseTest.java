package hou.text;

import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.impl.client.DefaultHttpClient;

/**
 * @author houweitao
 * 2015年9月25日 下午3:38:43
 */

public class HttpResponseTest {

	public static void main(String[] args) throws ClientProtocolException, IOException {
		// TODO Auto-generated method stub
		HttpResponseTest hrt=new HttpResponseTest();
		hrt.getResponse("http://nba.hupu.com");
	}

	@SuppressWarnings("deprecation")
	void getResponse(String url) throws ClientProtocolException, IOException{
		HttpRequestBase httpRequest = new HttpGet(url);
		
		@SuppressWarnings("resource")
		HttpClient httpclient=new DefaultHttpClient();
		HttpResponse response=httpclient.execute(httpRequest);
		
		System.out.println(response.toString());
		System.out.println(response.getStatusLine());
		
		HttpEntity entity = response.getEntity();
		
		System.out.println(entity.getContentType());
		System.out.println(entity.getContentLength());
		System.out.println(entity.getContent().toString());
		System.out.println(entity.getContentEncoding());
		System.out.println();
	}
	
}
