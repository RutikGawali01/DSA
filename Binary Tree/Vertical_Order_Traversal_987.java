
import java.util.*;
public class Vertical_Order_Traversal_987{
    
    // leetcode 987

    // Define the structure of a tree node
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    // Tuple class to hold node + its vertical and level info
    static class Tuple {
        TreeNode node;
        int row;  // vertical (x)
        int col;  // level (y)

        public Tuple(TreeNode _node, int _row, int _col) {
            node = _node;
            row = _row;
            col = _col;
        }
    }


    public static List<List<Integer>> verticalTraversal(TreeNode root) {
        // Map<vertical, Map<level, PriorityQueue of node values>>
        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map = new TreeMap<>();
        Queue<Tuple> q = new LinkedList<>();
        q.offer(new Tuple(root, 0, 0));

        // BFS traversal
        while (!q.isEmpty()) {
            Tuple tuple = q.poll();
            TreeNode node = tuple.node;
            int x = tuple.row;  // vertical
            int y = tuple.col;  // level

            // Insert into map
            if (!map.containsKey(x))
                map.put(x, new TreeMap<>());
            if (!map.get(x).containsKey(y))
                map.get(x).put(y, new PriorityQueue<>());
            map.get(x).get(y).offer(node.val);

            // Add children
            if (node.left != null)
                q.offer(new Tuple(node.left, x - 1, y + 1));
            if (node.right != null)
                q.offer(new Tuple(node.right, x + 1, y + 1));
        }

        // Build final result
        List<List<Integer>> list = new ArrayList<>();
        for (TreeMap<Integer, PriorityQueue<Integer>> ys : map.values()) {
            list.add(new ArrayList<>());
            for (PriorityQueue<Integer> nodes : ys.values()) {
                while (!nodes.isEmpty()) {
                    list.get(list.size() - 1).add(nodes.poll());
                }
            }
        }
        return list;
    }

    public static void main(String[] args) {
        // Build example binary tree
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(10);
        root.right.left = new TreeNode(9);
        root.right.right = new TreeNode(10);
        root.left.left.right = new TreeNode(5);
        root.left.left.right.right = new TreeNode(6);

        List<List<Integer>> result = verticalTraversal(root);

        System.out.println("Vertical Order Traversal:");
        for (List<Integer> col : result) {
            System.out.println(col);
        }
    }
}
