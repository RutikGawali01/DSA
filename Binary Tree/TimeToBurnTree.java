
import java.util.*;

public class TimeToBurnTree {

    static class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public static TreeNode position;

    public static void storeParent(TreeNode root, int target, HashMap<TreeNode, TreeNode> map) {

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            TreeNode node = q.poll();
            // if target is given in the form of int val 
            // TreeNode position;
            if (node.val == target) {
                position = node;
            }

            if (node.left != null) {
                q.add(node.left);
                map.put(node.left, node);
            }
            if (node.right != null) {
                q.add(node.right);
                map.put(node.right, node);
            }
        }

    }

    public static int MinTimeToBurn(TreeNode root, int target) {
        Set<TreeNode> visited = new HashSet<>();
        Queue<TreeNode> queue = new LinkedList<>();
        HashMap<TreeNode, TreeNode> map = new HashMap<>();

        storeParent(root, target, map);

        queue.offer(position);
        visited.add(position);
        int time = 0;
        while (!queue.isEmpty()) {
            int n = queue.size();
            int flag = 0;
            for (int i = 0; i < n; i++) {
                TreeNode curr = queue.poll();

                if (curr.left != null && !visited.contains(curr.left)) {
                    flag = 1;
                    queue.offer(curr.left);
                    visited.add(curr.left);
                }

                if (curr.right != null && !visited.contains(curr.right)) {
                    flag = 1;
                    queue.offer(curr.right);
                    visited.add(curr.right);
                }

                if (map.containsKey(curr) && !visited.contains(map.get(curr))) {
                    flag = 1;
                    queue.offer(map.get(curr));
                    visited.add(map.get(curr));
                }
            }
            if (flag == 1) {
                time++;
            }
        }
        return time;

    }

    public static void main(String[] args) {

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        root.left.left = new TreeNode(4);
        //root.left.right = new TreeNode(2);
        root.left.left.right = new TreeNode(7);

        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(6);

        //root.left.right.right = new TreeNode(4);
        //root.left.right.left = new TreeNode(7);

        int time = MinTimeToBurn(root, 3);
        System.out.println(time);
    }
}
