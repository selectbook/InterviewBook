package search;

public class YoungSearch3 {
	private int[][] array;
	public YoungSearch3(int[][] array) {
		this.array = array;
	}
	
	/**
	 * 优化的查找
	 * @param target
	 * @return
	 */
	public boolean search(int target) {
		int width = array[0].length;
		int height = array.length;
		if (target >= array[0][0]) {
			int i = 0;
			// 先从头开始第一行的查找
			for (; target >= array[0][i] && i < width - 1; i++) {
				if (target == array[0][i]) {
					System.out.println(String.format("x: %d, y: %d", 0, i));
					return true;
				}
			}
			// 该行未找到，修复i为矩阵范围内的数值
			if (i > width - 1) {
				i--;
			}
			// 开始循环向下寻找
			for (int j = 1; j < height; j++) {
				if (array[i][j] == target) {
					System.out.println(String.format("x: %d, y: %d", j, i));
					return true;
				} else if (array[j][i] > target) {
					for (; i >= 0; i--) {
						if (array[j][i] == target) {
							System.out.println(String.format("x: %d, y: %d", j, i));
							return true;
						} else if (array[j][i] <= target) {
							break;
						}
					}
					// 该行未找到，修复i为矩阵范围内的数值
					if (i < 0) {
						i++;
					}
				} else if (array[j][i] < target) {
					for (; i < width - 1; i++) {
						if (array[j][i] == target) {
							System.out.println(String.format("x: %d, y: %d", j, i));
							return true;
						} else if (array[j][i] >= target) {
							break;
						}
					}
					// 该行未找到，修复为i为矩阵范围内的数值
					if (i > width - 1) {
						i--;
					}
				}
			}
		}
		return false;
	}
}
