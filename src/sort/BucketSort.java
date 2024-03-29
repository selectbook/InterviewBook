package sort;

public class BucketSort {
	private int[] buckets;
	private int[] array;
	
	public BucketSort(int range, int[] array) {
		this.buckets = new int[range];
		this.array = array;
	}
	
	/**
	 * 排序
	 */
	public void sort() {
		if (array != null && array.length > 1) {
			for (int i = 0; i < array.length; i++) {
				buckets[array[i]] ++;
			}
		}
	}
	
	/**
	 * 从大到小
	 */
	public void print() {
		// 倒序输出数据
		for (int i = buckets.length - 1; i >= 0; i--) {
			// 元素中的值为几，就说明多少个相同值的元素，就输出几遍
			for (int j = 0; j < buckets[i]; j++) {
				System.out.print(i + " ");
			}
		}
	}
	
	
}
