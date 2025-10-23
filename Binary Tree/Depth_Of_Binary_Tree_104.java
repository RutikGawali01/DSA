public class Depth_Of_Binary_Tree_104{

    static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val ) {
            this.val = val;
            this.left = null;
            this.right = null;
        } 
    }


    public static int maxDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);

        return 1+ Math.max(left, right);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        System.out.println(maxDepth(root));
    }
}