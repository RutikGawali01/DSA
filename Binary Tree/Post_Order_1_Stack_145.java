import java.util.*;
public class Post_Order_1_Stack_145{

     static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val ) {
            this.val = val;
            this.left = null;
            this.right = null;
        } 
    }

    public static List<Integer> postorderTraversal(TreeNode root) {
        TreeNode curr = root;
        Stack<TreeNode> st = new Stack<>();
        List<Integer> tree = new ArrayList<>();
        TreeNode temp;
        while(curr != null || !st.isEmpty()){
            if(curr!= null){
                st.push(curr);
                curr = curr.left;
            }else{
                temp = st.peek().right;
                    
                if(temp == null){
                    temp = st.pop();
                    tree.add(temp.val);


                    while(!st.isEmpty() && temp == st.peek().right){
                        temp = st.pop();
                        tree.add(temp.val);
                    }

                }else{
                    curr = temp;
                }
                
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

        System.out.println(postorderTraversal(root));
    }

}