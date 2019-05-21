package com.isbing.leetcode.coding;

import com.isbing.leetcode.LeetCoding;
import com.isbing.leetcode.bean.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by song bing
 * Created time 2019/5/21 15:57
 */
public abstract class LeetCode102 extends LeetCoding {

	// 层序遍历：采用队列
	// Time: O(n), Space: O(n)
	// 将根节点入队列，队列不为空，取出当前队列的元素个数。确保只访问当前层级的节点。
	// 并将左右子树不为空的入队列

	/**
	 * 给定一个二叉树，返回其按层次遍历的节点值。 （即逐层地，从左到右访问所有节点）。
	 * 例如:
	 * 给定二叉树: [3,9,20,null,null,15,7],
	 *     3
	 *    / \
	 *   9  20
	 *     /  \
	 *    15   7
	 * 返回其层次遍历结果：
	 *
	 * [
	 *   [3],
	 *   [9,20],
	 *   [15,7]
	 * ]
	 */
	@Override
	public List<List<Integer>> levelOrder(TreeNode root) {
		List<List<Integer>> result = new ArrayList<>();
		if(root == null) {
			return result;
		}
		Queue<TreeNode> queue = new LinkedList<>();
		// 根节点入队
		queue.add(root);
		while (!queue.isEmpty()){
			// 队列不为空 取出当前队列中的元素
			int size = queue.size();
			List<Integer> list = new ArrayList<>();
			for(int i=0; i<size; i++){
				TreeNode node = queue.poll();
				list.add(node.val);
				if(node.left != null)
					queue.add(node.left);
				if(node.right != null)
					queue.add(node.right);
			}
			result.add(list);
		}
		return result;
	}
}
