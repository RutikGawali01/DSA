import java.util.*;
public class TwoSumInBst653{
    //leetcode 653 
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

    // inorder
    public static void addlist(TreeNode root , ArrayList<Integer> list){
        if(root == null){
            return;
        }
        addlist(root.left, list);
        list.add(root.val);
        addlist(root.right, list);
    }

    public static ArrayList<Integer> inorder(TreeNode root){
        ArrayList<Integer> list = new ArrayList<>();
        addlist(root, list);
        return list;

    }

    public static boolean TwoSumInBST(TreeNode root , int k){
        ArrayList<Integer> list = inorder(root);
        int n = list.size();
        int left = list.get(0);
        int right = list.get(n-1);
        int l = 0;
        int r = n-1;
        while(l < r){
            if(list.get(l) + list.get(r) == k){
                return true;
            }else if(list.get(l) + list.get(r) < k){
                l++;
            }else{
                r++;
            }
        }
        return false;
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.right.right = new TreeNode(7);
        
        //System.out.println(inorder(root));

        System.out.println(TwoSumInBST(root, 9));
    }
}