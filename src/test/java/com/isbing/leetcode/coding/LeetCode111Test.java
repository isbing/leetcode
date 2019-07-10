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
public class LeetCode111Test {

	// 迭代
	public int minDepthV2(TreeNode root) {
		if(root == null) return 0;
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		// 初始化深度为1
		int depth = 1;
		while (!queue.isEmpty()){
			int size = queue.size();
			for(int i=0; i<size; i++){
				TreeNode node = queue.poll();
				// 只要是叶子节点 直接返回深度
				if(node.left == null && node.right == null){
					return depth;
				}
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
	public int minDepth(TreeNode root) {
		if(root == null){
			return 0;
		}
		if(root.left == null && root.right == null){
			return 1;
		}
		// 左孩子为空
		if(root.left == null){
			return minDepth(root.right)+1;
		}
		if(root.right == null){
			return minDepth(root.left)+1;
		}
		return Math.min(minDepth(root.left),minDepth(root.right))+1;
	}
}
