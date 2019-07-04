package com.isbing.leetcode.coding;

import com.isbing.leetcode.bean.TreeNode;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Stack;

/**
 * Created by song bing
 * Created time 2019/6/27 17:34
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class LeetCode100Test {

	public boolean isSameTree(TreeNode p, TreeNode q) {
		if(p == null && q == null){
			return true;
		}
		if(p == null || q == null){ //只要一个为null
			return false;
		}
		return p.val == q.val && isSameTree(p.left,q.left) && isSameTree(p.right,q.right);
	}

	public boolean isSameTreeDieDai(TreeNode p, TreeNode q) {
		Stack<TreeNode> stack = new Stack<>();
		stack.push(p);
		stack.push(q);

		while (!stack.isEmpty()){
			TreeNode a = stack.pop();
			TreeNode b = stack.pop();
			if(a == null && b == null){
				continue;
			}
			if(a == null || b == null){
				// 有一个为null的情况 一定不是
				return false;
			}
			if(a.val != b.val){
				return false;
			}
			stack.push(a.left);
			stack.push(b.left);
			stack.push(a.right);
			stack.push(b.right);
		}
		return true;
	}
}
