public class CountNodesInCompleteBinaryTree{

     static class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    // 1st understand concept of complete  binary Tree with all its possible
    public static int CountNodes(TreeNode root){
        if(root == null) return 0;
        int left = getLeftHeight(root);
        int right = getRightHeight(root);

        if(left == right){
            return (2<<left)-1;
        }
        return 1+CountNodes(root.left)+CountNodes(root.right);
    }

    public static int getLeftHeight(TreeNode root){
        int height = 0;
        while(root.left != null){
            height++;
            root = root.left;
        }
        return height;
    }

    public static int getRightHeight(TreeNode root){
        int height = 0;
        while(root.right !=  null){
            height++;
            root = root.right;
        }
        return height;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        //root.left.left.right = new TreeNode(7);

        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        root.left.right.right = new TreeNode(11);
        root.left.right.left = new TreeNode(10);

        root.left.left.left = new TreeNode(8);
        root.left.left.right = new TreeNode(9);

        System.out.println(CountNodes(root));
        
    }
}