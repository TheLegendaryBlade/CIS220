//Colton Owen
//Chpt 7 PA

class BSTNode {
    int key;
    BSTNode left, right;
	
	// Constructor to initialize a new BST node with a given key
    public BSTNode(int key) {
        this.key = key;
        this.left = this.right = null;
    }
}

class BST {
    private BSTNode root;

	// Construct to initialize an empty BST
    public BST() {
        root = null;
    }
	
	// Getter method to access the root node
	public BSTNode getRoot() {
		return root;
	}

	// Searches through tree for matching key
    public BSTNode searchRecursive(BSTNode node, int key) {
		while (node != null) {
			if (node.key == key) {
				return node; //Returns node if it matches key
			} else if (key < node.key) {
				return searchRecursive(node.left, key); //Continues left if less than key
			} else {
				return searchRecursive(node.right, key); //Continues right if more than key
			}
		}
		return null;
    }
	
	// Begins search through tree from root
	public BSTNode search(int key) {
		return searchRecursive(root, key);
	}

	// Checks if the tree contains a node with the given key
    public boolean contains(int key) {
        return search(key) != null;
    }

	// Inserts a key into the BST recursively if it does not already exist
    public boolean insertKey(int key) {
        if (contains(key)) {
            return false; // Duplicate keys not allowed
        }
		// Create a new node
        BSTNode newNode = new BSTNode(key);
		// Call insertNode method
        insertNode(newNode);
        return true;
    }
	
	// Begins node insertion process
	private void insertNode(BSTNode node) {
		if (root == null) {
			root = node; //makes node root node if one doesn't exist already
		} else {
			insertRecursive(root, node); //continues if not root node
		}
	}
			

	// Inserts nodes into tree recursively
    private void insertRecursive(BSTNode parent, BSTNode nodeToInsert) {
		if (nodeToInsert.key < parent.key) {
			if (parent.left == null) {
				parent.left = nodeToInsert; //Adds left child if less than parent & no left child
			} else {
				insertRecursive(parent.left, nodeToInsert); //Continues left if less than parent & left child exists
			}
		} else {
			if (parent.right == null) {
				parent.right = nodeToInsert; //Adds right if more than parent & no right child
			} else {
				insertRecursive(parent.right, nodeToInsert); //Continues right if more than parent & right child exists
			}
		}
	}
	
	// Prints tree in reverse order
	public void printInReverseOrder(BSTNode node) {
	      if (node != null) {
			  printInReverseOrder(node.right); //Prints larger numbers first
			  System.out.print(node.key + " ");
			  printInReverseOrder(node.left); //Prints smaller numbers after
		  }
	}

	public static void main(String[] args) {
	    int[] numbers = {35, 41, 13, 57, 3, 83, 88, 51, 38, 20, 11, 22, 27, 21, 48, 8}; //Numbers to be added to tree
		BST tree = new BST(); //Creates new tree
		for (int number : numbers) {
		    tree.insertKey(number);	//Adds numbers to tree
		}
        
        System.out.println("Binary Search Tree After Inserts:");
		tree.printInReverseOrder(tree.root); //Prints tree in reverse order
		
		System.out.println();
		BSTPrint.print2D(tree.getRoot());	//Prints tree in 2D form
		
		//Begins search for key 27
        BSTNode foundNode = tree.search(27);
        if (foundNode != null) {
        	System.out.printf("\nFound node with key = %d.%n", foundNode.key);
        } else {
	      System.out.println("\nKey 27 not found.");
        }

        System.out.println();

        //Vegins search for key 89
        foundNode = tree.search(89);
        if (foundNode != null) {
        	System.out.printf("Found node with key = %d.%n", foundNode.key);
        } else {
    	    System.out.println("Key 89 not found.");
        }
	}
}