
import java.util.*;

public class UniqueTreeFromIn_Pre_order {
    // construct a binary tree from Inorder and pre-order traversal --
    // tree will be unique 

    static class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public static TreeNode ConstructTree(int[] inorder, int[] preorder) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i = 0 ;i<inorder.length ; i++){
            map.put(inorder[i], i);
        }

        TreeNode root = BuildTree(preorder ,0,( preorder.length-1), inorder, 0 , (inorder.length-1) , map );
        
        return root;

    }

    public static TreeNode BuildTree(int[] preorder , int preStart, int preEnd, int[] inorder , int inStart , int inEnd, HashMap<Integer,Integer> inmap){
        // check if inorder and preorder is empty or not
        if(preStart > preEnd || inStart > inEnd) return null;

        TreeNode root = new TreeNode(preorder[preStart]);
        int inRoot = inmap.get(root.val);
        int numLeft = inRoot - inStart;

        root.left = BuildTree(preorder, preStart+1, preStart+numLeft, inorder, inStart, inRoot-1, inmap);

        root.right = BuildTree(preorder, preStart+numLeft+1, preEnd, inorder, inRoot+1, inEnd, inmap);

        return root;

    }

    public static void main(String[] args) {
        int[] inorder ={40, 20, 50, 10, 60, 30};
        int[] preorder = {10, 20 ,40 ,50, 30, 60};
        ConstructTree(inorder , preorder);

        

    }
}
