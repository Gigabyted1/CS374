import java.util.ArrayList;

public class DaileyTree {
	
	public static void main (String[] args) {
		ArrayList<Integer> inOrder = new ArrayList<Integer>();
		ArrayList<Integer> preOrder = new ArrayList<Integer>();
		ArrayList<Integer> postOrder = new ArrayList<Integer>();
		Tree theTree = new Tree(1);
		Node current = null;
		Node parent = null;
		Node gparent = null;
		Node ggparent = null;
		
		generateDaileyTree(1, 5, theTree, current, parent, gparent, ggparent);
	}
	
	public static void generateDaileyTree (int currDepth, int goalDepth, Tree treeToGenerate, Node current, Node parent, Node gparent, Node ggparent) {
		if (currDepth == 1) {
			treeToGenerate.root.left = new Node(2);
			treeToGenerate.root.left.left = new Node(3);
			ggparent = null;
			gparent = treeToGenerate.root;
			parent = treeToGenerate.root.left;
			current = treeToGenerate.root.left.left;
			
			currDepth++;
		}
		else if (currDepth == goalDepth + 1) {
			return;
		}
		
		ggparent = gparent;
		gparent = parent;
		parent = current;
		
		current = parent.left;
		current = new Node(parent.key + ggparent.key);
		
		generateDaileyTree(currDepth + 1, goalDepth, treeToGenerate, current, parent, gparent, ggparent);
		
		current = parent.right;
		current = new Node(parent.key + gparent.key);
		
		generateDaileyTree(currDepth + 1, goalDepth, treeToGenerate, current, parent, gparent, ggparent);
	}

	public static void inOrderTrav (Node current, ArrayList<Integer> storage) {
		if (current != null) {
			inOrderTrav(current.left, storage);
			System.out.print (current.key + " ");
			storage.add(current.key);
			inOrderTrav(current.right, storage);
	    } 
	}
	
	public static void preOrderTrav (Node current, ArrayList<Integer> storage) {
		if (current != null) {
			System.out.print (current.key + " ");
			storage.add(current.key);
			inOrderTrav(current.left, storage);
		    inOrderTrav(current.right, storage);
		}
	}
	
	public static void postOrderTrav (Node current, ArrayList<Integer> storage) {
		if (current != null) {
			inOrderTrav(current.left, storage);
		    inOrderTrav(current.right, storage);
			System.out.print (current.key + " ");
			storage.add(current.key);
		}
	}
	
	public static void numberCount (ArrayList<Integer> allNumbers) {
		for (int i : allNumbers) {
			
		}
	}
}
