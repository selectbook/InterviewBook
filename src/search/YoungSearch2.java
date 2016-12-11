package search;

public class YoungSearch2 {
	private int[][] array;
	
	public YoungSearch2(int[][] array) {
		this.array = array;
	}
	
	public boolean search(int target) {
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; target >= array[i][j] && j < array[0].length; j++) {
				if (target == array[i][j]) {
					System.out.println(String.format("x: %d, y: %d", i, j));
					return true;
				} else if (target < array[i][j]) {
					return false;
				}
			}
		}
		return false;
	}
}
