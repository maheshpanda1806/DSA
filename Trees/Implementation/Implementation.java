import java.util.*;

class Node {
    int val;
    Node left;
    Node right;

    Node(int val) {
        this.val = val;
    }
}
// The method insert is initially called with the current node representing the root of the tree. This is where the user input process begins.

// It asks the user whether they want to insert a node to the left of the current node and waits for a boolean input (true or false).

// If the user chooses to insert to the left (true), it creates a new Node with the specified value and sets it as the left child of the current node.

// After inserting the left child, the insert method is called recursively with the left child as the new current node. This step continues the process for the left subtree.

// If the user chooses not to insert to the left (false), or after inserting to the left, the code similarly checks whether the user wants to insert to the right of the current node.

// If the user chooses to insert to the right (true), it creates a new Node with the specified value and sets it as the right child of the current node.

// After inserting the right child, the insert method is called recursively with the right child as the new current node. This step continues the process for the right subtree.

// The recursive calls continue until the user decides not to insert any more nodes (by entering false for both left and right subtrees), at which point the recursion unwinds and returns to the previous level, eventually completing the tree construction.

// In this way, the recursive calls allow the user to build a binary tree structure by iteratively deciding whether to insert nodes to the left or right of the current node until no more insertions are desired, effectively constructing the entire binary tree.
class BinaryTree {
    Node root;

    // Constructor that takes a Scanner as input and initializes the root by inserting values
    BinaryTree(Scanner sc) {
        insert(sc);
    }

    // Initialize the root by taking user input
    void insert(Scanner sc) {
        System.out.println("Enter The Root value: ");
        int val = sc.nextInt();
        root = new Node(val); // Create a new Node with the root value
        insert(root, sc); // Start the recursive insert process with the root node
    }
    // Recursive function to insert nodes in the binary tree
    void insert(Node current, Scanner sc) {
        System.out.println("Do you want to insert to the left of " + current.val);
        if (Boolean.parseBoolean(sc.next())) {
            System.out.println("Enter The value : ");
            int val = sc.nextInt();
            current.left = new Node(val); // Create a new Node and set it as the left child
            insert(current.left, sc); // Recursively insert nodes on the left subtree
        }

        System.out.println("Do you want to insert to the right of " + current.val);
        if (Boolean.parseBoolean(sc.next())) {
            System.out.println("Enter The value : ");
            int val = sc.nextInt();
            current.right = new Node(val); // Create a new Node and set it as the right child
            insert(current.right, sc); // Recursively insert nodes on the right subtree
        }
    }

    // Display the binary tree using an in-order traversal (left, root, right)
    void display(Node node, String indent) {
        if (node == null) {
            return;
        }
        System.out.println(indent + node.val); // Print the current node's value with indentation
        display(node.right, indent + "\t"); // Recursively display the right subtree
        display(node.left, indent + "\t"); // Recursively display the left subtree
    }
    void preOrder(){
        preOrder(root);
    }
    void preOrder(Node current){
        if(current==null){
            return;
        }
        System.out.print(current.val+" ");
        preOrder(current.left);
        preOrder(current.right);
    }
    void inOrder(){
        inOrder(root);
    }
    void inOrder(Node current){
        if (current==null) {
            return;
        }
        inOrder(current.left);
        System.out.print(current.val+ " ");
        inOrder(current.right);
    }
     void postOrder(){
        postOrder(root);
    }
    void postOrder(Node current){
        if (current==null) {
            return;
        }     
        postOrder(current.left);
        postOrder(current.right);
        System.out.print(current.val+ " ");
    
    }
    void BFS() {
    if (root == null) {
        System.out.println("The tree is empty.");
        return;
    }

    Queue<Node> q = new LinkedList<>();
    q.offer(root);

    while (!q.isEmpty()) {
        Node temp = q.poll();

        System.out.print(temp.val + " ");

        if (temp.left != null) {
            q.offer(temp.left);
        }

        if (temp.right != null) {
            q.offer(temp.right);
        }
    }
}

}
public class Implementation{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BinaryTree bt = new BinaryTree(sc);
        bt.display(bt.root,"");
         bt.preOrder();
        System.out.println();
         bt.inOrder();
        System.out.println();
        bt.postOrder(); 
        System.out.println();
        bt.BFS();    
    }
}