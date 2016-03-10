package hou.csdn.single;

/**
 * @author houweitao 2015年9月2日 下午2:24:26
 *         http://blog.csdn.net/zzc8265020/article/details/48134781
 */

public class PrintString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PrintString pt = new PrintString();
		pt.testPrint();

		char[] ch = { '1', '2', '3', '4' };
		pt.csdnPrint(ch, 0);
	}

	void testPrint() {
		for (int i = 0; i < 3; i++)
			for (int j = 0; j < 3; j++) {
				if (j != i)
					for (int k = 0; k < 3; k++) {
						if (k != j && k != i)
							System.out.println(i + " " + j + " " + k);
					}
			}
	}

	void csdnPrint(char[] ch, int index) {
		if (ch == null)
			return;
		if (index == ch.length)
			System.out.println(ch);

		for (int i = index; i < ch.length; i++) {
			char temp = ch[index];
			ch[index] = ch[i];
			ch[i] = temp;
			csdnPrint(ch, index + 1);
			temp = ch[index];
			ch[index] = ch[i];
			ch[i] = temp;
		}
	}
}
