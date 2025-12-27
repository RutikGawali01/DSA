
import java.util.Stack;

public  class FlattenBInaryTree{
    // flatten a binary tree into a linked list 

     static class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    // 1 -- Right-Left-Root 
    // Tc - O(n) and SC - O(1)
    public static TreeNode prev = null;
    public static void flatten(TreeNode node){
        if(node == null) return;

        // call for right
        flatten(node.right);
        // call for left
        flatten(node.left);
        // operations on root
        node.right = prev;
        node.left = null;
        prev = node;
        
    }
    
    // TC and SC - O(n)
    public static void flattenTreeUsingStack(TreeNode root){
        Stack<TreeNode> st = new Stack<>();
        st.push(root);
        while(!st.isEmpty()){
            TreeNode curr = st.pop();
            if(curr.right != null) st.push(curr.right);

            if(curr.left != null ) st.push(curr.left);

            if(!st.isEmpty()){
                curr.right =st.peek();
                
            }
            curr.left = null;
        }
    }


    public static void  FlattenBinaryTree(TreeNode root){
        TreeNode curr = root;
        while(curr != null){
            if(curr.left != null){
                TreeNode prevv = curr.left;
                while(prevv.right != null){
                    prevv = prevv.right;
                }
                prevv.right = curr.right;
                curr.right = curr.left;
                curr.left = null;
            }
            curr= curr.right;
        }
    }
    public static void main(String[] args) {

        
    }
}