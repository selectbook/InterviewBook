package arraycollectionhashtable;

public class HashTable {
	/**
	 * 默认散列表的初始化长度 设置小一点，这样我们能够更清楚地看到扩容 在实际使用中其实可以在初始化时传参，要知道，扩容也是很损耗性能的
	 */
	private static final int DEFAUL_INITIAL_CAPACITY = 4;

	/**
	 * 扩容因子
	 */
	private static final float LOAD_FACTOR = 0.75f;

	/**
	 * 散列表数组
	 */
	private Entry[] table = new Entry[DEFAUL_INITIAL_CAPACITY];
	private int size = 0; // 散列表元素的个数
	private int use = 0; // 散列表使用地址的个数

	public void put(int key, int value) {
		int index = hash(key);
		if (table[index] == null) {
			table[index] = new Entry(-1, -1, null);
		}
		Entry e = table[index];
		if (e.next == null) {
			// 不存在值，向链表添加，有可能扩容，要用table属性
			table[index].next = new Entry(key, value, null);
			size++;
			use++;
			// 不存在值，说明是个未用过的地址，需要判断是否需要扩容
			if (use >= table.length * LOAD_FACTOR) {
				resize();
			}
		} else {
			// 本身存在值，修改已有的值
			for (e = e.next; e != null; e = e.next) {
				int k = e.key;
				if (k == key) {
					e.value = value;
					return;
				}
			}
			// 不存在相同的值，直接向链表中添加元素
			Entry temp = table[index].next;
			Entry newEntry = new Entry(key, value, temp);
			table[index].next = newEntry;
			size++;
		}
	}

	/**
	 * 删除
	 * 
	 * @param key
	 */
	public void remove(int key) {
		int index = hash(key);
		Entry e = table[index];
		Entry pre = table[index];
		if (e != null && e.next != null) {
			for (e = e.next; e != null; pre = e, e = e.next) {
				int k = e.key;
				if (k == key) {
					pre.next = e.next;
					size--;
					return;
				}
			}
		}
	}

	/**
	 * 获取
	 * 
	 * @param key
	 * @return
	 */
	public int get(int key) {
		int index = hash(key);
		Entry e = table[index];
		if (e != null && e.next != null) {
			for (e = e.next; e != null; e = e.next) {
				int k = e.key;
				if (k == key) {
					return e.value;
				}
			}
		}
		// 若没有找到，则返回-1
		return -1;
	}

	/**
	 * 获取散列表中元素的个数
	 * 
	 * @return
	 */
	public int size() {
		return size;
	}

	/**
	 * 本身散列表不该有这个方法，在这里只是为了让我们知道它确实扩容了
	 * 
	 * @return
	 */
	public int getLength() {
		return table.length;
	}

	/**
	 * 根据key，通过哈希函数获取位于散列表数组中的哪个位置
	 * 
	 * @param key
	 * @return
	 */
	private int hash(int key) {
		return key % table.length;
	}

	/**
	 * 扩容
	 */
	private void resize() {
		int newLength = table.length * 2;
		Entry[] oldTable = table;
		table = new Entry[newLength];
		use = 0;
		for (int i = 0; i < oldTable.length; i++) {
			if (oldTable[i] != null && oldTable[i].next != null) {
				Entry e = oldTable[i];
				while (null != e.next) {
					Entry next = e.next;
					// 重新计算哈希值，放入新的地址中
					int index = hash(next.key);
					if (table[index] == null) {
						use++;
						table[index] = new Entry(-1, -1, null);
					}
					Entry temp = table[index].next;
					Entry newEntry = new Entry(next.key, next.value, temp);
					table[index].next = newEntry;
					e = next;
				}
			}
		}
	}

}
