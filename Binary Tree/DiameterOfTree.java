
public class DiameterOfTree {
    // longest path between any two nodes is diameter

    static class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
            this.left = null;
            this.right = null;
        }
    }
    public static int maxdiameter = 0;

    public static int height(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int lh = height(root.left);
        int rh = height(root.right);

        maxdiameter = Math.max(maxdiameter, (lh + rh));
        return 1 + Math.max(lh, rh);
    }

    public static int treeDiameter(TreeNode root) {
        height(root);
        return maxdiameter;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        System.out.println(treeDiameter(root));

    }
}
