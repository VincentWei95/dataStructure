package com.example.tree.bst;

/**
 * 二叉树，每个节点都有子节点和右节点，或只有一个左节点，一个右节点，而没有左节点和右节点的叫叶子节点（相当于树的末端）
 * 节点存有key和data数据，一般使用key进行插入、删除等操作，
 * 要插入或查找的key大于当前节点的key，往右边节点走；要插入或查找的key小于当前节点的key，往左边走
 * 
 * 如果二叉树中插入的是随机数据，则执行效果很好；但是，如果插入的是有序的数据或是逆序的数据，速度就变得特别慢，
 * 因为当插入的数值有序时，二叉树就是非平衡的了（非平衡，即子节点都在某一侧）。
 * 
 * 时间复杂度：O(logN)
 */
@Deprecated
public class BinaryTree {

	private Node rootNode; // 根节点
	
	public BinaryTree() {
		rootNode = null;
	}
	
	public void insert(int key, int data) {
		Node newNode = new Node(key, data);
		
		if (rootNode == null) {
			rootNode = newNode;
		} else {
			
			Node parent;
			Node current = rootNode;
			
			while (true) {
				parent = current; // parent存储每次遍历的父节点，方便对子节点进行操作
				
				if (newNode.key < current.key) {
					current = current.leftNode;
					
					if (current == null) { // 左子节点为null，可以插入
						parent.leftNode = newNode;
						return;
					}
					
				} else if (newNode.key > current.key) {
					current = current.rightNode;
					
					if (current == null) { // 右子节点为null，可以插入
						parent.rightNode = newNode;
						return;
					}
				}
			}
		}
	}
	
	// 移除有三种情况要考虑：
	// 1、要删除的节点是叶节点（即没有左右节点）
	// 2、要删除的节点有左节点，没有右节点
	// 3、要删除的节点有右节点，没有左节点
	public boolean remove(int key) {
		Node current = rootNode;
		Node parent = rootNode;
		boolean isLeftNode = true;
		
		while (current.key != key) {
			parent = current; // 每次进入都会把最新的节点作为父节点
			
			if (key < current.key) { // key小于当前节点的key，走左节点
				isLeftNode = true;
				current = current.leftNode;
			} else if (key > current.key) { // key大于当前节点的key，走右节点
				isLeftNode = false;
				current = current.rightNode;
			}
			
			// 判断获取的节点左右节点是否为null
			if (current == null) {
				return false;
			}
		}
		
		// 找到了要删除的节点
		// 如果没有左右节点
		if (current.leftNode == null && current.rightNode == null) {
			
			if (current == rootNode) {  // 如果是根节点，把根节点置为null
				rootNode = null;
			} else if (isLeftNode) { // 要删除的节点是左节点，parent是它的父节点，与它断开连接
				parent.leftNode = null;
			} else { // 要删除的节点是左节点，parent是它的父节点，与它断开连接
				parent.rightNode = null;
			}
			
		// 如果有一个子节点，需要把要删除的节点删除后，让子节点替代要删除节点的位置
		} else if (current.rightNode == null) { // 要删除的节点有左节点
			if (current == rootNode) {
				rootNode = null;
			} else if (isLeftNode) {
				parent.leftNode = current.leftNode;
			} else {
				parent.rightNode = current.leftNode;
			}
		} else if (current.leftNode == null) { // 要删除的节点有右节点
			if (current == rootNode) {
				rootNode = null;
			} else if (isLeftNode) {
				parent.leftNode = current.rightNode;
			} else {
				parent.rightNode = current.rightNode;
			}
		// 有两个子节点	
		} else {
			Node successor = getSuccessor(current);
			
			if (current == rootNode) {
				rootNode = successor;
			} else if (isLeftNode) {
				parent.leftNode = successor;
			} else {
				parent.rightNode = successor;
			}
		}
		
		return true;
	}
	
	// 找后继节点用来替代要删除的节点位置
	// 后继节点：对每一个节点来说，比要删除的节点的key（关键值）次高的节点是它的中序后继。
	/**
	 * 
	 *            50        结果                          50
	 *         25                 30
	 *    15        35        15      35
	 *  5   20   30    40   5   20        40
	 * 
	 * 50为根节点，25是50的左节点，15是25的左节点，35是25的右节点
	 * 假设现在需要删除25，因为25具有两个子节点，我们需要找到后继节点代替它的位置，
	 * 后继节点是key比25次高的节点，也就是30，30就是25的后继节点，用30的代替25的位置
	 * 后继节点肯定不会有左子节点，如果有的话就不是后继节点了。
	 * 
	 * 查找后继节点的算法思路：
	 * 找到初始节点的右子节点（它的key一定比初始节点大），然后转到初始节点的右子节点的左子节点那里，
	 * 然后到这个左子节点的左子节点，以此类推。
	 * 
	 * 后继节点算法简单说，就是要先找到25（初始节点）的右子节点35，再一直往左子节点查询，最后一个左子节点就是后继节点
	 * 
	 */
	private Node getSuccessor(Node delNode) {
		Node successorParent = delNode; 
		Node successor = delNode;
		Node current = delNode.rightNode; // 初始节点的右子节点
		
		while (current != null) {
			successorParent = successor; // successorParent后继节点的父节点
			successor = current; // successor就是后继节点
			current = current.leftNode;
		}
		
		if (successor != delNode.rightNode) {
			// 把后继节点原来的位置置为null
			// successor是30，successor.rightNode是null，successorParent是35，successorParent.leftNode原本是30
			successorParent.leftNode = successor.rightNode;
			// delNode是25，delNode.rightNode是35，把delNode.rightNode作为30的右节点，就完成了连接
			successor.rightNode = delNode.rightNode;
		}
		
		return successor;
	}
	
	public Node find(int key) {
		Node current = rootNode;
		
		while (current.key != key) {
			if (key < current.key) { // 数值如果小于当前树的根节点或子节点，则往左边走
				current = current.leftNode;
			} else if (key > current.key) { // 数值如果大于当前输的根节点或子节点，则往右边走
				current = current.rightNode;
			}
			
			if (current == null) {
				return null;
			}
		}
		
		return current;
	}

	// 查找最小值
	public Node minimun() {
		Node current = rootNode;
		Node last = null;

		while (current != null) {
			last = current;
			current = current.leftNode;
		}
		return last;
	}

	// 查找最大值
	public Node maximun() {
		Node current = rootNode;
		Node last = null;

		while (current != null) {
			last = current;
			current = current.rightNode;
		}

		return last;
	}
	
	public static final int PRE_ORDER = 0; // 前序遍历
	public static final int IN_ORDER = 1; // 中序遍历
	public static final int POST_ORDER = 2; // 后序遍历
	
	public void traverse(int traverseType) {
		switch (traverseType) {
		case PRE_ORDER:
			preOrder(rootNode);
			break;
		case IN_ORDER:
			inOrder(rootNode);
			break;
		case POST_ORDER:
			postOrder(rootNode);
			break;
		default:
			break;
		}
	}

	/**
	 * 前序遍历
	 *
	 * 步骤：
	 * 先访问根节点，然后访问左子树，最后访问右子树。
	 * 在访问左、右子树的时候，同样，先访问子树的根节点，再访问子树根节点的左子树和右子树，不断递归
	 */
	private void preOrder(Node node) {
		if (node != null) {
			System.out.print(node.key + " ");
			preOrder(node.leftNode);
			preOrder(node.rightNode);
		}
	}
	
	/**
	 * 中序遍历
	 *
	 * 步骤：
	 * 先访问左子树，然后访问根节点，最后访问右子树。
	 * 在访问左、右子树的时候，同样，先访问子树的左边，再访问子树的根节点，最后再访问子树的右边，不断递归
	 *
	 *       10
	 *  5    |       15
	 *  |    |    6  |   2
	 *  |    |    |  |   |
	 *  5    10   6  15  2  投影到一条水平坐标上
	 * 上面是一个二叉树，10是根节点，5是左节点，15是右节点，6和2分别是15的左右节点，使用中序遍历结果打印如下：
	 * [5, 10, 6, 15, 2]，直观看二叉树的中序遍历就是将节点投影到一条水平的坐标上，如底下的数字所示
	 */
	private void inOrder(Node node) {
		if (node != null) {
			inOrder(node.leftNode);
			System.out.print(node.leftNode + " ");
			inOrder(node.rightNode);
		}
	}

	/**
	 * 后序遍历
	 *
	 * 步骤：
	 * 先访问左子树，然后访问右子树，最后访问根节点。同样不断递归
	 */
	private void postOrder(Node node) {
		if (node != null) {
			postOrder(node.leftNode);
			postOrder(node.rightNode);
			System.out.print(node.key + " ");
		}
	}

	public static class Node {
		public int key;
		public int data;
		public Node leftNode; // 左节点
		public Node rightNode; // 右节点

		public Node(int key, int data) {
			this.key = key;
			this.data = data;
		}

		@Override
		public String toString() {
			return "key = " + key + ", data = " + data;
		}
	}
}
