import java.util.*;
public class MorrisTraversal{
    // morris traversal using TC - O(n) and SSC - O(1) using threaded binary tree

    // create thread if  not created and delete thread if exist


    static class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public static ArrayList<Integer> morrisTraversal_Inorder (TreeNode root){
        ArrayList<Integer> inorder = new ArrayList<>();
        ArrayList<Integer> preorder = new ArrayList<>();
        TreeNode curr = root;
        while(curr != null){
            // case 1 -- left null-- print curr and move to right 
            if(curr.left == null){
                inorder.add(curr.val);
                preorder.add(curr.val);// for preorder traversal 
                curr = curr.right;
            }
            // for case 2 - rightmost node of left subtree points to curr and
            // move curr to left after creating thread 
            // if prev.right== curr -- means thread alraeady exists -- break thread and move to right of curr
            else{
                TreeNode prev = curr.left;
                while(prev.right != null && prev.right != curr){
                    prev = prev.right;
                }
                if(prev.right == null){
                    prev.right = curr;// create thread 
                    preorder.add(curr.val); // for preoder traversal
                    curr = curr.left;
                }else{
                    prev.right = null;// break thread
                    inorder.add(curr.val);
                    curr = curr.right;
                }
            }
        }
        return inorder;

    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.left.right.right = new TreeNode(6);

        //root.right.left = new TreeNode(4);
        //root.right.right = new TreeNode(5);
        
        System.out.println(morrisTraversal_Inorder(root));
    }
}