package com.isbing.leetcode.coding;

import com.isbing.leetcode.LeetCoding;
import com.isbing.leetcode.bean.TreeNode;

import java.util.Stack;

/**
 * Created by song bing
 * Created time 2019/5/16 13:01
 */
public abstract class LeetCode100 extends LeetCoding {

	// 比较二叉树 相同  与 二叉树的对称 有异曲同工之妙
	// 两种解决办法都是 Time: O(n), Space: O(n)

	/**
	 * 给定两个二叉树，编写一个函数来检验它们是否相同。
	 * 如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。
	 * 示例 1:
	 * 输入:       1         1
	 *           / \       / \
	 *          2   3     2   3
	 *         [1,2,3],   [1,2,3]
	 * 输出: true
	 * 示例 2:
	 * 输入:      1          1
	 *           /           \
	 *          2             2
	 *         [1,2],      [1,null,2]
	 * 输出: false
	 * 示例 3:
	 * 输入:       1         1
	 *           / \       / \
	 *          2   1     1   2
	 *         [1,2,1],   [1,1,2]
	 * 输出: false
	 */
	@Override
	public boolean isSameTree(TreeNode p, TreeNode q) {
		return solution1(p,q);
		//return solution2(p,q);
	}

	public boolean solution1(TreeNode p, TreeNode q){
		Stack<TreeNode> stack = new Stack<>();
		stack.push(p);
		stack.push(q);
		while (!stack.empty()){
			TreeNode left = stack.pop();
			TreeNode right = stack.pop();
			if(left == null && right == null) continue;
			if(left == null || right == null) return false;
			if(left.val != right.val) return false;
			stack.push(left.left);
			stack.push(right.left);
			stack.push(left.right);
			stack.push(right.right);
		}
		return true;
	}

	public boolean solution2(TreeNode p, TreeNode q){
		if(p == null && q == null) return true;
		if(p == null || q == null) return false;
		return p.val == q.val && solution2(p.left,q.left) && solution2(p.right,q.right);
	}
}
