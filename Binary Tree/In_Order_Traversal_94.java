import java.util.*;
public class In_Order_Traversal_94{
    //leetcode 94
    static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode(int val) {
            this.val = val;
            this.left = null;
            this.right = null;
        }
    }

    public static  List<Integer> inorderTraversal(TreeNode root) {
        Stack<TreeNode> st = new Stack<>();
        List<Integer> tree = new ArrayList<>();

        TreeNode node = root;
        while(true){
            if(node != null){
                st.push(node);
                node = node.left;
            }else{
                if(st.isEmpty()){
                    break;
                }
                TreeNode temp = st.pop(); 
                tree.add(temp.val);
                node = temp.right;
            }
        }
        return tree;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        System.out.println(inorderTraversal(root));
    }
}