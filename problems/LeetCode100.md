---
title: LeetCode100-相同二叉树
date: 2019-07-04
categories: 算法小白的刷题之路
tags: LeetCode
---

## 题目
给定两个二叉树，编写一个函数来检验它们是否相同。

如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。

```
输入:       1         1
          / \       / \
         2   3     2   3

        [1,2,3],   [1,2,3]

输出: true
示例 2:

输入:      1          1
          /           \
         2             2

        [1,2],     [1,null,2]

输出: false
示例 3:

输入:       1         1
          / \       / \
         2   1     1   2

        [1,2,1],   [1,1,2]

输出: false
```

## 分析
二叉树的是否相同 与 二叉树是否对称 有异曲同工之妙.

只不过对称是 一棵二叉树，相同是 两棵二叉树。

二叉树相同：根节点相同，p的左 要与 q的左 相等，p的右 要与 q的右 相等

二叉树对称：根节点相同，左的左 要与 右的右 相等，左的右 要与 右的左 相等

迭代的话，都是使用栈，保存数据的思路也稍微变了下

递归迭代 Time: O(n), Space: O(n)

## 解答

````java
import org.junit.Test;
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


````









