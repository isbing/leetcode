package com.isbing.leetcode.coding;

import com.isbing.leetcode.LeetCoding;
import com.isbing.leetcode.bean.TreeNode;

/**
 * Created by song bing
 * Created time 2019/6/11 14:13
 */
public abstract class LeetCode110 extends LeetCoding {

	// 递归
	// 对于根节点来说 他的左右子树高度差小于1.并且 他的左右子树 也是这样的情况。。那么就是 平衡的
	// 对于根节点，计算树的高度 要访问所有的节点。时间为O(N)
	// 对于子树节点，计算他们的高度 要访问一半的节点。两个子节点 加起来也是 O(N)
	// 同理都是0（N）。。层数是 log(N)...  // Time: O(nlog(n)), Space: O(n)
	// 就是因为每个节点在求它的子树高度的同时，节点都在重复访问。才导致 nlog(n)..

	/**
	 * 给定一个二叉树，判断它是否是高度平衡的二叉树。
	 * 本题中，一棵高度平衡二叉树定义为：
	 * 一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过1。
	 * 示例 1:
	 * 给定二叉树 [3,9,20,null,null,15,7]
	 *     3
	 *    / \
	 *   9  20
	 *     /  \
	 *    15   7
	 * 返回 true 。
	 * 示例 2:
	 * 给定二叉树 [1,2,2,3,3,null,null,4,4]
	 *        1
	 *       / \
	 *      2   2
	 *     / \
	 *    3   3
	 *   / \
	 *  4   4
	 * 返回 false 。
	 */
	@Override
	public boolean isBalanced(TreeNode root) {
		if(root == null){
			return true;
		}
		// 根节点的左右子树差，然后再看 左右孩子的情况
		return Math.abs(getHeight(root.left) - getHeight(root.right)) <= 1 &&
				isBalanced(root.left) && isBalanced(root.right);
	}

	// 需要一个函数 求二叉树的高度【自顶向下】
	public int getHeight(TreeNode treeNode){
		if(treeNode == null){
			return 0;
		}
		int left = getHeight(treeNode.left);
		int right = getHeight(treeNode.right);
		return Math.max(left,right) + 1;
	}

}
