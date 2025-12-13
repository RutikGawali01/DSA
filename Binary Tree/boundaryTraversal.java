
import java.util.ArrayList;

public class boundaryTraversal {
    // boundary traversal of binary tree in anti-clockwise direction 
    // steps 
    // 1 - all left boundary traversal element
    // 2 - ALL LEAF  nodes of given binary tree
    // 3 - all right boundary traverdal in reverse direction 

    static class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
            this.left = null;
            this.right = null;
        }
    }

    public static ArrayList<Integer> result = new ArrayList<>();

    public static boolean isLeaf(TreeNode root) {
        return (root.left == null && root.right == null);
    }

    // all left boundary element of given Tree
    public static void addLeft(TreeNode root, ArrayList<Integer> result) {
        TreeNode curr = root.left;
        while (curr.left != null) {
            if (!isLeaf(curr)) {
                result.add(curr.val);
            }
            if (curr.left != null) {
                curr = curr.left;
            }else {
                curr = curr.right;
            }
        }
    }

    // add all right element of given tree
    public static void addRight(TreeNode root , ArrayList<Integer> result){
        ArrayList<Integer> temp = new ArrayList<>();
        TreeNode curr = root.right;
        while(curr.right != null){
            if(!isLeaf(curr)){
                result.add(curr.val);
            }
            if(curr.right != null){
                curr = curr.right;
            }else {
                curr = curr.left;
            }
        } 

        for(int i = temp.size()-1 ; i>= 0 ; i--){
            result.add(temp.get(i));
        }
    }

    public static void addLeaf(TreeNode root , ArrayList<Integer> result ){
        if(isLeaf(root)){
            result.add(root.val);
            return;
        }
        if(root.left != null){
            addLeaf(root.left, result);
        }
        if(root.right != null){
            addLeaf(root.right, result);
        }
    }

    public static void boundaryTraversalOfTree(TreeNode root , ArrayList<Integer> result){
        if(root == null){
            return;
        }
        if(!isLeaf(root)){
            result.add(root.val);
        }

        addLeft(root, result);
        addLeaf(root, result);
        addRight(root, result);
    }

    public static void main(String[] args) {
        TreeNode p = new TreeNode(1);
        p.left = new TreeNode(2);
        p.right = new TreeNode(3);
        p.left.left = new TreeNode(4);
        p.left.right = new TreeNode(5);
        p.right.left = new TreeNode(6);
        p.right.right = new TreeNode(7);


        boundaryTraversalOfTree(p, result);

        System.out.println(result);
    }
}
