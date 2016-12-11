package tree;

public class BinarySearchingTree {
	private BinaryTreeNode root;

	public BinarySearchingTree(BinaryTreeNode root) {
		this.root = root;
	}

	public BinaryTreeNode search(int data) {
		return search(root, data);
	}

	private BinaryTreeNode search(BinaryTreeNode node, int data) {
		if (node == null) {
			return null;
		} else if (node.getData() == data) {
			return node;
		} else if (data > node.getData()) {
			return search(node.getRightChild(), data);
		} else {
			return search(node.getLeftChild(), data);
		}
	}

	public void insert(int data) {
		if (root == null) {
			root = new BinaryTreeNode();
			root.setData(data);
		} else {
			searchAndInsert(null, root, data);
		}
	}

	private BinaryTreeNode searchAndInsert(BinaryTreeNode parent, BinaryTreeNode node, int data) {
		if (node == null) {
			node = new BinaryTreeNode();
			node.setData(data);
			if (data > parent.getData()) {
				parent.setRightChild(node);
			} else {
				parent.setLeftChild(node);
			}
			return node;
		} else if (node.getData() == data) {
			return node;
		} else if (data > node.getData()) {
			return searchAndInsert(node, node.getRightChild(), data);
		} else {
			return searchAndInsert(node, node.getLeftChild(), data);
		}
	}

	public void delete(int data) {
		// 对跟节点直接赋值为空
		if (root.getData() == data) {
			root = null;
			return;
		}
		// 整个过程都需要知道父节点，因为java是引用传递，不能直接赋值
		BinaryTreeNode parent = searchParent(data);
		if (parent == null) {
			return;
		}
		BinaryTreeNode node = search(parent, data);
		if (node.getLeftChild() == null && node.getRightChild() == null) {
			// 叶子节点直接删除
			if (parent.getLeftChild() != null && parent.getLeftChild().getData() == data) {
				parent.setLeftChild(null);
			} else {
				parent.setRightChild(null);
			}
		} else if (node.getLeftChild() != null && node.getRightChild() == null) {
			// 左子树不为空
			if (parent.getLeftChild() != null && parent.getLeftChild().getData() == data) {
				parent.setLeftChild(node.getLeftChild());
			} else {
				parent.setRightChild(node.getLeftChild());
			}
		} else if (node.getLeftChild() == null && node.getRightChild() != null) {
			// 右子树不为空
			if (parent.getLeftChild() != null && parent.getLeftChild().getData() == data) {
				parent.setLeftChild(node.getRightChild());
			} else {
				parent.setRightChild(node.getRightChild());
			}
		} else {
			// 左右子树都不为空树
			// 1. 查找右自i树中最左子节点
			BinaryTreeNode deleteNode = node; // 要删除的节点
			BinaryTreeNode temp = node.getRightChild(); // 要删除节点的右子树树根
			if (temp.getLeftChild() == null) {
				// 如果右子树没有子树，直接上移
				temp.setLeftChild(deleteNode.getLeftChild());
			} else {
				// 右子树的孩子不为空
				while (temp.getLeftChild() != null) {
					node = temp;
					temp = temp.getLeftChild();
				}
				// 2.继承节点原右子树上移
				node.setLeftChild(temp.getRightChild());
				// 3.继承节点就位
				temp.setLeftChild(deleteNode.getLeftChild());
				temp.setRightChild(deleteNode.getRightChild());
			}
			// 4.更新父节点为删除节点的原父节点
			if (parent.getLeftChild() != null && parent.getLeftChild().getData() == data) {
				parent.setLeftChild(temp);
			} else {
				parent.setRightChild(temp);
			}
		}
	}

	public BinaryTreeNode searchParent(int data) {
		return searchParent(null, root, data);
	}

	/**
	 * 递归二叉查找树
	 * @param parent
	 * @param node
	 * @param data
	 * @return
	 */
	private BinaryTreeNode searchParent(BinaryTreeNode parent, BinaryTreeNode node, int data) {
		if (node == null) {
			return null;
		} else if (node.getData() == data) {
			return parent;
		} else if (data > node.getData()) {
			return searchParent(node, node.getRightChild(), data);
		} else {
			return searchParent(node, node.getLeftChild(), data);
		}
	}

	public BinaryTreeNode getRoot() {
		return root;
	}
	
	public void preOrder(BinaryTreeNode node) {
		if (node != null) {
			visited(node);
			preOrder(node.getLeftChild());
			preOrder(node.getRightChild());
		}
	}

	public void inOrder(BinaryTreeNode node) {
		if (node != null) {
			inOrder(node.getLeftChild());
			visited(node);
			inOrder(node.getRightChild());
		}
	}

	public void postOrder(BinaryTreeNode node) {
		if (node != null) {
			postOrder(node.getLeftChild());
			postOrder(node.getRightChild());
			visited(node);
		}
	}

	public void visited(BinaryTreeNode node) {

	}

}
