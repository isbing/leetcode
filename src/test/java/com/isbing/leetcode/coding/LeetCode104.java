package com.isbing.leetcode.coding;

import com.isbing.leetcode.bean.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by song bing
 * Created time 2020/3/10 11:23
 */
public class LeetCode104 {

	// 用递归做，递归 空节点 return 0，不是的话 返回左右子数的最大+1
	public int maxDepth_1(TreeNode root) {
		return maxDepth_1_di(root);
	}

	private int maxDepth_1_di(TreeNode root) {
		if(root == null) return 0;
		return Math.max(maxDepth_1_di(root.left),maxDepth_1_di(root.right)) + 1;
	}

	// 用迭代做，使用队列，层次遍历，每进入一层，深度就+1
	public int maxDepth_2(TreeNode root) {
		if(root == null) return 0;
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		int depth = 0;
		while (!queue.isEmpty()){
			// 进入一层，depth就++
			depth++;
			int size = queue.size();
			for(int i=0; i<size; i++){
				TreeNode node = queue.poll();
				if(node.left != null) queue.add(node.left);
				if(node.right != null) queue.add(node.right);
			}
		}
		return depth;
	}
}