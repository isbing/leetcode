---
title: LeetCode101-二叉树是否对称
date: 2020-03-06
categories: 算法小白的刷题之路
tags: LeetCode
---

## 题目
给定一个二叉树，检查它是否是镜像对称的。

例如，二叉树 [1,2,2,3,4,4,3] 是对称的。

```
	      1
	     / \
	    2   2
	   / \ / \
	  3  4 4  3
```
 但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:
 ```
	      1
	     / \
	    2    2
	     \    \
	      3    3
```

## 分析
### 迭代
迭代 要么借助栈 要么借助队列。随便画一棵树，发现用队列的话 是不合适的

使用栈的话，栈的入栈顺序很重要

模拟分析
```
	      1
	     / \
	    2   2
	   / \ / \
	  3  4 4  3
```
1. 2,2 先入栈。
2. 每轮循环都出栈两个，2,2都有子节点，直接比较数值，不相等的话，就不是对称的
3. 相等的话，2的左孩子3进栈 另一个2的右孩子3进栈 2的右孩子4进栈 另一个2的左孩子4进栈
4. 这样顺序入栈的话，每次循环出两个，是两个4出来。两个4都没有子节点，这样将4个null入栈
5. 然后下次循环 是将两个3出栈。然后再将4个null入栈
6. 现在就有8个null了，都是null的时候 是continue，快速清掉null
7. 最后操作做完，就是 对称的二叉树

空间为O(n) 时间O(n) 把所有的节点 都走了一遍

### 递归

核心思路就是 左右节点都不为空的时候，左的左 要跟 右的右 比较，左的右 要跟 右的左 比较

空间为O(n) 时间O(n)

## 总结
1. 递归就得把握整体，因为根节点不用关注，核心就是比较左子树和右子树了
2. 对于左子树和右子树来说，只要有一个为null肯定就不是了，都不为Null，得比较左的左与右的右 以及 左的右与右的左
3. 一般递归能实现的，迭代也能实现。用栈来做，根节点的左右子树入栈，然后每次循环出栈两个比较

## 解答

````java
import org.junit.Test;
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

````









