
import java.util.*;

public class  ZigZagOrSpiralTraversal{
    // zig zag order traversal -> spiral order traversall

    static class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
            this.left = null;
            this.right = null;
        }
    }

    public static ArrayList<int[]> ZigZagSpiral(TreeNode root){

        Queue<TreeNode> q = new LinkedList<>();
        ArrayList<int[]> result = new ArrayList<>();
        q.add(root);
        boolean LeftToRight = true;
        while(!q.isEmpty()){
            int n = q.size();
            int row[] = new int[n];
            for(int i = 0  ; i < n ; i++){
                TreeNode temp = q.peek();
                int index  = (LeftToRight == true) ? i : n-i-1;
                row[index] = temp.val;
                if(temp.left != null){
                    q.add(temp.left);
                }
                if(temp.right != null){
                    q.add(temp.right);
                }
                q.remove();
            }
            LeftToRight = !LeftToRight;
            result.add(row);
        }

        return result;
    }





    public static void main(String[] args) {
        TreeNode p = new TreeNode(1);
        p.left = new TreeNode(2);
        p.right = new TreeNode(3);
        p.left.left = new TreeNode(4);
        p.left.right = new TreeNode(5);
        p.right.left = new TreeNode(6);
        p.right.right = new TreeNode(7);


        ArrayList<int[]> res = ZigZagSpiral(p);

        for(int i = 0 ; i<res.size() ; i++){
            int[] row = res.get(i);
            for(int j = 0 ; j<row.length ; j++){
                System.out.println(row[j]);
            }
        }

    }
}