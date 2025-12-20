import  java.util.*;
public class MaxWidth {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val) {
            this.val = val;
        }
    }

    static class Pair{
        TreeNode node;
        int index;

        Pair(TreeNode node, int index){
            this.node = node;
            this.index = index;
        }
    }

    // maximum width for any level -- max no of nodes in a level between any 2 non - null nodes
    // bettween two end  non-null nodes null nodes can be considered for width of tree
    public static int maxWidthOfTree(TreeNode root ){
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(root, 0));
        int width = 0;

        while(!q.isEmpty()){
            
            int min = q.peek().index;
            int n = q.size();
            int first = 0;
            int last = 0;
            for(int i = 0 ; i<n ; i++){

                TreeNode temp = q.peek().node;
                int up_ind = q.peek().index - min;
                q.poll();

                if(i == 0){
                    first = up_ind;
                }
                if(i == n-1) last = up_ind;

                if(temp.left != null){
                    q.offer(new Pair(temp.left, (2*up_ind + 1)));
                }
                if(temp.right != null){
                    q.offer(new Pair(temp.right, (2*up_ind + 2)));
                }

            }
            width = Math.max(width, last-first+1);
        }
        return  width;
    }

    public static void main(String[] args) {
     TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        root.right.left = new TreeNode(8);
        root.right.right = new TreeNode(9);

        root.left.right.right = new TreeNode(7);
        root.left.right.left = new TreeNode(6);   

        System.out.println(maxWidthOfTree(root));
    }
}