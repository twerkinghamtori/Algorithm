package complete;

import java.util.*;

//프로그래머스 길 찾기 게임
//이진트리, 전위 순회, 후위 순회
class Node {
	int num, x, y;
	Node left;
	Node right;
	
	Node(int num, int x, int y, Node left, Node right) {
		this.num = num;
		this.x = x;
		this.y = y;
		this.left = left;
		this.right = right;
	}
}

public class BinaryTree {
	
	static int idx = 0;
	static int[][] result;
	
	public static void main(String[] args) {
		int[][] nodeinfo = {{5,3},{11,5},{13,3},{3,5},{6,1},{1,3},{8,6},{7,2},{2,2}};
		
		int[][] answer = solution(nodeinfo);
		for(int[] i : answer) {
			for(int j : i) {
				System.out.print(j + " ");
			}
			System.out.println();
		}

	}
	
	public static int[][] solution(int[][] nodeinfo) {		
		result = new int[2][nodeinfo.length];
		
		Node[] nodes = new Node[nodeinfo.length];
		
		for(int i=0; i<nodes.length; i++) {
			nodes[i] = new Node(i+1, nodeinfo[i][0], nodeinfo[i][1], null, null);
		}
		
		Arrays.sort(nodes, new Comparator<Node>() {
			public int compare(Node a, Node b) {
				if(a.y == b.y) {
					return a.x - b.x;
				} else {
					return b.y - a.y;
				}
			}
		});
		
		Node parent = nodes[0];
		
		for(int i=1; i<nodes.length; i++) {
			MakeTree(parent, nodes[i]);
		}
		
		preorder(parent);
		
		idx = 0;
		
		postorder(parent);
		return result;
	}
	
	//간선 생성
	public static void MakeTree(Node parent, Node child) {
		if(parent.x < child.x) {
			if(parent.right == null) {
				parent.right = child;
			} else {
				MakeTree(parent.right, child);
			}
		} else {
			if(parent.left == null) {
				parent.left = child;
			} else {
				MakeTree(parent.left, child);
			}
		}
	}
	
	//전위 순회
	public static void preorder(Node n) {
		if(n != null) {
			result[0][idx++] = n.num;
			preorder(n.left);
			preorder(n.right);
		}
	}
	
	//후위 순회
	public static void postorder(Node n) {
		if(n != null) {
			postorder(n.left);
			postorder(n.right);
			result[1][idx++] = n.num;
		}
	}

}
