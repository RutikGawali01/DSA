import java.util.*;

public class UniqueTreeFrom_In_Post_order{
    // create tree from In-order znd post-order traversal
    
    static class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public static TreeNode ConstructTree(int[]Inorder, int[] postorder){
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0 ; i < Inorder.length ; i++){
            map.put(Inorder[i], i);
        }

        TreeNode root = BuildTreeHelp(Inorder, 0, Inorder.length-1, postorder, 0 , postorder.length-1, map);
        return root;
    }

    public static TreeNode BuildTreeHelp(int[] Inorder, int inStart, int inEnd, int[] postorder,int postStart, int postEnd, HashMap<Integer, Integer> map ){
        if(inStart > inEnd || postStart > postEnd)return null;

        TreeNode root = new TreeNode(postorder[postEnd]);
        int inRoot = map.get(root.val);
        int numLeft = inRoot-inStart;

        root.left = BuildTreeHelp(Inorder, inStart, inRoot-1, postorder, postStart, postStart+numLeft-1, map);
        root.right = BuildTreeHelp(Inorder, inRoot+1, inEnd, postorder, postStart+numLeft, postEnd-1, map);

        return root;
    }

    public static void main(String[] args) {
        
    }
}