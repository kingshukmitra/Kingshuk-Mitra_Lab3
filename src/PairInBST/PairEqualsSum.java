package PairInBST;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class PairEqualsSum {

	static class Node {

		int nodeData;
		Node leftNode, rightNode;
	};

	static Node newNode(int nodedata) {

		Node temp = new Node();
		temp.nodeData = nodedata;
		temp.leftNode = null;
		temp.rightNode = null;
		return temp;
	}

	private Node insert(Node root, int key) {

		if (root == null)
			return newNode(key);
		if (key < root.nodeData)
			root.leftNode = insert(root.leftNode, key);
		else
			root.rightNode = insert(root.rightNode, key);
		return root;
	}

	private void findPairEqualsSum(Node root, int sum) {

		Set<Integer> set = new HashSet<Integer>();

		if (!findPairUtil(root, sum, set)) {
			System.out.println("Pairs do not exist");
		}

	}

	// Inorder traversal of the tree
	private boolean findPairUtil(Node root, int sum, Set<Integer> set) {

		if (root == null)
			return false;

		// left
		if (findPairUtil(root.leftNode, sum, set))
			return true;

		// node
		if (set.contains(sum - root.nodeData)) {
			System.out.println("Pair is found " + (sum - root.nodeData) + " , " + root.nodeData);
			return true;
		} else {
			set.add(root.nodeData);
		}

		//right
		return findPairUtil(root.rightNode, sum, set);
	}

	
	public static void main(String[] args) {

		Node root = null;

		PairEqualsSum pes = new PairEqualsSum();
		root = pes.insert(root, 40);
		root = pes.insert(root, 20);
		root = pes.insert(root, 60);
		root = pes.insert(root, 10);
		root = pes.insert(root, 30);
		root = pes.insert(root, 50);
		root = pes.insert(root, 70);

		Scanner sc = new Scanner(System.in);

//		System.out.println("Please enter sum to be found for a pair in BST:");
//		int sum = sc.nextInt();

		int sum = 40;
		pes.findPairEqualsSum(root, sum);
		
		sc.close();

	}
}
