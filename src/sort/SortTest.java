package sort;

public class SortTest {
	public static void main(String[] args) {
		testBucketSort();
	}

	private static void testBucketSort() {
		int[] array = { 5, 9, 1, 9, 5, 3, 7, 6, 1 };
		BucketSort bucketSort = new BucketSort(11, array);
		BubbleSort bubbleSort = new BubbleSort(array);
		QuickSort quickSort = new QuickSort(array);
		ShellSort shellSort = new ShellSort(array);
		bucketSort.sort();
		bucketSort.print();
		// bubbleSort.sort2();
		// bubbleSort.print();
		quickSort.sort();
		quickSort.print();
		shellSort.sort();
		shellSort.print();
	}
}
