package search;

public class BinarySearch1 {
	private int[] array;
	
	public BinarySearch1(int[] array) {
		this.array = array;
	}
	
	public int search(int target) {
		if (array == null) {
			return -1;
		}
		
		int start = 0;
		int end = array.length - 1;
		while (start <= end) {
			int mid = start + (end - start) / 2;
			if (array[mid] == target) {
				return mid;
			} else if (target <= array[mid]) {
				end = mid - 1;
			} else {
				start = mid + 1;
			}
		}
		return -1;
	}
}
