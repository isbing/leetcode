package com.isbing.leetcode.coding;

import com.isbing.leetcode.bean.TreeNode;
import org.junit.Test;

import java.util.*;

/**
 * Created by song bing
 * Created time 2020/3/6 13:45
 */
public class LeetCode101 {

	// 迭代法 用栈
	public boolean isSymmetric_1(TreeNode root) {
		if(root == null) return true;
		Stack<TreeNode> stack = new Stack<>();
		stack.push(root.left);
		stack.push(root.right);

		while (!stack.isEmpty()){
			TreeNode node1 = stack.pop();
			TreeNode node2 = stack.pop();
			if(node1 == null && node2 == null) continue;
			if(node1 == null || node2 == null) return false;
			if(node1.val != node2.val) return false;
			stack.push(node1.left);
			stack.push(node2.right);
			stack.push(node1.right);
			stack.push(node2.left);
		}
		return true;
	}

	public boolean isSymmetric_2(TreeNode root) {
		if(root == null) return true;
		return isSymmetricTreeRecursive(root.left,root.right);
	}

	private boolean isSymmetricTreeRecursive(TreeNode s, TreeNode t) {
		if(s == null && t == null) return true;
		if(s == null || t == null) return false;
		return s.val == t.val && isSymmetricTreeRecursive(s.left,t.right) && isSymmetricTreeRecursive(s.right,t.left);
	}

}
