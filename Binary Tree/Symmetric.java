public  class  Symmetric{

   
    static class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public static boolean  isSymmetric(TreeNode root){
        return root == null || isSymmetricHelp(root.left , root.right);
    }
     public  static boolean isSymmetricHelp(TreeNode left, TreeNode right) {
        if(left == null || right == null){
            return left == right;
        }
        if(left.val != right.val)return false;

        return isSymmetricHelp(left.left, right.right) && isSymmetricHelp(left.right, right.left);
    }

    public static void main(String[] args) {
         TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(10);
        root.right.left = new TreeNode(9);
        root.right.right = new TreeNode(11);
        root.left.right.right = new TreeNode(15);

        System.out.println(isSymmetric(root));
        
    }
}