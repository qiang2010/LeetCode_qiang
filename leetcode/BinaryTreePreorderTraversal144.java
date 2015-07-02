package qiang.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import qiang.tree.TreeAlg;
import qiang.tree.TreeNode;

public class BinaryTreePreorderTraversal144 extends TreeAlg{

	/**
	 *  
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinaryTreePreorderTraversal144 ins = new BinaryTreePreorderTraversal144();
		TreeNode root = ins.getTreeExample();
		System.out.println(ins.preorderTraversal(root).toString());
	}
	// 前序的非递归遍历
    public List<Integer> preorderTraversal(TreeNode root) {
        if(root == null ) return null;
        ArrayList<Integer> preOrder = new ArrayList<Integer>();
        Stack<TreeNode> preStack = new Stack<TreeNode>();
        preStack.add(root);
        preOrder.add(root.val);
        TreeNode temp = root,tempLeft,tempRight;
        
        while(!preStack.isEmpty()){
        	temp  = preStack.pop();
        	while(temp.left !=null){
        		tempLeft = temp.left;
        		preStack.add(tempLeft);
        		preOrder.add(tempLeft.val);
        		temp = tempLeft;
        	}
        	temp = preStack.pop();
        	temp = temp.right;
        	if(temp!=null) preStack.add(temp);
        }
        
        return preOrder;
    }
}
