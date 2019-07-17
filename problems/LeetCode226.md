---
title: LeetCode226-二叉树的翻转
date: 2019-07-13
categories: 算法小白的刷题之路
tags: LeetCode
---

## 题目
翻转一棵二叉树。

示例：

```
输入：

     4
   /   \
  2     7
 / \   / \
1   3 6   9

输出：

     4
   /   \
  7     2
 / \   / \
9   6 3   1
```


## 分析
### 递归
将根节点下面的左右子树互换，然后对于以后的任何非叶子节点，都继续左右子树互换即可

1. 反转二叉树的左右子树
2. 将左右子树交换

Time: O(n), Space: O(n)。。所有节点都要遍历一遍

### 迭代
```
     4
   /   \
  2     7
       / \
      6   9
```
可以考虑层次遍历 来翻转二叉树，核心就是将出队列的节点，它的左右子树对换一下
1. 首先4入队
2. 4出队，4的左右孩子交换一波 如下
```
     4
   /   \
  7     2
 / \     
6   9     
```
3. 将当前左右孩子不为null的再入队。7 2 入队，然后两次循环 7先出队
4. 7先出队 将7的左右孩子交换，之后，将它的左右孩子不为Null的入队
```
     4
   /   \
  7     2
 / \     
9   6     
```
5. 2的左右孩子都是null 交换也是这样的，将它的左右孩子不为Null的入队
6. 此时队列中只有 9 6。。。自己向下分析即可

Time: O(n), Space: O(n)。。所有节点都要遍历一遍

## 解答

````java
import org.junit.Test;
public class LeetCode226Test {

	// 递归
	public TreeNode invertTree(TreeNode root) {
		if(root == null){
			return null;
		}
		// 翻转二叉树的左右子树
		invertTree(root.left);
		invertTree(root.right);
		// 将左右子树对换
		TreeNode temp = root.left;
		root.left = root.right;
		root.right = temp;
		return root;
	}

	// 迭代
	public TreeNode invertTreeV2(TreeNode root) {
		if(root == null){
			return null;
		}
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);

		while (!queue.isEmpty()){
			int size = queue.size();
			for(int i=0; i<size; i++){
				TreeNode node = queue.poll();
				// 出队之后 交换这个节点的左右孩子
				TreeNode temp = node.left;
				node.left = node.right;
				node.right = temp;
				// 然后左右孩子非null的再入队列
				if(node.left != null){
					queue.add(node.left);
				}
				if(node.right != null){
					queue.add(node.right);
				}
			}
		}
		return root;
	}
}


````









