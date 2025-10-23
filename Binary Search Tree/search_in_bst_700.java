public class search_in_bst_700{

    static class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) {
        val = x;
        left = null;
        right = null;
    }


    public TreeNode searchBST(TreeNode root, int val) {
        while(root != null && root.val != val){
            root = val<root.val ? root.left : root.right;
        }
        return root;
    }


}
    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(10);

        

    }
}