---
title: LeetCode111-二叉树的最小深度
date: 2020-03-10
categories: 算法小白的刷题之路
tags: LeetCode
---

## 题目
给定一个二叉树，找出其最小深度。

最小深度是从根节点到最近叶子节点的最短路径上的节点数量。

说明: 叶子节点是指没有子节点的节点。

示例:

给定二叉树 [3,9,20,null,null,15,7],

```
    3
   / \
  9  20
    /  \
   15   7
```

返回它的最小深度  2.

## 分析
### 迭代
前面我们做过二叉树的最大深度，那里的迭代 是遍历到树的最下面一层为止

分析最小的深度，不就是某一个节点 第一次出现左右子树都为null的这种么.与就是找到第一个叶子节点

1. 初始深度为1（要与最大深度做比较）
2. 3入队，队列大小为1
3. 大小为1，就出队一次，将3出队，发现3的左右子树为9，20 都入队，队列大小为2 深度为2
4. 队列大小为2，就会出队两次，将9出队后，发现9是叶子节点。即可终止遍历了。此时深度为2

时间O(N) 空间O(N)

### 递归
当前节点为空，返回深度0.当前节点非空，根据当前节点左右子树是否非空，共有4种组合

left right

null null  说明当前节点是叶子节点。返回1

null  val  说明当前只有右孩子  f(right)+1

val  null  说明当前只有左孩子  f(left)+1

val  val   说明左右孩子都有，min(f(left),f(right))+1

时间空间都是O(N)

## 总结
1. 还是用迭代的思路吧，使用队列，只要发现叶子节点，最小深度值就出来了，这个思路不比递归香吗？清爽的不得鸟

## 解答

````java
import org.junit.Test;
public class LeetCode111 {

	// 二叉树的最小深度，我就不用递归实现了 就用迭代实现
	// 递归我真是难以理解...
	public int minDepth(TreeNode root) {
		// 最小深度 用队列，只要出队的元素中出现叶子节点就可以返回了
		if(root == null) return 0;
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		int minDepth = 0;
		while (!queue.isEmpty()){
			// 每进入一层，深度就++
			minDepth++;
			int size = queue.size();
			for(int i=0; i<size; i++){
				TreeNode node = queue.poll();
				if(node.left == null && node.right == null) return minDepth;
				if(node.left != null) queue.add(node.left);
				if(node.right != null) queue.add(node.right);
			}
		}
		return 0;
	}

}

````









