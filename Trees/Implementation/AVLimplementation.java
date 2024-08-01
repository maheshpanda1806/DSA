class Node {
    int val;
    int height;
    Node left;
    Node right;

    Node(int val) {
        this.val = val;
    }
}

class Avl {
    int getHeight(Node current) {
        if (current == null) {
            return -1;
        } else {
            return current.height;
        }
    }
    Node root;

    public Node rightRotate(Node p) {
    Node c = p.left;
    Node t = c.right;

    c.right = p;
    p.left = t;
    
    p.height = Math.max(getHeight(p.left), getHeight(p.right) + 1);
    c.height = Math.max(getHeight(c.left), getHeight(c.right) + 1);

    return c;
  }

  public Node leftRotate(Node c) {
    Node p = c.right;
    Node t = p.left;

    p.left = c;
    c.right = t;
    
    p.height = Math.max(getHeight(p.left), getHeight(p.right) + 1);
    c.height = Math.max(getHeight(c.left), getHeight(c.right) + 1);

    return p;
  }

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
        } else if (val > current.val) {
            current.right = insert(current.right, val);
        }

        current.height = Math.max(getHeight(current.left), getHeight(current.right)) + 1;
        return makeItBalanced(current);
    }

    Node makeItBalanced(Node current) {
        

        // Left heavy (current node)
        if (getHeight(current.left) - getHeight(current.right) > 1) {
            // Left left case (children = current.left, grandchild = current.left.left)
            if (getHeight(current.left.left) - getHeight(current.left.right) > 0) {
                return rightRotate(current);
            }
            // Left right case (children = current.left, grandchild = current.left.right)
            if (getHeight(current.left.left) - getHeight(current.left.right) < 0) {
                current.left = leftRotate(current.left);
                return rightRotate(current);
            }
        }

        // Right heavy (current node)
        if (getHeight(current.left) - getHeight(current.right) < -1) {
            // Right left case (children = current.right, grandchild = current.right.left)
            if (getHeight(current.right.left) - getHeight(current.right.right) > 0) {
                current.right = rightRotate(current.right);
                return leftRotate(current);
            }
            // Right right case (children = current.right, grandchild = current.right.right)
            if (getHeight(current.right.left) - getHeight(current.right.right) < 0) {
                return leftRotate(current);
            }
        }

        return current;
    }

    boolean isBalanced() {
        return isBalanced(root);
    }

    boolean isBalanced(Node current) {
        if (current == null) {
            return true;
        }
        boolean x = Math.abs(getHeight(current.left) - getHeight(current.right)) <= 1;
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

public class AVLimplementation {
    public static void main(String[] args) {
        Avl tree = new Avl();

        for (int i = 0; i < 1000; i++) {
            tree.insert(i);
        }
        System.out.println(tree.isBalanced());
        System.out.println(tree.getHeight(tree.root));
    }
}
