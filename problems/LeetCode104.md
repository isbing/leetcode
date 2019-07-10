---
title: LeetCode104-二叉树的最大深度
date: 2019-07-09
categories: 算法小白的刷题之路
tags: LeetCode
---

## 题目
给定一个二叉树，找出其最大深度。

二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。

说明: 叶子节点是指没有子节点的节点。

示例：

给定二叉树 [3,9,20,null,null,15,7]，

```
    3
   / \
  9  20
      \
       7
```
返回它的最大深度 3 
## 分析
### 递归
递归 空节点 return 0，不是的话 返回左右字数的最大+1

Time: O(n), Space: O(n)

### 迭代(层次遍历)
采用层次遍历的思路，每进入到下一层，树的深度就可以+1

```
    3
   / \
  9  20
      \
       7
```
1. 初始化树的深度为0，根节点3入队。此时队列的长度为1
2. 队列不为空，又因为长度为1，就出队一次3，将3的左右不为空的子树入队，深度+1
3. 队列不为空，又因为长度为2，9，20依次出队，只有20的7入队，深度+1
4. 队列不为空，又因为长度为1，7出队之后，发现7的左右子树都为空，深度不变
5. 队列为空，结束循环

Time: O(n), Space: O(n)

## 解答

````java
import org.junit.Test;
public class LeetCode104Test {

	// 迭代
	public int maxDepthV2(TreeNode root) {
		if(root == null) return 0;
		// 构造一个队列 用于层次遍历
		Queue<TreeNode> queue = new LinkedList<>();
		// 根节点入队
		queue.add(root);
		int depth = 0;
		while (!queue.isEmpty()){
			// 得到当前队列的大小
			int size = queue.size();
			for(int i=0; i<size; i++){
				TreeNode node = queue.poll();
				if(node.left != null){
					queue.add(node.left);
				}
				if(node.right != null){
					queue.add(node.right);
				}
			}
			depth++;
		}
		return depth;
	}


	// 递归
	public int maxDepth(TreeNode root) {
		if(root == null) return 0;
		return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
	}
}


````









