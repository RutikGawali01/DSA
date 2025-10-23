public class Balanced_BT_110{
   
    static class TreeNode {
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

    public static int findheight(TreeNode root){
        if(root == null){
            return 0;
        }
        int left = findheight(root.left);
        int right = findheight(root.right);

        return  (1+ (Math.max(left, right) )); 
    }
    // this solution is taking O(n)* O(n) time complexity 
    public static boolean balancedBT(TreeNode root){
        if(root ==null){
            return true;
        }
        int lh = findheight(root.left);
        int rh = findheight(root.right);

        if( Math.abs(rh-lh) > 1){
            return false;
        }

        return balancedBT(root.left) && balancedBT(root.right);

    }
    

    public static int height(TreeNode root){
        if(root == null){
            return 0;
        }
        int lh = height(root.left);
        int rh = height(root.right);

        if(Math.abs( ( lh - rh)) >1 ){
            return -1;
        }
        return 1+Math.max(lh, rh);

    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        //System.out.println(balancedBT(root));

        if(height(root) == -1){
            System.out.println("false");
        }else{
            System.out.println("true");
        }

    }

}