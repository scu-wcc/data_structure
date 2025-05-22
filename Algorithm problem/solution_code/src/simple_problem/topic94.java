package simple_problem;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class topic94 {
    /**
     *给定一个二叉树的根节点 root ，返回 它的 中序 遍历 。
     */
    List<Integer> list = new ArrayList<Integer>();
    public List<Integer> inorderTraversal(TreeNode root) {
        //inorder(root);

        Stack<TreeNode> stack = new Stack<>();

        while (!stack.isEmpty()|| root!=null){
            //将左孩子不断压入栈，直到左孩子为null
            while (root!=null){
                stack.push(root);
                root = root.left;
            }
            //获取当前节点(当前根节点)
            root = stack.pop();
            list.add(root.val);
            //获取当前节点的右孩子
            root = root.right;


        }
        return list;
    }

    public void inorder(TreeNode root){
        if(root == null){
            return;
        }

        inorder(root.left);
        list.add(root.val);
        inorder(root.right);
    }


}
