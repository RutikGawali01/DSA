
import java.util.*;
//pre-order , In-order , post-order traversal
public class Pre_In_Post{
    
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
    static class Pair{
        TreeNode node;
        int num;

        public Pair(TreeNode node , int num){
            this.node = node;
            this.num = num; 
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);





        Stack<Pair> st = new Stack<>();
        List<Integer> pre = new ArrayList<>();
        List<Integer> in = new ArrayList<>();
        List<Integer> post = new ArrayList<>();


        st.push(new Pair(root, 1));
        while(!st.isEmpty()){
            Pair p = st.pop();
            if(p.num == 1){
                pre.add(p.node.val);
                p.num++;
                st.push(p);
                if(p.node.left != null){
                    st.push(new Pair(p.node.left , 1));
                }
            }else if(p.num == 2){
                in.add(p.node.val);
                p.num++;
                st.push(p);
                if(p.node.right!= null){
                    st.push(new Pair(p.node.right , 1));
                }
            }else{
                post.add(p.node.val);
            }
        }

    
        System.out.println(pre);
        System.out.println(in);
        System.out.println(post);

    }
}