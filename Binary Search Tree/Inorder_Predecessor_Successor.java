
public class Inorder_Predecessor_Successor{
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
    

    // in order successor 
    public static int  findSuc(TreeNode root , int key){
        //if(root == null)return;

        TreeNode pre = null;
        TreeNode suc  = null;

        TreeNode temp = root;
        while(temp != null){
            if(temp.val > key){
                suc = temp;
                temp = temp.left;
            }else{
                temp = temp.right;
            }
        }
        return suc.val;

    }

    // inorder pre-decessor
    public static int  findPre(TreeNode root , int key){
        //if(root == null)return;

        TreeNode pre = null;
        TreeNode suc  = null;

        TreeNode temp = root;
        while(temp != null){
            if(temp.val < key){
                suc = temp;
                temp = temp.right;
            }else{
                temp = temp.left;
            }
        }
        return suc.val;

    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.left.left.left = new TreeNode(1);
        //inoder- 1, 2, 3, 4, 5 , 6

        System.out.println(findSuc(root, 4));
        
    }
}