import java.util.*;
public class LeftView{
    // right side view of given binary tree

     static class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }
    static  class Pair{
        TreeNode node;
        int level;

        public Pair(TreeNode node , int level) {
            this.node = node;
            this.level = level;
        }

        
    }
    

    // iterative solution will cause time and space comple-- O(N)
    public static ArrayList<Integer> leftView(TreeNode root ){
        Queue<Pair> q = new LinkedList<>();
        TreeMap<Integer, Integer> map = new TreeMap<>();

        q.add(new Pair(root, 0));
        while(!q.isEmpty()){
            Pair temp = q.poll();
            TreeNode tempnode = temp.node;
            int row = temp.level;

            map.put(row, tempnode.val);

            
            if(tempnode.right != null){
                q.offer(new Pair(tempnode.right, row+1));
            }
            if(tempnode.left != null){
                q.offer(new Pair(tempnode.left, row+1));
            }
        }

        ArrayList<Integer> ans = new ArrayList<>();
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            ans.add(entry.getValue());
        }

        return ans;

    }


    // Recursive solution will cause Time - O(n) and Space -- O(H) h - hight of Bt
    public static ArrayList<Integer> result = new ArrayList<>();
    public static void left(TreeNode root , int level){
        if(root == null){
            return;
        }
        if(level == result.size()){
            result.addLast(root.val);
        }
        
        left(root.left, level+1);
        left(root.right, level+1);
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

        System.out.println(leftView(root));
        left(root, 0);
        System.out.println(result);
        
    }
}