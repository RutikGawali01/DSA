import java.util.*;
public class  PathToNode{
    // print Root to Node Path In Binary Tree

    static class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }
    //public static ArrayList<Integer> ans = new ArrayList<>();
    public static boolean pathTONode(TreeNode root , TreeNode node, ArrayList<Integer> ans ){
        if(root == null)return false;

        ans.add(root.val);
        if(root.val == node.val){
            return true;
        }
        boolean left = pathTONode(root.left, node, ans);


        
        boolean right = pathTONode(root.right, node, ans);

        if(left || right){
            return  true;
        }
        ans.remove(ans.size()-1);
        return false;
    }

    public static void main(String[] args) {
         TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(10);
        root.right.left = new TreeNode(9);
        root.right.right = new TreeNode(11);
        root.left.right.right = new TreeNode(15);

        //pathTONode( root, root.left.right.right);
        // ans.add(1);
        // ans.add(3);
        // ans.remove(ans.size()-1);
        ArrayList<Integer> ans = new ArrayList<>();
        pathTONode( root, root.left.right.right , ans);
        System.out.println(ans);
        
    }
}