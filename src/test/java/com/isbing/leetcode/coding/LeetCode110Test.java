package com.isbing.leetcode.coding;

import com.isbing.leetcode.bean.TreeNode;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by song bing
 * Created time 2019/6/27 17:34
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class LeetCode110Test {

	// 递归 每个节点算高度 O(N) 层数O(logN)
	public boolean isBalanced(TreeNode root) {
		if(root == null) return true;
		// 根节点的左右子树差，然后再看 左右孩子的情况
		return Math.abs(getHeight(root.left) - getHeight(root.right)) <= 1
				&& isBalanced(root.left) && isBalanced(root.right);
	}

	public int getHeight(TreeNode treeNode){
		if(treeNode == null) return 0;
		return Math.max(getHeight(treeNode.left),getHeight(treeNode.right))+1;
	}
}
