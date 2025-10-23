public class basic{

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


    //PreOrder -> Root-Left-Right (Recursive)
    public static void preOrder(TreeNode root){
        if(root == null){
            return;
        }
        System.out.print(root.val + " ");
        preOrder(root.left);
        preOrder(root.right);
    }

    // InOrder -> Left-Root-Right (Recursive)
    public static void InOrder(TreeNode root){
        if(root == null){
            return;
        }
        InOrder(root.left);
        System.out.print(root.val + " ");
        InOrder(root.right);
    }

    //PostOrder -> Left-Right-Root
    public static void PostOrder(TreeNode root){
        if(root == null){
            return;
        }
        PostOrder(root.left);
        PostOrder(root.right);
        System.out.print(root.val + " ");
    }

    

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        System.out.println("preorder: ");
        preOrder(root);
        System.out.println("postorder : ");
        PostOrder(root);
        System.out.println("Inorder");
        InOrder(root);

    }
}