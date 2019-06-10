package com.isbing.leetcode.coding;

import com.isbing.leetcode.LeetCoding;
import com.isbing.leetcode.bean.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by song bing
 * Created time 2019/6/10 16:36
 */
public abstract class LeetCode94 extends LeetCoding {

	// 思路一：递归很简单【左-根-右】 Time: O(n). Space: O(n)


	// 思路二：迭代  左-根-右
	// 一直去找左，直到左子树为空。树的左节点不为空的时候，不断入栈
	// 1入栈 2入栈 2的左节点为空，2就出栈，打印。然后2的右子树为4.与之前的操作一样。左边的全入栈（4，5入栈）
	// Time: O(n). Space: O(n)

	/**
	 * 这个题目说的是，给你一个二叉树，你要返回一个数组，表示二叉树中序遍历的结果。
	 * 比如说，给你的二叉树是：
	 *      1
	 *    /   \
	 *   2     3
	 *    \
	 *     4
	 *    /
	 *   5
	 *
	 * 你要返回的中序遍历结果是：2, 5, 4, 1, 3
	 */
	@Override
	public List<Integer> inorderTraversal(TreeNode root) {
		//return solution1(root);
		return solution2(root);
	}

	// 迭代
	private List<Integer> solution2(TreeNode root) {
		Stack<TreeNode> stack = new Stack<>();
		List<Integer> result = new ArrayList<>();

		while (root != null || !stack.isEmpty()){
			while (root != null){
				stack.push(root);
				root = root.left;
			}
			TreeNode node = stack.pop();
			result.add(node.val);
			root = node.right;
		}
		return result;
	}

	// 递归
	private List<Integer> solution1(TreeNode root) {
		List<Integer> result = new ArrayList<>();
		dieDai(root,result);
		return result;
	}

	private void dieDai(TreeNode root, List<Integer> result) {
		if(root == null){
			return;
		}
		dieDai(root.left,result);//左
		result.add(root.val);//根
		dieDai(root.right,result);//右
	}
}
