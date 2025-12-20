
import java.util.*;

public class TopView {
    // top view of given tree

    static class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    static class Pair {

        int line;
        TreeNode node;

        public Pair(int line, TreeNode _node) {
            this.line = line;
            this.node = _node;
        }
    }

    public static  void  TopViewOfTree(TreeNode root) {
        ArrayList<Integer> ans = new ArrayList<>();
        Queue<Pair> q = new LinkedList<Pair>();
        TreeMap<Integer, Integer> map = new TreeMap<>();

        q.offer(new Pair(0, root));
        while(!q.isEmpty()){
            Pair temp = q.poll();
            TreeNode Node = temp.node;
            int line = temp.line;

            if(!map.containsKey(line)){
                map.put(line, Node.val);
            }


            //if(map.get(line) == null) map.put(line, Node.val);

            if(Node.left != null){
                q.add(new Pair(line-1, Node.left));
            }
            if(Node.right != null){
                q.add(new Pair(line+1, Node.right));
            }
        }

        System.out.println(map.toString());

        // for(Map.Entry<Integer, Integer> entry : map.entrySet()){
        //     ans.add(entry.getValue());
        // }

        // return ans;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(10);
        root.right.left = new TreeNode(9);
        root.right.right = new TreeNode(11);
        
        
        //System.out.println(TopViewOfTree(root));
        TopViewOfTree(root);
    }
}
