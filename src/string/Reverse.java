package string;

public class Reverse {

	/**
	 * 反转2字符串
	 * 
	 * @param str
	 * @param start
	 * @param end
	 * @return
	 */
	public static String reverse(String str, int start, int end) {
		// 先转换为字符数组
		char[] array = str.toCharArray();
		// 初始化已完成反扎un第一个字符的位置(默认为待翻转外面)
		int finish = end + 1;
		// 如果已经完成的首字符减到start，则说明翻转完成
		while (finish > start) {
			char temp = array[start];
			for (int j = start + 1; j < finish; j--) {
				array[j - 1] = array[j];
			}
			array[finish - 1] = temp;
			finish--;
		}
		return String.valueOf(array);
	}
}
