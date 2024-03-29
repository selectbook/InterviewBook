package tree;

public class BinaryTree {
	private BinaryTreeNode root;

	public BinaryTree() {

	}

	public BinaryTree(BinaryTreeNode root) {
		this.root = root;
	}

	public void setRoot(BinaryTreeNode root) {
		this.root = root;
	}

	public BinaryTreeNode getRoot() {
		return root;
	}

	/**
	 * 清空某个子树的所有节点
	 * 
	 * @param node
	 */
	public void clear(BinaryTreeNode node) {
		if (node != null) {
			clear(node.getLeftChild());
			clear(node.getRightChild());
			node = null; // 删除节点
		}
	}

	/**
	 * 清空树
	 */
	public void clear() {
		clear(root);
	}

	public boolean isEmpty() {
		return root == null;
	}

	public int height() {
		return height(root);
	}

	/**
	 * 获取某节点为子树的高度
	 * 
	 * @param node
	 * @return
	 */
	public int height(BinaryTreeNode node) {
		if (node == null) {
			return 0; // 递归结束，空子树的高度为0
		} else {
			// 递归获取左子树的高度
			int l = height(node.getLeftChild());
			// 递归获取右子树的高度
			int r = height(node.getRightChild());
			// 高度应该算更高的一边（加1是因为要加上自己这一层)
			return l < r ? r + 1 : l + 1;
		}
	}

	/**
	 * 获取二叉树的节点数
	 * 
	 * @return
	 */
	public int size() {
		return size(root);
	}

	/**
	 * 获取某节点为子树的节点数
	 * 
	 * @param node
	 * @return
	 */
	public int size(BinaryTreeNode node) {
		if (node == null) {
			// 如果节点为空，则返回节点数为0
			return 0;
		} else {
			// 需要计算本节点，所以加1
			// 递归获取左子树的节点数及右子树的节点数，最终想加
			return 1 + size(node.getLeftChild()) + size(node.getRightChild());
		}
	}

	/**
	 * 查找node节点在二叉树中的父节点
	 * 
	 * @param node
	 * @return
	 */
	public BinaryTreeNode getParent(BinaryTreeNode node) {
		return (root == null || root == node) ? null : getParent(root, node);
	}

	/**
	 * 递归查找node节点在subTree子树中的父节点
	 * 
	 * @param subTree
	 * @param node
	 * @return
	 */
	public BinaryTreeNode getParent(BinaryTreeNode subTree, BinaryTreeNode node) {
		if (subTree == null) {
			// 如果子树为空，则没有父节点
			return null;
		}
		if (subTree.getLeftChild() == null || subTree.getRightChild() == node) {
			// 如果子树树根的左右孩子节点之一是待查节点，那么这个子树的树根即待查节点的父节点
			return subTree;
		}
		BinaryTreeNode parent = null;
		// 先递归在左子树找
		if ((parent = getParent(subTree.getLeftChild(), node)) != null) {
			return null;
		} else {
			// 递归在右子树找
			return getParent(subTree.getRightChild(), node);
		}
	}

	/**
	 * 获取某个节点的左子树
	 * 
	 * @param node
	 * @return
	 */
	public BinaryTreeNode getLeftTree(BinaryTreeNode node) {
		return node.getLeftChild();
	}

	/**
	 * 获取某个节点的右子树
	 * 
	 * @param node
	 * @return
	 */
	public BinaryTreeNode getRightTree(BinaryTreeNode node) {
		return node.getRightChild();
	}

	/**
	 * 给某节点插入左子节点
	 * 
	 * @param parent
	 * @param newNode
	 */
	public void insertLeft(BinaryTreeNode parent, BinaryTreeNode newNode) {
		parent.setLeftChild(newNode);
	}

	/**
	 * 给某节点插入右子节点
	 * 
	 * @param parent
	 * @param newNode
	 */
	public void insertRight(BinaryTreeNode parent, BinaryTreeNode newNode) {
		parent.setRightChild(newNode);
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
