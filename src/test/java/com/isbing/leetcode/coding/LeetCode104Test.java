package com.isbing.leetcode.coding;

import com.isbing.leetcode.bean.TreeNode;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.*;

/**
 * Created by song bing
 * Created time 2019/6/27 17:34
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class LeetCode104Test {

	// 迭代
	public int maxDepthV2(TreeNode root) {
		if(root == null) return 0;
		// 构造一个队列 用于层次遍历
		Queue<TreeNode> queue = new LinkedList<>();
		// 根节点入队
		queue.add(root);
		int depth = 0;
		while (!queue.isEmpty()){
			// 得到当前队列的大小
			int size = queue.size();
			for(int i=0; i<size; i++){
				TreeNode node = queue.poll();
				if(node.left != null){
					queue.add(node.left);
				}
				if(node.right != null){
					queue.add(node.right);
				}
			}
			depth++;
		}
		return depth;
	}


	// 递归
	public int maxDepth(TreeNode root) {
		if(root == null) return 0;
		return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
	}
}
