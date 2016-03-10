package hou.importNew;

import java.io.File;
import java.io.IOException;

import org.junit.Test;

/**
 * @author houweitao
 * @date 2016年2月6日下午11:48:17
 * @source http://www.importnew.com/17714.html
 */

public class JavaIO {
	@Test
	public void creatFile() {
		File file = new File("doc/JavaIO.text");
		try {
			file.createNewFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void separatorTest() {
		System.out.println(File.separator);
		System.out.println(File.pathSeparator);
	}
}
