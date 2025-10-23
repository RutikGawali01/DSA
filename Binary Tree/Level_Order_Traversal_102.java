import java.util.*;
// Leetcode 102 
public class Level_Order_Traversal_102{

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

    public static ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        if(root == null){
            return result;
        }
        q.add(root);
        while(!q.isEmpty()){
            ArrayList<Integer> levels = new ArrayList<>();
            int n = q.size();
            for(int i = 0 ; i<n ; i++){
                if(q.peek().left != null){
                    q.add(q.peek().left);
                }
                if(q.peek().right != null){
                    q.add(q.peek().right);
                }
                levels.add(q.remove().val);     
            }
            result.add(levels); 
        }
        return result;
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        ArrayList<ArrayList<Integer>> ans =  levelOrder(root);
        System.out.println(ans);

    }
}