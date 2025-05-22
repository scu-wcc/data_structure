package medium_problem;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class topic102 {
    /**
     * 给你二叉树的根节点 root ，返回其节点值的 层序遍历 。 （即逐层地，从左到右访问所有节点）。
     */

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        topic102 p = new topic102();
        List<List<Integer>> lists = p.levelOrder(root);
        for (List<Integer> list:lists){
            System.out.println(list);
        }
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> totalList = new ArrayList<>();
        if(root==null){
            return totalList;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        getTreeList(root,root,totalList,null,queue,root);

       return totalList;

    }

    public void getTreeList(TreeNode levelStartNode, TreeNode levelEndNode ,List<List<Integer>> totalList, List<Integer> ziList,Queue<TreeNode> queue, TreeNode lastNode){
            if(queue.isEmpty()){
                return;
            }

            TreeNode curNode = queue.remove();
            if(curNode == levelStartNode){
                ziList = new ArrayList<>();
                levelStartNode=null;
            }

              ziList.add(curNode.val);

            if(curNode==levelEndNode){
                totalList.add(ziList);
                levelEndNode=null;
            }

            TreeNode left = curNode.left;
            TreeNode right =curNode.right;

            if(left!=null || right!=null){
                lastNode = right!=null?right:left;
                if(levelStartNode == null){
                    levelStartNode=left!=null?left:right;
                }
            }

            if(levelEndNode==null){
                levelEndNode=lastNode;
            }

            if(left!=null){
                queue.add(left);
            }
            if(right!=null){
                queue.add(right);
            }

            getTreeList(levelStartNode,levelEndNode,totalList,ziList,queue,lastNode);
    }

}
