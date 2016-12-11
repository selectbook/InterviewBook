package tree;

public class Heap {
	private int[] element;

	public Heap(int maxSize) {
		element = new int[maxSize + 1];
		element[0] = 0;
	}

	public boolean isEmpty() {
		return element[0] == 0;
	}

	public boolean isFull() {
		return element[0] == element.length - 1;
	}

	/**
	 * 大顶堆添加元素
	 * 
	 * @param value
	 */
	public void insert(int value) {
		if (isFull()) {
			throw new IndexOutOfBoundsException("大堆顶已经满了");
		}
		if (isEmpty()) {
			element[1] = value;
		} else {
			int i = element[0] + 1; // 确认新增元素的下标
			while (i != 1 && value > element[i / 2]) {
				// 如果比父节点值大， 则父节点的值下移
				element[i] = element[i / 2];
				i /= 2;
			}
			// 最终把值插入指定位置
			element[i] = value;
		}
		element[0]++;
	}

	public int delete() {
		if (isEmpty()) {
			throw new IndexOutOfBoundsException("大顶堆已经空了");
		}
		// 删除元素，先赋值为最后一个有效元素
		int deleteElement = element[1]; // 确认新增元素的下标
		element[1] = element[element[0]];
		element[0]--;
		int temp = element[1];
		// 重建堆
		int parent = 1;
		int child = 2;
		// 循环到叶子节点
		while (child <= element[0]) {
			if (child < element[0] && element[child] < element[child + 1]) {
				// 首先要确保child + 1之后不能越界
				// 接着如果左孩子小雨右孩子，那么选择使用右孩子进行计较和交换
				child++;
			}
			if (temp > element[child]) {
				break;
			} else {
				element[parent] = element[child];
				parent = child;
				child *= 2;
			}
		}
		// 把最后一个有效元素放到该放的位置
		element[parent] = temp;
		return deleteElement;
	}

	public void printAll() {
		for (int i = 1; i < element[0] + 1; i++) {
			System.out.print(element[i]);
			if (i != element[0]) {
				System.out.print(",");
			}
		}
		System.out.println();
	}
	
	public void sort() {
		// 首先需要初始化元素
		if (isEmpty()) {
			throw new RuntimeException("先给初始化点数据来排序");
		}
		// 依次删除元素，放入数组的最后
		int size = element[0];
		for (int i = 0; i < size; i++) {
			int deleteElement = delete();
			element[element[0] + 1] = deleteElement;
		}
		// 输出排序后的元素
		for (int i = 1; i < size + 1; i++) {
			System.out.println(element[i]);
			if (i != size) {
				System.out.println(",");
			}
		}
	}
}
