package search;

public class SequentialSearch {
	private int[] array;

	public SequentialSearch(int[] array) {
		this.array = array;
	}

	public int search(int key) {
		for (int i = 0; i < array.length; i++) {
			if (array[i] == key) {
				return i;
			}
		}
		return -1;
	}
	
	public int search2(int key) {
		// 先判断是否等于下标为0的元素
		if (key == array[0]) {
			return 0;
		}
		// 临时保存array[0]的值
		int temp = array[0];
		// 赋值给下标为0的元素
		array[0] = key;
		int i = array.length - 1;
		// 倒序排序
		while (array[i] != key) {
			i--;
		}
		// 把array[0]原本的值赋回去
		array[0] = temp;
		// 比较到最后了也没有找到，则返回-1
		if (i == 0) {
			return -1;
		}
		// 如果找到了，则返回数组下标
		return i;
	}
}
