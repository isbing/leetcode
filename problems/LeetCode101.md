---
title: LeetCode101-二叉树是否对称
date: 2019-06-02
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

模拟分析
```
	      1
	     / \
	    2   2
	   / \ / \
	  3  4 4  3
```
1. 2,2 先入栈。
2. 每次循环都出栈两个，2,2都有子节点，直接比较数值，不相等的话，就不是对称的
3. 相等的话，2的左孩子3进栈 另一个2的右孩子3进栈 2的右孩子4进栈 另一个2的左孩子4进栈
4. 这样顺序入栈的话，每次循环出两个，是两个4出来。两个4都没有子节点，这样将4个null入栈
5. 然后下次循环 是将两个3出栈。然后再将4个null入栈
6. 现在就有8个null了，都是null的时候 是continue，快速清掉null
7. 最后操作做完，就是 对称的二叉树

空间为O(n) 时间O(n) 把所有的节点 都走了一遍

### 递归

核心思路就是 左右节点都不为空的时候，左的左 要跟 右的右 比较，左的右 要跟 右的左 比较

空间为O(n) 时间O(n)

## 解答

````java
import org.junit.Test;
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
    	
}


````









