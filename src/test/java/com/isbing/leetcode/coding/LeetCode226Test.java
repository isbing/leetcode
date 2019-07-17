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
public class LeetCode226Test {

	// 递归
	public TreeNode invertTree(TreeNode root) {
		if(root == null){
			return null;
		}
		// 翻转二叉树的左右子树
		invertTree(root.left);
		invertTree(root.right);
		// 将左右子树对换
		TreeNode temp = root.left;
		root.left = root.right;
		root.right = temp;
		return root;
	}

	// 迭代
	public TreeNode invertTreeV2(TreeNode root) {
		if(root == null){
			return null;
		}
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);

		while (!queue.isEmpty()){
			int size = queue.size();
			for(int i=0; i<size; i++){
				TreeNode node = queue.poll();
				// 出队之后 交换这个节点的左右孩子
				TreeNode temp = node.left;
				node.left = node.right;
				node.right = temp;
				// 然后左右孩子非null的再入队列
				if(node.left != null){
					queue.add(node.left);
				}
				if(node.right != null){
					queue.add(node.right);
				}
			}
		}
		return root;
	}
}
