import java.util.*;

class Node {
    int val;
    int height;
    Node left;
    Node right;

    Node(int val) {
        this.val = val;
    }

    int getHeight(Node current) {
        if (current == null) {
            return -1;
        } else {
            return current.height;
        }
    }

}

class BST {
    Node root;

    void insert(int val) {
        root = insert(root, val);
    }

    Node insert(Node current, int val) {
        if (current == null) {
            Node n = new Node(val);
            return n;
        }
        if (val < current.val) {
            current.left = insert(current.left, val);
        }
        if (val > current.val) {
            current.right = insert(current.right, val);
        }

        current.height = Math.max(current.getHeight(current.left), current.getHeight(current.right)) + 1;
        return current;
    }

    boolean isBalanced() {
        return isBalanced(root);
    }

    boolean isBalanced(Node current) {
        if (current == null) {
            return true;
        }
        boolean x = Math.abs(current.getHeight(current.left) - current.getHeight(current.right)) <= 1;
        boolean y = isBalanced(current.left);
        boolean z = isBalanced(current.right);
        return x && y && z;
    }

    void preOrder() {
        preOrder(root);
    }

    void preOrder(Node current) {
        if (current == null) {
            return;
        }
        System.out.print(current.val + " ");
        preOrder(current.left);
        preOrder(current.right);
    }

    void inOrder() {
        inOrder(root);
    }

    void inOrder(Node current) {
        if (current == null) {
            return;
        }
        inOrder(current.left);
        System.out.print(current.val + " ");
        inOrder(current.right);
    }

    void postOrder() {
        postOrder(root);
    }

    void postOrder(Node current) {
        if (current == null) {
            return;
        }
        postOrder(current.left);
        postOrder(current.right);
        System.out.print(current.val + " ");
    }
}

public class BSTImplementation {
    public static void main(String[] args) {
        BST bt = new BST();
        bt.insert(5);
        bt.insert(7);
        bt.insert(4);
        bt.insert(6);
        bt.insert(10);
        bt.inOrder();
    }
}