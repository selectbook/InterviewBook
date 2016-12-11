package arraycollectionhashtable;

import sort.QuickSort;

public class TwoSum {

	/**
	 * 输入一各数组和一个值，寻找数组中任意两个数组的和等于给定的值的数值下标， 如果有很多数组的和等于给定的值，则随意输出一组下标就可以了 暴力解法
	 * 
	 * @param array
	 * @param sum
	 */
	public static void find1(int[] array, int sum) {
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array.length; j++) {
				// 当不是同一个值比关切两值之和为sum时，输出下标
				if (i != j && array[i] == sum - array[j]) {
					System.out.println(String.format("i:%d, j:%d", i, j));
					return;
				}
			}
		}
	}

	/**
	 * 散列表实现
	 * 
	 * @param array
	 * @param sum
	 */
	public static void find2(int[] array, int sum) {
		HashTable hashTable = new HashTable();
		// 首先填充列表
		for (int i = 0; i < array.length; i++) {
			hashTable.put(array[i], i);
		}
		// 依次判断对应值是否存在于散列表中
		for (int i = 0; i < array.length; i++) {
			int index = hashTable.get(sum - array[i]);
			if (index != -1 && index != i) {
				System.out.println(String.format("i:%d, j:%d", index, i));
				return;
			}
		}
	}

	/**
	 * 排序双数组法
	 * 
	 * @param array
	 * @param sum
	 */
	public static void find3(int[] array, int sum) {
		// 先快速排序
		QuickSort sort = new QuickSort(array);
		sort.sort();
		// 初始化相对数组
		int[] array2 = new int[array.length];
		for (int i = 0; i < array.length; i++) {
			array2[i] = sum - array[i];
		}
		int i = 0;
		int j = array2.length - 1;
		// i肯定不能大于等于j,不然会导致重复判断
		while (i < j) {
			if (array[i] == array2[j]) {
				System.out.println(String.format("i:%d, j:%d", i, j));
				return;
			} else if (array[i] < array2[j]) {
				while (i < j && array[i] < array2[j]) {
					i++;
				}
			} else {
				while (i < j && array[i] > array2[j]) {
					j--;
				}
			}
		}
	}

	/**
	 * 排序单数组法
	 * @param array
	 * @param sum
	 */
	public static void find4(int[] array, int sum) {
		// 先快排
		QuickSort sort = new QuickSort(array);
		sort.sort();
		int i = 0;
		int j = array.length - 1;
		while (i < j) {
			int sumTemp = array[i] + array[j];
			if (sumTemp == sum) {
				System.out.println(String.format("i:%d, j:%d", i, j));
				return;
			} else if (sumTemp > sum) {
				j--;
			} else if (sumTemp < sum) {
				i++;
			}
		}
	}
}
