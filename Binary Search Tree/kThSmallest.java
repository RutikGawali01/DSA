import java.util.*;
public class kThSmallest{
    // Leetcode 230
    public static  class TreeNode {
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

    public static void addlist(TreeNode root , ArrayList<Integer> list){
        if(root == null){
            return;
        }
        addlist(root.left, list);
        list.add(root.val);
        addlist(root.right, list);
    }

    // public static ArrayList<Integer> inorder(TreeNode root){
    //     ArrayList<Integer> list = new ArrayList<>();
    //     addlist(root, list);
    //     return list;

    // }
    static  class abc{
        int val=0;
    }



     public static void helper(TreeNode root , abc count){
        if(root == null){
            return;
        }
        helper(root.left, count);
        count.val++;
        helper(root.right, count);
    }

    public static int countNodes(TreeNode root){
        abc count=new abc();
        helper(root, count);
        return count.val;
    }

    public int kthSmallest(TreeNode root, int k) {

         ArrayList<Integer> list = new ArrayList<>();
        addlist(root, list);
        return list.get(k-1);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.left.left.left = new TreeNode(1);

        //System.out.println(inorder(root));

        System.out.println(countNodes(root));

        

    }
}