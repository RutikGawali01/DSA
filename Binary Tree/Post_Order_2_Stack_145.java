import java.util.*;
public class Post_Order_2_Stack_145{

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

    public static  List<Integer> postorderTraversal(TreeNode root) {
        Stack<TreeNode> st1 = new Stack<>();
        Stack<TreeNode> st2 = new Stack<>();
        List<Integer> tree = new ArrayList<>();

        st1.push(root);
        while(!st1.isEmpty()){
            TreeNode temp = st1.pop();
            st2.push(temp);
            if(temp.left!= null){
                st1.push(temp.left);
            }
            if(temp.right!= null){
                st1.push(temp.right);
            }
        }
        while(!st2.isEmpty()){
            tree.add(st2.pop().val);
        }
        return tree;

    }



    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        System.out.println(postorderTraversal(root));
    }
}