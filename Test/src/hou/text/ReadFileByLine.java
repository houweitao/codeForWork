package hou.text;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * @author houweitao
 * @date 2015年10月29日 上午10:30:59
 * http://blog.chinaunix.net/uid-20804770-id-3048513.html
 */

public class ReadFileByLine {
	public static void main(String[] args) {
		String filePath = "C://Users//RUAN//Desktop//spring.log.7";

		ReadFileByLine read = new ReadFileByLine();
		read.dealFile(filePath);
	}

	void dealFile(String filePath) {
		FileInputStream fis = null;
		InputStreamReader isr = null;
		BufferedReader br = null; // 用于包装InputStreamReader,提高处理性能。因为BufferedReader有缓冲的，而InputStreamReader没有。
		int readLine = 0;
		int exceptionNum = 0;
		int last = 0;

		ArrayList<String> al = new ArrayList<String>();
		HashMap<String, String> hm = new HashMap<String, String>();

		try {
			String str = "";
			String str1 = "";
			fis = new FileInputStream(filePath);// FileInputStream
			// 从文件系统中的某个文件中获取字节
			isr = new InputStreamReader(fis);// InputStreamReader 是字节流通向字符流的桥梁,
			br = new BufferedReader(isr);// 从字符输入流中读取文件中的内容,封装了一个new
											// InputStreamReader的对象
			while ((str = br.readLine()) != null) {
				readLine++;
//				str1 += str + "\n";

				if (last > 0) {
					System.out.println(str);
					last--;
					if (last == 0)
						System.out.println();
				}

				if (str.contains("Exception")) {
					exceptionNum++;
					last = 0;
//					System.out.println("第" + exceptionNum + "个exception@文件第" + readLine + "行: " + str);

					String[] dealStr = str.split(":");
//					System.out.println(dealStr[1]);

					if (dealStr.length > 2) {
//						for (int i = 0; i < dealStr.length; i++)
//							System.out.print(dealStr[i]+" ");
//						System.out.println();
						
						if (!hm.containsKey(dealStr[1]))
							hm.put(dealStr[1], str);
					}

//					if (!al.contains(dealStr[1]))
//						al.add(dealStr[1]);

					else if (!hm.containsKey(dealStr[1]))
						hm.put(dealStr[1], dealStr[0]);
				}
			}

//			for(String s:al){
//				System.out.println(s);
//			}

			int count=0;
			for (String s : hm.keySet())
				System.out.println(count++ +": "+ hm.get(s) + " " + s);

			// 当读取的一行不为空时,把读到的str的值赋给str1
//			System.out.println(str1);// 打印出str1
		} catch (FileNotFoundException e) {
			System.out.println("找不到指定文件");
		} catch (IOException e) {
			System.out.println("读取文件失败");
		} finally {
			try {
				br.close();
				isr.close();
				fis.close();
				// 关闭的时候最好按照先后顺序关闭最后开的先关闭所以先关s,再关n,最后关m
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}