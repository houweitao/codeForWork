package hou.csdn.single;

/**
 * @author houweitao
 * 2015年8月24日 下午11:22:58
 * http://blog.csdn.net/sunlovefly2012/article/details/47837597
 */

import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class EmailUtil {
    private static String host = "smtp.qq.com"; 			//smtp服务器
    private static String user = "1050020147@qq.com"; 			//用户名
    private static String pwd = "xxx"; 				//密码
    
    private static String from = "1050020147@qq.com"; 			//发件人地址
    private static String to = "1050020147@qq.com"; 		//收件人地址
    private static String subject = "[故事里]邮件测试"; 		//邮件标题

    public static void send(String content) {
    	Properties props = new Properties();
    	//设置发送邮件的邮件服务器的属性（这里使用阿里云的smtp服务器）
    	props.put("mail.smtp.host", host);
    	//需要经过授权，也就是有户名和密码的校验，这样才能通过验证（一定要有这一条）
    	props.put("mail.smtp.auth", "true");
    	props.put("mail.transport.protocol", "smtp");
    	//得到默认的对话对象  
        Authenticator auth = new Authenticator() {
            public PasswordAuthentication getPasswordAuthentication(){
                return new PasswordAuthentication(user, pwd);
            }
        };
    	//用刚刚设置好的props对象构建一个session
    	Session session = Session.getDefaultInstance(props,auth);
    	//有了这句便可以在发送邮件的过程中在console处显示过程信息，供调试使用（你可以在控制台（console)上看到发送邮件的过程）
    	session.setDebug(true);
    	//用session为参数定义消息对象
    	MimeMessage message = new MimeMessage(session);
    	try {
    		//加载发件人地址(使用默认)
    		//message.setFrom(new InternetAddress(from));
    		//设置自定义发件人昵称 
            String nick="";
            try {
                nick = javax.mail.internet.MimeUtility.encodeText("故事里");
            } catch (UnsupportedEncodingException e) {  
                e.printStackTrace(); 
            }
            message.setFrom(new InternetAddress(nick+" <"+from+">"));
    		//加载收件人地址
    		message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
    		//加载标题
    		message.setSubject(subject);
    		message.setSentDate(new Date());
    		//向multipart对象中添加邮件的各个部分内容，包括文本内容和附件
    		Multipart multipart = new MimeMultipart();
    		//设置邮件的文本内容
    		BodyPart contentPart = new MimeBodyPart();
    		//给BodyPart对象设置内容和格式/编码方式
    		contentPart.setContent(content,"text/html;charset=utf-8");
    		//发送纯文本
    		//contentPart.setText(content);
    		multipart.addBodyPart(contentPart);
    		//添加附件
    		//BodyPart messageBodyPart = new MimeBodyPart();
    		//DataSource source = new FileDataSource(affix);
    		//添加附件的内容
    		//messageBodyPart.setDataHandler(new DataHandler(source));
    		//添加附件的标题
    		//这里很重要，通过下面的Base64编码的转换可以保证你的中文附件标题名在发送时不会变成乱码
    		//sun.misc.BASE64Encoder enc = new sun.misc.BASE64Encoder();
    		//messageBodyPart.setFileName("=?GBK?B?"+ enc.encode(affixName.getBytes()) + "?=");
    		//multipart.addBodyPart(messageBodyPart);
    		
    		//将multipart对象放到message中
    		message.setContent(multipart);
    		//保存邮件
    		message.saveChanges();
    		//发送邮件
    		Transport transport = session.getTransport("smtp");
    		//连接服务器的邮箱
    		transport.connect(host, user, pwd);
    		//把邮件发送出去
    		transport.sendMessage(message, message.getAllRecipients());
    		transport.close();
    	}catch (Exception e) {
    		e.printStackTrace();
    	}
    }
    
    public static void main(String[] args){
    	StringBuffer sBuffer = new StringBuffer();
    	sBuffer.append(" <!DOCTYPE html> ");
    	sBuffer.append(" <html> ");
    	sBuffer.append(" <head> ");
    	sBuffer.append(" <meta http-equiv='Content-Type' content='text/html; charset=utf-8' /> ");
    	sBuffer.append(" <meta http-equiv='X-UA-Compatible' content='IE=edge'> ");
    	sBuffer.append(" <title>故事里|记录,讲述,分享我们的故事</title> ");
    	sBuffer.append(" </head> ");
    	sBuffer.append(" <body> ");
    	sBuffer.append(" <table><tr><td> ");
    	sBuffer.append(" <div style='width:500px;height:400px;margin:0 auto;background:#EF4A3A;color:#FFF;font-size:18px;'>你好，这里是【故事里】系统测试邮件</div> ");
    	sBuffer.append(" </td></tr></table> ");
    	sBuffer.append(" </body> ");
    	sBuffer.append(" </html> ");
    	
    	send(sBuffer.toString());
    }
}

