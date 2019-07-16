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
public class LeetCode94Test {

	// 递归
	public List<Integer> inorderTraversal(TreeNode root) {
		List<Integer> result = new ArrayList<>();
		diGui(result,root);
		return result;
	}

	// 迭代
	public List<Integer> inorderTraversalV2(TreeNode root) {
		List<Integer> result = new ArrayList<>();
		if(root == null) return result;
		Stack<TreeNode> stack = new Stack<>();
		while (root != null || !stack.isEmpty()){
			while (root != null){
				stack.push(root);
				root = root.left;
			}
			// 到这里的时候 就说明左子树为Null了
			TreeNode node = stack.pop();
			result.add(node.val);
			// 换到右节点
			root = node.right;
		}

		return result;
	}

	private void diGui(List<Integer> result, TreeNode root) {
		if(root == null){
			return;
		}
		// 左-根-右
		diGui(result,root.left);
		result.add(root.val);
		diGui(result,root.right);
	}
}
