---
title: LeetCode107-二叉树的逆序遍历
date: 2019-07-10
categories: 算法小白的刷题之路
tags: LeetCode
---

## 题目
给定一个二叉树，返回其节点值自底向上的层次遍历。（即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）

例如：

给定二叉树 [3,9,20,null,null,15,7],

```

    3
   / \
  9  20
    /  \
   15   7
   
返回其自底向上的层次遍历为：

[
  [15,7],
  [9,20],
  [3]
]
```

## 分析

分析 二叉树的层序遍历 应该是 3，9 20，15 7

此时打印的结果为    15 7，9 20，3       

可以发现 不就是 层次遍历后得到的list 然后自己对折交换了一下么

空间时间 都是O（N）

## 解答

````java
import org.junit.Test;
public class LeetCode107Test {

	public List<List<Integer>> levelOrder(TreeNode root) {
		List<List<Integer>> result = new ArrayList<>();
		if(root == null){
			return result;
		}
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);

		while (!queue.isEmpty()){
			int size = queue.size();
			List<Integer> temp = new ArrayList<>();
			for(int i=0; i<size; i++){
				TreeNode node = queue.poll();
				// 出队列的加入到集合
				temp.add(node.val);
				if(node.left != null){
					queue.add(node.left);
				}
				if(node.right != null){
					queue.add(node.right);
				}
			}
			result.add(temp);
		}
		// 再层次遍历的基础上，将这个list进行反转
		// 反转的意思就是 a[i] swap a[length-i-1]
		for(int i=0; i<result.size()/2; i++){
			List<Integer> head = result.get(i);
			List<Integer> tail = result.get(result.size() - 1 - i);
			// 交换
			result.set(i,tail);
			result.set(result.size() - 1 - i,head);
		}
		return result;
	}
}


````









