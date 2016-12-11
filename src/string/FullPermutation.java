package string;

public class FullPermutation {
	public static void asciiPermutation(String str) {
		// 获取字符串每个字符的ASCII
		char[] array = str.toCharArray();
		// 需要先排序
		shellSort(array);
		int length = array.length;
		int i = 0;
		while (true) {
			System.out.print(array);
			// 找到数组中第一个被打乱次序的坏人的位置
			for (i = length - 2; (i >= 0) && (array[i] >= array[i + 1]); --i) {
				;
			}
			// 当i<0时，说明已经遍历到第一个元素的前面了，结束
			if (i < 0) {
				return;
			}
			int j;
			// 找到排列中第i位的右边最后一个比其他的数的位置
			for (j = length - 1; (j > i) && (array[j] <= array[i]); --j) {
				;
			}
			// 交换i.j的值
			swap(array, i, j);
			// 把i位置后面的部分反转
			reverse(array, i + 1, length - 1);
		}
	}

	private static void swap(char[] array, int left, int right) {
		char temp = array[left];
		array[left] = array[right];
		array[right] = temp;
	}

	private static void reverse(char[] array, int start, int end) {
		int mid = (end - start) / 2 + start;
		for (int i = 0; i <= mid - start; i++) {
			swap(array, start + 1, end - 1);
		}
	}

	/**
	 * 根据字符ASCII码进行希尔排序
	 * @param array
	 */
	private static void shellSort(char[] array) {
		char temp;
		for (int k = array.length / 2; k > 0; k /= 2) {
			for (int i = k; i < array.length; i++) {
				for (int j = i; j >= k; j -= k) {
					temp = array[j - k];
					array[j - k] = array[j];
					array[j] = temp;
				}
			}
		}
	}
}
