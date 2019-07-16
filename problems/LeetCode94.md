---
title: LeetCode94-二叉树的中序遍历
date: 2019-07-12
categories: 算法小白的刷题之路
tags: LeetCode
---

## 题目
给定一个二叉树，返回它的中序 遍历。

示例:

```
输入: [1,null,2,3]
   1
    \
     2
    /
   3

输出: [1,3,2]
```

进阶: 递归算法很简单，你可以通过迭代算法完成吗？

## 分析
### 递归
中序遍历二叉树 递归的口诀就是 左-根-右

Time: O(n). Space: O(n)

### 迭代
从根节点开始 左子树不为空，就入栈。当遇到的左子树为null了，就出栈一个，打印

然后继续开始找左节点不为null的，入栈

```
           1
	  /   \
         2     3
	       \
	        4
	      /
	     5
```
1入栈 2入栈 2的左节点为空，2就出栈，打印。然后2的右子树为4.与之前的操作一样。左边的全入栈（4，5入栈）

Time: O(n). Space: O(n)

## 解答

````java
import org.junit.Test;
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


````









