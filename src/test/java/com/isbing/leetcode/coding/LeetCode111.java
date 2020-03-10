package com.isbing.leetcode.coding;

import com.isbing.leetcode.bean.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by song bing
 * Created time 2020/3/10 14:29
 */
public class LeetCode111 {

	// 二叉树的最小深度，我就不用递归实现了 就用迭代实现
	// 递归我真是难以理解...
	public int minDepth(TreeNode root) {
		// 最小深度 用队列，只要出队的元素中出现叶子节点就可以返回了
		if(root == null) return 0;
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		int minDepth = 0;
		while (!queue.isEmpty()){
			// 每进入一层，深度就++
			minDepth++;
			int size = queue.size();
			for(int i=0; i<size; i++){
				TreeNode node = queue.poll();
				if(node.left == null && node.right == null) return minDepth;
				if(node.left != null) queue.add(node.left);
				if(node.right != null) queue.add(node.right);
			}
		}
		return 0;
	}

}
