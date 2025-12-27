
import java.util.*;

public class NodesDistanceK {
    // print all nodes at a distance of  k  in binary tree

    static class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public static HashMap<TreeNode, TreeNode> storeParent(TreeNode root) {
        HashMap<TreeNode, TreeNode> map = new HashMap<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            TreeNode node = q.poll();
            // if target is given in the form of int val 
            // TreeNode position;
           // if(node.val == target ) position = node;
            

            if (node.left != null) {
                q.add(node.left);
                map.put(node.left, node);
            }
            if (node.right != null) {
                q.add(node.right);
                map.put(node.right, node);
            }
        }
        return map;
    }



    public static ArrayList<Integer> PrintNodesAtDistK(TreeNode root, TreeNode target, int k) {
        HashMap<TreeNode, TreeNode> parentMap = storeParent(root);

        //TreeNode NewRoot = FindPositionOfTargetNOde(root, target);
        Queue<TreeNode> queue = new LinkedList<>();
         Set<TreeNode> visited = new HashSet<>();
        int dist = 0;

        queue.offer(target);
        visited.add(target);
        while (!queue.isEmpty()) {
            if (dist == k) {
                break;
            }

            int n = queue.size();
            for (int i = 0; i < n; i++) {
                TreeNode node = queue.poll();

                // Explore left child
                if (node.left != null && !visited.contains(node.left)) {
                    visited.add(node.left);
                    queue.offer(node.left);
                }

                // Explore right child
                if (node.right != null && !visited.contains(node.right)) {
                    visited.add(node.right);
                    queue.offer(node.right);
                }

                // Explore parent from map
                if (parentMap.containsKey(node) && !visited.contains(parentMap.get(node))) {
                    visited.add(parentMap.get(node));
                    queue.offer(parentMap.get(node));
                }
            }
            dist++;
        }

        ArrayList<Integer> res = new ArrayList<>();

        while (!queue.isEmpty()) {
            res.add(queue.poll().val);
        }
        return res;

    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.right = new TreeNode(1);

        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);

        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);

        root.left.right.right = new TreeNode(4);
        root.left.right.left = new TreeNode(7);

        //HashMap<TreeNode , TreeNode>  map = storeParent(root);
        System.out.println(PrintNodesAtDistK(root, root.left, 2));
        //System.out.println(map);

    }
}
