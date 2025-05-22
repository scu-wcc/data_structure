package simple_problem;

public class topic226 {

    /**
     * 给你一棵二叉树的根节点 root ，翻转这棵二叉树，并返回其根节点。
     */
    public TreeNode invertTree(TreeNode root) {
        root = invertTreeImpl(root);

        return root;
    }

    public TreeNode invertTreeImpl(TreeNode root){
        if(root==null){
            return null;
        }

        TreeNode left = invertTreeImpl(root.left);
        TreeNode right = invertTreeImpl(root.right);

        root.left=right;
        root.right=left;

        return root;



    }


}
