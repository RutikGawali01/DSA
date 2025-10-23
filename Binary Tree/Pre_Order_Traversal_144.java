import java.util.*;
public class Pre_Order_Traversal_144{
    //Leetcode 144
    static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode(int val) {
            this.val = val;
            this.left = null;
            this.right = null;
        }
    }

    // Iterative pre-order traversal
    public static  List<Integer> preorderTraversal(TreeNode root) {
        Stack<TreeNode> st = new Stack<>();
        List<Integer> tree = new ArrayList<>();
        if(root == null){
            return tree;
        }
        st.add(root);


        while(!st.isEmpty()){
            TreeNode node = st.pop();

            tree.add(node.val);
            
            if(node.right != null){
                st.add(node.right);
            }
            if(node.left != null){
                st.add(node.left);
            }
            
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

        System.out.println(preorderTraversal(root));
    }
}