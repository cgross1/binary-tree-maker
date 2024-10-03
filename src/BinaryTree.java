/*
 * Christopher Gross
 * 
 * Binary Tree class: creates Binary Tree object. Nested class Node creates node objects which are used to build tree.
 * Methods execute functions to determine if tree is proper, balanced full, get tree height, number of nodes and output inorder tree traversal
 */


public class BinaryTree {
	
	
	//declare variables used in this class
	Node root;
	static char[] inputStrCharArr;
	static int index = 0;
	static char c;
	static String returnTreeString = "";
	static BinaryTree myTree;
	
	
	//BinaryTree constructor takes in parameter for inputString
	public BinaryTree(String inputString) throws InvalidTreeSyntax {
		inputStrCharArr = inputString.toCharArray();
		if (inputStrCharArr[index] == '(') {
			System.out.println("first char " + inputStrCharArr[index] + " is (");
			root = makeNode();
			
			//after execution check to make sure no extra chars left in array. if so throw exception
			try {
				index++;
				System.out.println("Any chars left over?: " + inputStrCharArr[index]);
				throw new InvalidTreeSyntax("Syntax error: Chars remaining in input string not iterated by constructor");
			}
			catch (Exception e){
				System.out.println("No chars left in char array after building tree");
			}
		}
		else {
			throw new InvalidTreeSyntax("Syntax Error: First char must be parentheses");
		}
	}
	
	//makeNode method---------------- Recursive method called by constructor
	//requires no parameters, returns Node
	public static Node makeNode() throws InvalidTreeSyntax {
		//make a node
		Node currentNode = new Node();
		
		//get the next character
		index++;
		c = inputStrCharArr[index];
		
		//save it as the data portion of your node
		currentNode.data = c;
		System.out.println("data added to new node: " + c);
		
		//if it is not an alphanumeric character
		if (!((c >= '0' & c <='9') || (c >= 'a' & c <= 'z') || (c >= 'A' & c <= 'Z'))) {
			//throw an exception (initially you can throw an Exception object)
			throw new InvalidTreeSyntax("Error: char is not alphanumeric");
		}
		
		//get the next character
		index ++;
		c = inputStrCharArr[index];
		System.out.println("got next char: " + c);
		
		//if it character is a (
		if (c == '(') {
			//recursively call makeNode and assign the result to the left child
			System.out.println("open parenth found. calling makeNode again assigned to left child");
			currentNode.leftChild = makeNode();
		}
		//else if it is a )
		else if (c == ')') {
			//return the node, it is a leaf node
			System.out.println("close parenth found. returning currentNode");
			return currentNode;
		}
		
		//get the next character
		index ++;
		c = inputStrCharArr[index];
		System.out.println("(second statement) got next char: " + c);
		
		//if it is a (
		if (c == '(') {
			//recursively call makeNode and assign the result to the right child
			System.out.println("open parenth found. calling makeNode again assigned to right child");
			currentNode.rightChild = makeNode();
		}
		//else if it is a )
		else if (c == ')') {
			//return the node, it is a node with a left child
			System.out.println("close parenth found. returning currentNode. it has a left child");
			return currentNode;
		}
		 
		//get the next character
		index ++;
		c = inputStrCharArr[index];
		System.out.println("(third statement) got next char: " + c);
		
		//if it is a )
		if (c == ')') {
			//return the node, it is a node with two children
			System.out.println("close parenth found. returning currentNode. it has two children");
			return currentNode;
		}
		
		//throw an exception (too many children)
		throw new InvalidTreeSyntax("Error: too many children");
		
	}
	
	//public method for when 'Make Tree' is clicked
	public static String makeTree(String inputString) throws InvalidTreeSyntax {
		index=0; //reset index counter
		returnTreeString=""; //reset return string if anything already saved here
		
		if (inputString == null || inputString.isBlank() || inputString.isEmpty()) {
			throw new InvalidTreeSyntax("Input String is empty");	
			
		}
		else if (!inputString.matches("^[a-zA-Z0-9()]+$")) {
			throw new InvalidTreeSyntax("Input string contains invalid characters. "
					+ "\nValid characters are alpha-numeric and parentheses. Cannot contain spaces.");
		}
		else {
			myTree = new BinaryTree(inputString);
			return "Tree constructed: " + showTree(myTree.root);
		}	
	}
	
	//private method supporting makeTree. return String representation of constructed tree using Preorder Traversal
	private static String showTree(Node currentNode) {
		if (currentNode != null) {
			System.out.print("(" + currentNode.data);	
			returnTreeString = returnTreeString + "(" + currentNode.data;
			showTree(currentNode.leftChild);
			showTree(currentNode.rightChild);
			System.out.print(")");
			returnTreeString = returnTreeString + ")";
		}
		return returnTreeString;
	}
	
	//public method for when 'is balanced?' is clicked
	public static String isBalanced() throws InvalidTreeSyntax {
		//Balanced: The absolute difference between the height of its left and right subtrees is at most 1.
		System.out.println("executing is balanced method");
		
		//ensure instance of tree exists before executing
		if (myTree == null) {
			throw new InvalidTreeSyntax("Error: Tree not yet constructed");
		}
		
		if (checkIsBalanced(myTree.root)) {
			System.out.println("Tree is balanced");
			return ("Tree is balanced");
		}
		else {
			System.out.println("Tree is NOT balanced");
			return ("Tree is NOT balanced");
		}
	}
	
	//private recursive method supporting isBalanced
	private static boolean checkIsBalanced(Node currentNode) {
		int leftHeight;
		int rightHeight;
		
		if (currentNode == null) {
			return true;
		}
		
		leftHeight = height(currentNode.leftChild);
		System.out.println("Height of left subtree: " + leftHeight);
		rightHeight = height(currentNode.rightChild);
		System.out.println("Height of right subtree: " + rightHeight);
		
		if (Math.abs(leftHeight-rightHeight) <= 1 && checkIsBalanced(currentNode.leftChild) 
				&& checkIsBalanced(currentNode.rightChild)) {
			return true;
		}
		
		return false;
	}
	
	//private recursive method returning height of subtree
	private static int height(Node currentNode) {
		//base case, tree is empty
		if (currentNode == null) {
			return 0;
		}
		
		return 1 + Math.max(height(currentNode.leftChild), height(currentNode.rightChild));
	}

	//public method executes when 'is full?' button is clicked
	public static String isFull() throws InvalidTreeSyntax {
		System.out.println("executing is full method");
		
		//ensure instance of tree exists before executing
		if (myTree == null) {
			throw new InvalidTreeSyntax("Error: Tree not yet constructed");
		}
		
		if (checkIsFull(myTree.root)) {
			System.out.println("Tree is full");
			return ("Tree is full");
		}
		else {
			System.out.println("Tree is NOT full");
			return ("Tree is NOT full");
		}
	}
	
	//private recursive method supports isFull method
	private static boolean checkIsFull(Node currentNode) {
		
		//if empty tree
		if (currentNode == null) {
			return true;
		}
		
		//if leaf node
		if ((currentNode.leftChild == null) && (currentNode.rightChild == null)) {
			return true;
		}
		
		//both left subtree and right subtree must not be null to pass
		if ((currentNode.leftChild !=null) && (currentNode.rightChild !=null)) {
			return (checkIsFull(currentNode.leftChild) && checkIsFull(currentNode.rightChild));
		}
		
		//else not full
		return false;
	}
	
	public static String isProper() throws InvalidTreeSyntax {
		System.out.println("executing is proper method");
		
		//ensure instance of tree exists before executing
		if (myTree == null) {
			throw new InvalidTreeSyntax("Error: Tree not yet constructed");
		}
		
		//get height of full tree
		int treeHeight = height(myTree.root);
		System.out.println("This tree height is: " + treeHeight);
		
		if (checkIsProper(myTree.root, treeHeight, 0)) {
			System.out.println("Tree is proper");
			return ("Tree is proper");
		}
		else {
			System.out.println("Tree is NOT proper");
			return ("Tree is NOT proper");
		}
	}
	
	//private recursive method supporting isProper
	private static boolean checkIsProper(Node currentNode, int treeHeight, int currentHeight) {	
		//empty tree is proper
		if (currentNode == null) {
			return true;
		}
		
		//find leaf node
		if ((currentNode.leftChild == null) && (currentNode.rightChild == null)) {
			//returns true if height at this leaf node is the same as height of full tree
			//System.out.println("Height of currentNode: " + currentNode.data + " = " + height(currentNode) + ", Tree height: " + treeHeight);
			return treeHeight == currentHeight + 1;
		}

		//false if a node has one child
		if ((currentNode.leftChild == null) || (currentNode.rightChild == null)){
			return false;
		}
		
		return checkIsProper(currentNode.leftChild, treeHeight, currentHeight + 1) && 
				checkIsProper (currentNode.rightChild, treeHeight, currentHeight + 1);	
	}
	
	public static int getHeight() throws InvalidTreeSyntax {
		System.out.println("executing get height method");
		//ensure instance of tree exists before executing
		if (myTree == null) {
			throw new InvalidTreeSyntax("Error: Tree not yet constructed");
		} 
		
		//subtract 1 from height of tree. root is at level 0, not 1.
		return height(myTree.root) - 1;
	}
	
	//public method called when 'Nodes' button is clicked
	public static int getNodes() throws InvalidTreeSyntax {
		System.out.println("executing get nodes method");
		
		//ensure instance of tree exists before executing
		if (myTree == null) {
			throw new InvalidTreeSyntax("Error: Tree not yet constructed");
		}
		
		index=0; //using as a counter
		
		return countNodes(myTree.root);
	}
	
	//private recursive method supporting getNodes
	private static int countNodes(Node currentNode) {
		if (currentNode != null) {
			index++;
			countNodes(currentNode.leftChild);
			countNodes(currentNode.rightChild);
		}
		return index;
	}
	
	public static String getInorder() throws InvalidTreeSyntax {
		System.out.println("executing get inorder method");
		
		returnTreeString = ""; //clear contents of String variable before building new string
		return buildInorderString(myTree.root);
	}
	
	//private method supporting getInorder
	private static String buildInorderString(Node currentNode) {
		if (currentNode != null) {
			//visit left child
			returnTreeString = returnTreeString + "(";
			buildInorderString(currentNode.leftChild);
			
			//get node value
			returnTreeString = returnTreeString + currentNode.data;
			
			//visit right child
			buildInorderString(currentNode.rightChild);
			returnTreeString = returnTreeString + ")";
		}
		return returnTreeString;
	}
	
	
	
	
	//--------nested class Node----------------
	static class Node {
		
		Node leftChild;
		Node rightChild;
		Character data;
		 
		public Node() {
			data = null;
			leftChild = null;
			rightChild = null;
		}
		
	}
	//--------end nested class Node-------------

}
