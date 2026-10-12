import java.util.*;

class Solution {

    // Preorder: Root -> Left -> Right
    public void preorder(TreeNode root, List<Integer> result) {
        if (root == null) {
            return;
        }

        result.add(root.val);
        preorder(root.left, result);
        preorder(root.right, result);
    }

    // Inorder: Left -> Root -> Right
    public void inorder(TreeNode root, List<Integer> result) {
        if (root == null) {
            return;
        }

        inorder(root.left, result);
        result.add(root.val);
        inorder(root.right, result);
    }

    // Postorder: Left -> Right -> Root
    public void postorder(TreeNode root, List<Integer> result) {
        if (root == null) {
            return;
        }

        postorder(root.left, result);
        postorder(root.right, result);
        result.add(root.val);
    }
}