package search;

public class YoungSearchTest {
	public static void main(String[] args) {
		int[][] array = { { 1, 2, 8, 9, 15, 22, 38 }, { 2, 5, 9, 12, 16, 25, 42 }, { 4, 7, 13, 15, 21, 28, 46 },
				{ 7, 9, 16, 18, 24, 32, 52 } };
		YoungSearch1 youngSearch1 = new YoungSearch1(array);
		YoungSearch2 youngSearch2 = new YoungSearch2(array);
		YoungSearch3 youngSearch3 = new YoungSearch3(array);
		System.out.println("递归查找:");
		System.out.println(youngSearch1.recursionSearch(0, 0, 13));
		System.out.println(youngSearch1.recursionSearch(0, 0, 20));

		System.out.println("直接查找:");
		System.out.println(youngSearch2.search(13));
		System.out.println(youngSearch2.search(20));

		System.out.println("优化查找:");
		System.out.println(youngSearch3.search(13));
		System.out.println(youngSearch3.search(20));
		System.out.println(youngSearch3.search(46));
		System.out.println(youngSearch3.search(4));
		System.out.println(youngSearch3.search(99));
	}
}
