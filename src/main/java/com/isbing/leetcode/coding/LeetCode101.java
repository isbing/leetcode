package com.isbing.leetcode.coding;

import com.isbing.leetcode.LeetCoding;
import com.isbing.leetcode.bean.TreeNode;

import java.util.Stack;

/**
 * Created by song bing
 * Created time 2019/5/14 19:05
 */
public abstract class LeetCode101 extends LeetCoding {

	// 递归 空间为O(n) 时间O(n) 把所有的节点 都走了一遍
	// 迭代 空间为O(n) 时间O(n)

	/**
	 * 给定一个二叉树，检查它是否是镜像对称的。
	 * 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
	 *     1
	 *    / \
	 *   2   2
	 *  / \ / \
	 * 3  4 4  3
	 * 但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:
	 *     1
	 *    / \
	 *   2   2
	 *    \   \
	 *    3    3
	 */
	@Override
	public boolean isSymmetric(TreeNode root) {
		//return solution1(root);
		return solution2(root);
	}

	// 递归
	public boolean solution1(TreeNode root){
		return digui(root.left,root.right);
	}

	// 用辅助栈
	public boolean solution2(TreeNode root){
		if(root == null) return true;
		Stack<TreeNode> stack = new Stack<>();
		stack.push(root.left);
		stack.push(root.right);

		while (!stack.empty()){
			TreeNode left = stack.pop();
			TreeNode right = stack.pop();
			if(left == null && right == null) continue;
			if(left == null || right == null) return false;
			if(left.val != right.val) return false;
			stack.push(left.left);
			stack.push(right.right);
			stack.push(left.right);
			stack.push(right.left);
		}
		return true;
	}

	// 递归
	public boolean digui(TreeNode left,TreeNode right){
		if(left == null && right == null){
			return true;
		}
		return left.val == right.val
				&& digui(left.left,right.right)
				&& digui(left.right,right.left);
	}
}
