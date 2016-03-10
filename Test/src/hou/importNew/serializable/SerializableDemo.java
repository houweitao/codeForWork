package hou.importNew.serializable;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import java.io.*;
import java.util.Date;

/**
 * @author houweitao
 * @date 2016年3月3日 上午11:16:53
 * http://www.importnew.com/18024.html
 */

public class SerializableDemo {
	public static void main(String[] args) {
		//Initializes The Object
		User user = new User();
		user.setName("hollis");
		user.setGender("male");
		user.setAge(23);
		user.setBirthday(new Date());
		System.out.println(user);

		//Write Obj to File
		ObjectOutputStream oos = null;
		try {
			oos = new ObjectOutputStream(new FileOutputStream("tempFile"));
			oos.writeObject(user);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			IOUtils.closeQuietly(oos);
		}

		//Read Obj from File
		File file = new File("tempFile");
		ObjectInputStream ois = null;
		try {
			ois = new ObjectInputStream(new FileInputStream(file));
			User newUser = (User) ois.readObject();
			System.out.println(newUser);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			IOUtils.closeQuietly(ois);
			try {
				FileUtils.forceDelete(file);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}
}
