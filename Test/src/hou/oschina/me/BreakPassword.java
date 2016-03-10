package hou.oschina.me;

/**
 * @author houweitao 2015年8月10日 上午11:00:54
 */

public class BreakPassword {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		BreakPassword bp = new BreakPassword();
		bp.breakPasssword("aacv");

	}

	void breakPasssword(String password) {
		char back[] = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's',
				't', 'u', 'v', 'w', 'x', 'y', 'z', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0' };
		int length = back.length;
		int count = 0;
		
//		System.out.println(back[0]);
//		try {
//			Thread.sleep(5000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		String pass = null;
		for (int i = 0; i < length; i++) {
			pass = String.valueOf(back[i]);
			count++;
			System.out.println(count + " " + pass);
			if (pass == password)
				return;
			for (int j = 0; j < length; j++) {
				pass = String.valueOf(back[i]) +String.valueOf(back[j]);
				count++;
				System.out.println(count + " " + pass);
				if (pass == password)
					return;
				for (int k = 0; k < length; k++) {
					pass = String.valueOf(back[i]) + String.valueOf(back[j])+String.valueOf(back[k]);
					count++;
					System.out.println(count + " " + pass);
					if (pass == password)
						return;
					
//					try {
//						Thread.sleep(2000);
//					} catch (InterruptedException e) {
//						// TODO Auto-generated catch block
//						e.printStackTrace();
//					}
					
					for (int l = 0; l < length; l++) {
						pass = String.valueOf(back[i]) + String.valueOf(back[j])+String.valueOf(back[k])+String.valueOf(back[l]);
						count++;
						System.out.println(count + " " + pass);
						if (pass == password)
							return;
					}
				}
			}
		}
	}

}
