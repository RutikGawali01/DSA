
import java.util.*;

public class ChildrenSumProperty {

    static class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public static TreeNode childrenSumPropertyHelper(TreeNode root) {
        if (root == null) {
            return root;
        }
        int leftVal = 0;
        int rightVal = 0;

        int value = root.val;
        if (root.left != null) {
            leftVal = root.left.val;
        }

        if (root.right != null) {
            rightVal = root.right.val;
        }

        if (leftVal + rightVal < value) {
            if (root.left != null) {
                root.left.val = value;
            }

            if (root.right != null) {
                root.right.val = value;
            }
        } else if (leftVal + rightVal >= value) {
            root.val = leftVal + rightVal;
        }

        TreeNode left = childrenSumPropertyHelper(root.left);
        TreeNode right = childrenSumPropertyHelper(root.right);

        if (left != null && right != null) {
            root.val = left.val + right.val;
        }
        return root;
    }

    public static List<Integer> inorderTraversal(TreeNode root) {
        Stack<TreeNode> st = new Stack<>();
        List<Integer> tree = new ArrayList<>();

        TreeNode node = root;
        while (true) {
            if (node != null) {
                st.push(node);
                node = node.left;
            } else {
                if (st.isEmpty()) {
                    break;
                }
                TreeNode temp = st.pop();
                tree.add(temp.val);
                node = temp.right;
            }
        }
        return tree;
    }

    public static void main(String[] args) {

        TreeNode root = new TreeNode(40);
        root.left = new TreeNode(10);
        root.right = new TreeNode(20);

        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(5);

        root.right.left = new TreeNode(30);
        root.right.right = new TreeNode(40);

        TreeNode rem = childrenSumPropertyHelper(root);

        System.out.println(inorderTraversal(rem));

    }
}
