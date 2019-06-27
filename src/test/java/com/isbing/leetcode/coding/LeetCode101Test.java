package com.isbing.leetcode.coding;

import com.isbing.leetcode.bean.TreeNode;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Created by song bing
 * Created time 2019/6/27 17:34
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class LeetCode101Test {

	@Test
	public void test(){

	}

	public boolean isSymmetric(TreeNode root) {
		if(root == null){
			return true;
		}
		return diGui(root.left,root.right);
	}

	private boolean diGui(TreeNode left, TreeNode right) {
		if(left == null && right == null){
			return true;
		}
		if((left == null && right != null) || (left != null && right == null)){
			return false;
		}
		// 递归需要比较的是  左的左 要跟 右的右 比较，左的右 要跟 右的左 比较
		return left.val == right.val && diGui(left.left,right.right) && diGui(left.right,right.left);
	}

	public boolean isSymmetricDie(TreeNode root) {
		if(root == null){
			return true;
		}
		Stack<TreeNode> stack = new Stack<>();
		// 将根节点的左右节点入栈
		stack.push(root.left);
		stack.push(root.right);

		while (!stack.isEmpty()){
			// 一次循环 是出栈两个
			TreeNode a = stack.pop();
			TreeNode b = stack.pop();
			// a      b   两个节点a,b 4种情况
			// null   null
			// null    not
			// not    null
			// not     not
			if(a == null && b == null){
				continue;
			}
			// 一个null 一个不为null 肯定不对称
			if((a == null && b != null) || (a != null && b == null)){
				return false;
			}
			// 这种情况下 都不是null
			if(a.val != b.val){
				return false;
			}
			stack.push(a.left);
			stack.push(b.right);
			stack.push(a.right);
			stack.push(b.left);
		}
		return true;
	}
}
