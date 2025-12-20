public class CommonAncestor{
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val) {
            this.val = val;
        }
    }

    public static TreeNode LowestCommonAncestor(TreeNode root, int a, int b){
        if(root == null)return null;
        if((root.val == a)|| (root.val == b)){
            return root;
        }

        TreeNode l = LowestCommonAncestor(root.left, a, b);
        TreeNode r = LowestCommonAncestor(root.right, a, b);
        if(l != null &&  r!= null){
            return root;
        }
        if(l == null)return r;
        if(r == null) return l;

        return null;
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        root.right.left = new TreeNode(8);
        root.right.right = new TreeNode(9);

        root.left.right.right = new TreeNode(7);
        root.left.right.left = new TreeNode(6);


        // System.out.println(LowestCommonAncestor(root, 2, 6));
        TreeNode ans = LowestCommonAncestor(root, 2, 6);
        System.out.println(ans.val);
    }
}