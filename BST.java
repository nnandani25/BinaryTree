import java.util.ArrayList;

/**
 * An Integer Binary Search Tree
 * @author: Your Name Here
 * @version: Date
 */

public class BST {
    private BSTNode root;

    public BSTNode getRoot() {
        return this.root;
    }

    public void setRoot(BSTNode root) {
        this.root = root;
    }

    /**
     * Sets up a binary search tree
     * with some default values
     */
    public void setupTestData() {
        this.root = new BSTNode(10);
        this.root.setLeft(new BSTNode(5));
        this.root.setRight(new BSTNode((15)));
        this.root.getLeft().setLeft(new BSTNode(3));
        this.root.getLeft().setRight(new BSTNode(9));
    }

    /**
     * Prints the provided ArrayList of nodes
     * in the form node1-node2-node3
     * @param nodes ArrayList of BSTNodes
     */
    public static void printNodes(ArrayList<BSTNode> nodes) {
        for(int i=0; i<nodes.size()-1; i++) {
            System.out.print(nodes.get(i) + "-");
        }
        System.out.println(nodes.get(nodes.size()-1));
    }

    /**
     * A function that searches for a value in the tree
     * @param val integer value to search for
     * @return true if val is in the tree, false otherwise
     */
    public boolean search(int val) {
        // TODO: Complete the search function
        // Since both search and bSearch return a boolean, this is the ony call that needs to be made.
        return bSearch(root, val);
    }

    // Searches for the value in the tree.
    public boolean bSearch(BSTNode n, int val)
    {
        // If the node is null, it returns false.
        if(n == null)
        {
            return false;
        }

        // If n is equal to the value it returns true.
        if(n.getVal() == val)
        {
            return true;
        }

        // Searches to the right if the nodes value is greater than wanted value
        if(n.getVal() > val)
        {
            return bSearch(n.getRight(), val);
        }

        // Searches to the left if the nodes value is less than val.
        else
        {
            return bSearch(n.getLeft(), val);
        }
    }

    // Does the recursive search for getInorder
    // Left, Node, Right.
    public void getInorder(BSTNode node, ArrayList<BSTNode> a)
    {
        // Base case, returns if the node is null.
        if(node == null)
        {
            return;
        }

        // Recursively searches to the left.
        getInorder(node.getLeft(), a);
        // Adds the node to the array list.
        a.add(node);
        // Recursively searches to the right.
        getInorder(node.getRight(), a);
    }



    /**
     * @return ArrayList of BSTNodes in inorder
     */
    public ArrayList<BSTNode> getInorder()
    {
        // TODO: Complete inorder traversal
        ArrayList<BSTNode> a = new ArrayList<BSTNode>();
        // Calls getInorder to do the recursive search.
        getInorder(root, a);
        // Returns the arraylist.
        return a;
    }

    // Does the recursive search for preorder.
    // Node, Left, Right.
    public void getPreorder(BSTNode node, ArrayList<BSTNode> a)
    {
        //
        if(node == null)
        {
            return;
        }
        // Adds the node.
        a.add(node);
        // Recursively goes through the left and right.
        getPreorder(node.getLeft(), a);
        getPreorder(node.getRight(), a);
    }

    /**
     * @return ArrayList of BSTNodes in preorder
     */
    public ArrayList<BSTNode> getPreorder() {
        // TODO: Complete preorder traversal
        ArrayList<BSTNode> a = new ArrayList<BSTNode>();
        // Calls the getPreorder which recursively searches.
        getPreorder(root, a);
        // Returns the new arraylist.
        return a;
    }

    // Creates an arraylist recursively of BSTNodes in postorder.
    // Left, Right, Node.
    public void getPostorder(BSTNode node, ArrayList<BSTNode> a)
    {
        // Base case.
        if(node == null)
        {
            return;
        }

        // Recursively goes through the left then right.
        getPostorder(node.getLeft(), a);
        getPostorder(node.getRight(), a);
        // Adds a node to the arraylist.
        a.add(node);
    }

    /**
     * @return ArrayList of BSTNodes in postorder
     */
    public ArrayList<BSTNode> getPostorder() {
        // TODO: Complete postorder traversal
        ArrayList<BSTNode> a = new ArrayList<BSTNode>();
        // Calls the recurisve method.
        getPostorder(root, a);
        // Returns the arraylist with the BSTNode's in postorder.
        return a;
    }

    // Recursively inserts a value into the tree.
    // Returns
    public BSTNode insert(int val, BSTNode node)
    {
        // if the node is null, creates a new node from the value and makes it the root of the new tree.
        if(node == null)
        {
            BSTNode n = new BSTNode(val);
            return n;
        }

        // If the node is the value than it just returns the node because it is already in the tree.
        if(val == node.getVal())
        {
            return node;
        }

        // If the value is greater than the node's value then it searches to the right until it is not greater and
        // returns the node.
        if(val > node.getVal())
        {
            node.setRight(insert(val, node.getRight()));
            return node;
        }

        // If the value is less than the node's value then it searches to the left until and returns the node.
        node.setLeft(insert(val, node.getLeft()));
        return node;

    }


    /**
     * Inserts the given integer value to the tree
     * if it does not already exist. Modifies the
     * root instance variable to be the root of the new modified tree.
     * @param val The value ot insert.
     */
    public void insert(int val) {
        // TODO: Complete insert
        // If the root is the root to the tree with the inserted value than you can access the tree with the new
        // value inserted.
        root = insert(val, root);
    }

    /**
     * Determines if the current BST is
     * a valid BST.
     * @return true if valid false otherwise.
     */
    public boolean isValidBST() {
        // TODO: Optional Challenge!
        return false;
    }

    public static void main(String[] args) {
        // Tree to help you test your code.
        BST tree = new BST();
        tree.setupTestData();

        System.out.println("\nSearching for 15 in the tree");
        System.out.println(tree.search(15));

        System.out.println("\nSearching for 22 in the tree");
        System.out.println(tree.search(22));

        System.out.println("\nPreorder traversal of binary tree is");
        ArrayList<BSTNode> sol = tree.getPreorder();
        printNodes(sol);

        System.out.println("\nInorder traversal of binary tree is");
        sol = tree.getInorder();
        printNodes(sol);

        System.out.println("\nPostorder traversal of binary tree is");
        sol = tree.getPostorder();
        printNodes(sol);

        tree.insert(8);
        System.out.println("\nInorder traversal of binary tree is");
        sol = tree.getInorder();
        printNodes(sol);
    }
}
