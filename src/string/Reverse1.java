package string;

public class Reverse1 {

	/**
	 * 在对换位置反转字符
	 * 
	 * @param str
	 * @param start
	 * @param end
	 * @return
	 */
	public static String reverse(String str, int start, int end) {
		char[] array = str.toCharArray();
		int mid = (end - start) / 2 + start;
		for (int i = 0; i <= mid - start; i++) {
			swap(array, start + i, end - 1);
		}
		return String.valueOf(array);
	}

	private static void swap(char[] array, int left, int right) {
		char temp = array[left];
		array[left] = array[right];
		array[right] = temp;
	}

	/**
	 * 旋转字符串
	 * 
	 * @param str
	 * @param index
	 * @return
	 */
	public static String rotate(String str, int index) {
		str = reverse(str, 0, index);
		str = reverse(str, index + 1, str.length() - 1);
		str = reverse(str, 0, str.length() - 1);
		return str;
	}
}
