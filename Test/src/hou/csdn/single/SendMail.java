package hou.csdn.single;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

/**
 * @author houweitao 2015年8月21日 上午9:13:32
 */

public class SendMail {
	public SendMail() {
	}

	public static void main(String[] args) {
		send();
		System.out.println();
	}

	public static void send() {
		SimpleEmail email = new SimpleEmail();
		email.setTLS(true);
		email.setHostName("imap.qq.com");
		email.setAuthentication("1050020147@qq.com", "sss"); // 用户名和密码
		try {
			email.addTo("hou103880@163.com"); // 接收方
			email.setFrom("1050020147@qq.com"); // 发送方
			email.setSubject("Java Mail Test"); // 标题
			email.setMsg("Just a simple send test ."); // 内容
			email.send();
		} catch (EmailException e) {
			e.printStackTrace();
		}
	}
}
