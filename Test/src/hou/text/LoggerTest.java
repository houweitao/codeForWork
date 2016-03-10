package hou.text;

import java.util.logging.Logger;

/**
 * @author houweitao
 * 2015年9月21日 下午3:48:28
 * http://www.importnew.com/16331.html
 */

public class LoggerTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Logger logger = Logger.getLogger(LoggerTest.class.getName());
		logger.warning("warning!!!");
		logger.info("info!!!!!");
	}

}
