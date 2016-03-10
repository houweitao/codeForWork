package hou.oschina.single;

/**
 * @author houweitao 2015年7月15日 上午9:32:34
 *         http://www.oschina.net/code/snippet_2328699_49394
 */

public class ReverseSentence {
	public static void main(String[] args) {
		char[] chars = new String("How old are you !? I don't understand").toCharArray();
		System.out.println("the first:");
		System.out.println(chars);

		for(int i=0;i<chars.length;i++){
			System.out.println(i+":"+chars[i]);
		}
		
		reverseWords(chars); // 主要方法

		System.out.println("the second:");
		System.out.println(chars);
	}

	/**
	 * 会将数组里面的单词 倒序排列 例如 how old are you -> you are old how
	 * 
	 * @param chars
	 */
	public static void reverseWords(char[] chars) {
		reverseChars(chars, 0, chars.length - 1);
		
		System.out.println(chars);
		
		for(int i=0;i<chars.length;i++){
			System.out.println(i+":"+chars[i]);
		}
		
		int begin = -1;
		int end = 0;
		for (int i = 0; i < chars.length; i++) {
			char c = chars[i];
			if ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') || c == '\'') { // 简单的判断了一下是否是连续的单词
				if (begin == -1) {
					begin = i;
					end = i;
				} else {
					end = i;
					if (i == chars.length - 1) {
//						reverseChars(chars, begin, end);
						System.out.println(chars);
					}
				}
			} else {
				if (begin != -1) {
					reverseChars(chars, begin, end);
					System.out.println(chars);
					begin = -1;
					end = 0;
				}
			}
		}
	}

	/**
	 * 将char 一定范围内的 字符 倒序排列 例如 hello -> olleh
	 * 
	 * @param chars
	 *            数组
	 * @param begin
	 *            开始位置
	 * @param end
	 *            结束位置
	 */
	public static void reverseChars(char[] chars, int begin, int end) {
		while (end > begin) {
			char c = chars[begin];
			chars[begin] = chars[end];
			chars[end] = c;
			begin++;
			end--;
		}
	}
}
