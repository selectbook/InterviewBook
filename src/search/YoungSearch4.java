package search;

public class YoungSearch4 {
	private int[][] array;

	public YoungSearch4(int[][] array) {
		this.array = array;
	}

	/**
	 * 定位查找
	 * 
	 * @param target
	 * @return
	 */
	public boolean search(int target) {
		int i = 0, j = array[0].length - 1;
		int temp = array[i][j];
		while (true) {
			if (temp == target) {
				System.out.println(String.format("x: %d, y: %d", i, j));
				return true;
			} else if (temp < target && i < array.length - 1) {
				temp = array[++i][j];
			} else if (temp > target && j > 0) {
				temp = array[i][--j];
			} else {
				// 最终没有找到
				return false;
			}
		}
	}
}
