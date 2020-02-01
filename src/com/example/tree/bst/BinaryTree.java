package com.example.tree.bst;

/**
 * ��������ÿ���ڵ㶼���ӽڵ���ҽڵ㣬��ֻ��һ����ڵ㣬һ���ҽڵ㣬��û����ڵ���ҽڵ�Ľ�Ҷ�ӽڵ㣨�൱������ĩ�ˣ�
 * �ڵ����key��data���ݣ�һ��ʹ��key���в��롢ɾ���Ȳ�����
 * Ҫ�������ҵ�key���ڵ�ǰ�ڵ��key�����ұ߽ڵ��ߣ�Ҫ�������ҵ�keyС�ڵ�ǰ�ڵ��key���������
 * 
 * ����������в������������ݣ���ִ��Ч���ܺã����ǣ�������������������ݻ�����������ݣ��ٶȾͱ���ر�����
 * ��Ϊ���������ֵ����ʱ�����������Ƿ�ƽ����ˣ���ƽ�⣬���ӽڵ㶼��ĳһ�ࣩ��
 * 
 * ʱ�临�Ӷȣ�O(logN)
 */
@Deprecated
public class BinaryTree {

	private Node rootNode; // ���ڵ�
	
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
				parent = current; // parent�洢ÿ�α����ĸ��ڵ㣬������ӽڵ���в���
				
				if (newNode.key < current.key) {
					current = current.leftNode;
					
					if (current == null) { // ���ӽڵ�Ϊnull�����Բ���
						parent.leftNode = newNode;
						return;
					}
					
				} else if (newNode.key > current.key) {
					current = current.rightNode;
					
					if (current == null) { // ���ӽڵ�Ϊnull�����Բ���
						parent.rightNode = newNode;
						return;
					}
				}
			}
		}
	}
	
	// �Ƴ����������Ҫ���ǣ�
	// 1��Ҫɾ���Ľڵ���Ҷ�ڵ㣨��û�����ҽڵ㣩
	// 2��Ҫɾ���Ľڵ�����ڵ㣬û���ҽڵ�
	// 3��Ҫɾ���Ľڵ����ҽڵ㣬û����ڵ�
	public boolean remove(int key) {
		Node current = rootNode;
		Node parent = rootNode;
		boolean isLeftNode = true;
		
		while (current.key != key) {
			parent = current; // ÿ�ν��붼������µĽڵ���Ϊ���ڵ�
			
			if (key < current.key) { // keyС�ڵ�ǰ�ڵ��key������ڵ�
				isLeftNode = true;
				current = current.leftNode;
			} else if (key > current.key) { // key���ڵ�ǰ�ڵ��key�����ҽڵ�
				isLeftNode = false;
				current = current.rightNode;
			}
			
			// �жϻ�ȡ�Ľڵ����ҽڵ��Ƿ�Ϊnull
			if (current == null) {
				return false;
			}
		}
		
		// �ҵ���Ҫɾ���Ľڵ�
		// ���û�����ҽڵ�
		if (current.leftNode == null && current.rightNode == null) {
			
			if (current == rootNode) {  // ����Ǹ��ڵ㣬�Ѹ��ڵ���Ϊnull
				rootNode = null;
			} else if (isLeftNode) { // Ҫɾ���Ľڵ�����ڵ㣬parent�����ĸ��ڵ㣬�����Ͽ�����
				parent.leftNode = null;
			} else { // Ҫɾ���Ľڵ�����ڵ㣬parent�����ĸ��ڵ㣬�����Ͽ�����
				parent.rightNode = null;
			}
			
		// �����һ���ӽڵ㣬��Ҫ��Ҫɾ���Ľڵ�ɾ�������ӽڵ����Ҫɾ���ڵ��λ��
		} else if (current.rightNode == null) { // Ҫɾ���Ľڵ�����ڵ�
			if (current == rootNode) {
				rootNode = null;
			} else if (isLeftNode) {
				parent.leftNode = current.leftNode;
			} else {
				parent.rightNode = current.leftNode;
			}
		} else if (current.leftNode == null) { // Ҫɾ���Ľڵ����ҽڵ�
			if (current == rootNode) {
				rootNode = null;
			} else if (isLeftNode) {
				parent.leftNode = current.rightNode;
			} else {
				parent.rightNode = current.rightNode;
			}
		// �������ӽڵ�	
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
	
	// �Һ�̽ڵ��������Ҫɾ���Ľڵ�λ��
	// ��̽ڵ㣺��ÿһ���ڵ���˵����Ҫɾ���Ľڵ��key���ؼ�ֵ���θߵĽڵ������������̡�
	/**
	 * 
	 *            50        ���                          50
	 *         25                 30
	 *    15        35        15      35
	 *  5   20   30    40   5   20        40
	 * 
	 * 50Ϊ���ڵ㣬25��50����ڵ㣬15��25����ڵ㣬35��25���ҽڵ�
	 * ����������Ҫɾ��25����Ϊ25���������ӽڵ㣬������Ҫ�ҵ���̽ڵ��������λ�ã�
	 * ��̽ڵ���key��25�θߵĽڵ㣬Ҳ����30��30����25�ĺ�̽ڵ㣬��30�Ĵ���25��λ��
	 * ��̽ڵ�϶����������ӽڵ㣬����еĻ��Ͳ��Ǻ�̽ڵ��ˡ�
	 * 
	 * ���Һ�̽ڵ���㷨˼·��
	 * �ҵ���ʼ�ڵ�����ӽڵ㣨����keyһ���ȳ�ʼ�ڵ�󣩣�Ȼ��ת����ʼ�ڵ�����ӽڵ�����ӽڵ����
	 * Ȼ��������ӽڵ�����ӽڵ㣬�Դ����ơ�
	 * 
	 * ��̽ڵ��㷨��˵������Ҫ���ҵ�25����ʼ�ڵ㣩�����ӽڵ�35����һֱ�����ӽڵ��ѯ�����һ�����ӽڵ���Ǻ�̽ڵ�
	 * 
	 */
	private Node getSuccessor(Node delNode) {
		Node successorParent = delNode; 
		Node successor = delNode;
		Node current = delNode.rightNode; // ��ʼ�ڵ�����ӽڵ�
		
		while (current != null) {
			successorParent = successor; // successorParent��̽ڵ�ĸ��ڵ�
			successor = current; // successor���Ǻ�̽ڵ�
			current = current.leftNode;
		}
		
		if (successor != delNode.rightNode) {
			// �Ѻ�̽ڵ�ԭ����λ����Ϊnull
			// successor��30��successor.rightNode��null��successorParent��35��successorParent.leftNodeԭ����30
			successorParent.leftNode = successor.rightNode;
			// delNode��25��delNode.rightNode��35����delNode.rightNode��Ϊ30���ҽڵ㣬�����������
			successor.rightNode = delNode.rightNode;
		}
		
		return successor;
	}
	
	public Node find(int key) {
		Node current = rootNode;
		
		while (current.key != key) {
			if (key < current.key) { // ��ֵ���С�ڵ�ǰ���ĸ��ڵ���ӽڵ㣬���������
				current = current.leftNode;
			} else if (key > current.key) { // ��ֵ������ڵ�ǰ��ĸ��ڵ���ӽڵ㣬�����ұ���
				current = current.rightNode;
			}
			
			if (current == null) {
				return null;
			}
		}
		
		return current;
	}

	// ������Сֵ
	public Node minimun() {
		Node current = rootNode;
		Node last = null;

		while (current != null) {
			last = current;
			current = current.leftNode;
		}
		return last;
	}

	// �������ֵ
	public Node maximun() {
		Node current = rootNode;
		Node last = null;

		while (current != null) {
			last = current;
			current = current.rightNode;
		}

		return last;
	}
	
	public static final int PRE_ORDER = 0; // ǰ�����
	public static final int IN_ORDER = 1; // �������
	public static final int POST_ORDER = 2; // �������
	
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
	 * ǰ�����
	 *
	 * ���裺
	 * �ȷ��ʸ��ڵ㣬Ȼ���������������������������
	 * �ڷ�������������ʱ��ͬ�����ȷ��������ĸ��ڵ㣬�ٷ����������ڵ���������������������ϵݹ�
	 */
	private void preOrder(Node node) {
		if (node != null) {
			System.out.print(node.key + " ");
			preOrder(node.leftNode);
			preOrder(node.rightNode);
		}
	}
	
	/**
	 * �������
	 *
	 * ���裺
	 * �ȷ�����������Ȼ����ʸ��ڵ㣬��������������
	 * �ڷ�������������ʱ��ͬ�����ȷ�����������ߣ��ٷ��������ĸ��ڵ㣬����ٷ����������ұߣ����ϵݹ�
	 *
	 *       10
	 *  5    |       15
	 *  |    |    6  |   2
	 *  |    |    |  |   |
	 *  5    10   6  15  2  ͶӰ��һ��ˮƽ������
	 * ������һ����������10�Ǹ��ڵ㣬5����ڵ㣬15���ҽڵ㣬6��2�ֱ���15�����ҽڵ㣬ʹ��������������ӡ���£�
	 * [5, 10, 6, 15, 2]��ֱ�ۿ�������������������ǽ��ڵ�ͶӰ��һ��ˮƽ�������ϣ�����µ�������ʾ
	 */
	private void inOrder(Node node) {
		if (node != null) {
			inOrder(node.leftNode);
			System.out.print(node.leftNode + " ");
			inOrder(node.rightNode);
		}
	}

	/**
	 * �������
	 *
	 * ���裺
	 * �ȷ�����������Ȼ������������������ʸ��ڵ㡣ͬ�����ϵݹ�
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
		public Node leftNode; // ��ڵ�
		public Node rightNode; // �ҽڵ�

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
