package medium_problem;

public class topic236 {

    /**
     * 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
     * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个节点 p、q，最近公共祖先表示为一个节点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        //当前节点为null则返回null，为要查找的其中一个节点则返回对应的节点
        if (root==null || root==p || root==q){
            return root;
        }

        TreeNode left = lowestCommonAncestor(root.left,p,q);
        TreeNode right = lowestCommonAncestor(root.right,p,q);

        //当前节点都有返回值，说明当前节点为最早的共同祖先
        if(left!=null && right!=null){

            return root;
        }

        //当有一个为null，则返回另一个或者都为null则返回null
        return left!=null?left:right;
    }

}
