package search;

public class YoungSearch1 {
	private int[][] array;
	
	public YoungSearch1(int[][] array) {
		this.array = array;
	}
	
	/**
	 * 递归实现
	 * @param x
	 * @param y
	 * @param target
	 * @return
	 */
	public boolean recursionSearch(int x, int y, int target) {
		if (x == array.length || y == array[0].length) {
			return false;
		}
		if (target < array[x][y]) {
			return false;
		}
		if (target == array[x][y]) {
			System.out.println(String.format("x: %d, y: %d", x, y));
			return true;
		}
		return recursionSearch(x + 1, y, target) || recursionSearch(x, y + 1, target);
	}
}
