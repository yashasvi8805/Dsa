
import java.util.*;

class Node {
    int data;
    Node left, right;

    Node(int data) {
        this.data = data;
    }
}

public class Main {

    // Create tree using Level Order Traversal
    static Node createTree() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter root value:");
        int val = sc.nextInt();

        Node root = new Node(val);
        Queue<Node> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            Node curr = q.poll();

            System.out.println("Enter left child of " + curr.data
                    + " (-1 for no child):");
            int left = sc.nextInt();

            if (left != -1) {
                curr.left = new Node(left);
                q.add(curr.left);
            }

            System.out.println("Enter right child of " + curr.data
                    + " (-1 for no child):");
            int right = sc.nextInt();

            if (right != -1) {
                curr.right = new Node(right);
                q.add(curr.right);
            }
        }

        return root;
    }

    // Level Order Traversal
    static void levelOrder(Node root) {
        if (root == null) return;

        Queue<Node> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            Node curr = q.poll();
            System.out.print(curr.data + " ");

            if (curr.left != null) q.add(curr.left);
            if (curr.right != null) q.add(curr.right);
        }
    }

    // Preorder: Root, Left, Right
    static void preorder(Node root) {
        if (root == null) return;

        System.out.print(root.data + " ");
        preorder(root.left);
        preorder(root.right);
    }

    // Inorder: Left, Root, Right
    static void inorder(Node root) {
        if (root == null) return;

        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }

    // Postorder: Left, Right, Root
    static void postorder(Node root) {
        if (root == null) return;

        postorder(root.left);
        postorder(root.right);
        System.out.print(root.data + " ");
    }

    public static void main(String[] args) {
        Node root = createTree();

        System.out.print("Level Order: ");
        levelOrder(root);

        System.out.print("\nPreorder: ");
        preorder(root);

        System.out.print("\nInorder: ");
        inorder(root);

        System.out.print("\nPostorder: ");
        postorder(root);
    }
}
