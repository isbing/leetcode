---
title: LeetCode102-二叉树的层序遍历
date: 2019-07-10
categories: 算法小白的刷题之路
tags: LeetCode
---

## 题目
给定一个二叉树，返回其按层次遍历的节点值。（即逐层地，从左到右访问所有节点）。

例如:

给定二叉树: [3,9,20,null,null,15,7],

 ```
    3
   / \
  9  20
    /  \
   15   7
   
返回其层次遍历结果：

[
  [3],
  [9,20],
  [15,7]
]
```

## 分析

二叉树的层次遍历 没啥好分析的

就是循环里面 每次出队列的次数 由当前队列的大小控制

Time: O(n), Space: O(n)

## 解答

````java
import org.junit.Test;
public class LeetCode102Test {

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
		return result;
	}
}


````









