package sort;

public class BubbleSort {
	private int[] array;

	public BubbleSort(int[] array) {
		this.array = array;
	}

	public void sort() {
		int length = array.length;
		if (length > 0) {
			for (int i = 1; i < length; i++) {
				for (int j = 0; j < length - i; j++) {
					if (array[j] > array[j + 1]) {
						int temp = array[j];
						array[j] = array[j + 1];
						array[j + 1] = temp;
					}
				}
			}
		}
	}

	public void sort2() {
		int length = array.length;
		if (length > 0) {
			for (int i = length - 1; i > 0; i--) {
				for (int j = length - 1; j > length - 1 - i; j--) {
					if (array[j] > array[j - 1]) {
						int temp = array[j];
						array[j] = array[j - 1];
						array[j - 1] = temp;
					}
				}
			}
		}
	}

	public void print() {
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
	}
}
