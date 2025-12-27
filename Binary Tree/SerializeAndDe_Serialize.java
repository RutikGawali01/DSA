
import java.util.*;

public class SerializeAndDe_Serialize {
    // we have to write 2 function serialize and De-serialize 
    // serialize - given root of tree --> String 
    // De-serialize - serialized string --> into original tree with root 

    static class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    // converting tree into string using level order traversal 
    public static String serialize(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        if (root == null) {
            return sb.toString();
        }
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            // n is used to define null 
            if (node == null) {
                sb.append("n ");
                continue;
            }
            // space is used to separate two nodes
            sb.append(node.val + " ");
            // add left and right despite of having left and right as null
            queue.offer(node.left);
            queue.offer(node.right);
        }
        return sb.toString();
    }

    public static TreeNode deSerialize(String data) {
        if (data == "") {
            return null;
        }
        Queue<TreeNode> q = new LinkedList<>();
        // converting string into array for easy access of values
        String[] val = data.split(" ");
        TreeNode root = new TreeNode(Integer.parseInt(val[0]));
        q.offer(root);

        for (int i = 1; i < val.length; i++) {
            TreeNode parent = q.poll();
            if (!val[i].equals("n")) {
                TreeNode left = new TreeNode(Integer.parseInt(val[i]));
                parent.left = left;
                q.add(left);
            }
            // this does not gives  exception 
            ///Because usually serialized tree strings have even count values with nulls 'n',
            // so pairs of left-right exist
            if (!val[++i].equals("n")) {
                TreeNode right = new TreeNode(Integer.parseInt(val[i]));
                parent.right = right;
                q.offer(right);
            }

        }

        return root;
    }

    public static void main(String[] args) {

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        //root.left.left = new TreeNode(4);
        //root.left.right = new TreeNode(5);
        //root.left.left.right = new TreeNode(7);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(5);

        //serialize(root);
        //deSerialize(serialize(root));

}
