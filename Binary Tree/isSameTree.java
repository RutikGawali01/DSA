
public class isSameTree {
// check if both given tree is sorted or not
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

    public static boolean sameTree(TreeNode p, TreeNode q) {
        if (p == null || q == null) {
            return (p == q);
        }
        return (p.val == q.val) && sameTree(p.left, q.left) && sameTree(p.right, q.right);
    }

    public static void main(String[] args) {
        TreeNode p = new TreeNode(1);
        p.left = new TreeNode(2);
        p.right = new TreeNode(3);
        p.left.left = new TreeNode(4);
        p.left.right = new TreeNode(5);
        p.right.left = new TreeNode(6);
        p.right.right = new TreeNode(7);

        TreeNode q = new TreeNode(1);
        q.left = new TreeNode(2);
        q.right = new TreeNode(3);
        q.left.left = new TreeNode(4);
        q.left.right = new TreeNode(5);
        q.right.left = new TreeNode(6);
        q.right.right = new TreeNode(7);

        System.out.println(sameTree(p, q));

    }
}
