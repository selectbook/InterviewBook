package search;

public class BinarySearchTest {
	public static void main(String[] args) {
		int[] array = new int[] { 1, 3, 5, 7, 9, 11, 19 };
		BinarySearch1 binarySearch = new BinarySearch1(array);
		System.out.println(binarySearch.search(0));
		System.out.println(binarySearch.search(11));
	}
}
