public  class LCA_In_BST{
     static  class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
            TreeNode(int val, TreeNode left, TreeNode right) {
                this.val = val;
                this.left = left;
                this.right = right;
            }
    }
   public static TreeNode LCA(TreeNode root, int p, int q){
    if(root ==  null)return null;

    int val = root.val;
    if(val < p && val<q){
        return LCA(root.right, p, q);
    }else if(val > p && val > q){
        return LCA(root.left, p, q);
    }
    return root;

   } 
    public static void main(String[] args) {
        
    }
}