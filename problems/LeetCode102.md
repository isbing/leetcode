---
title: LeetCode102-二叉树的层序遍历
date: 2020-03-09
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
public class LeetCode102 {

    // 二叉树的层序遍历 队列就完事了 时间空间都是o(n)
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null) return result;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            // 获取此时队列中的元素数量
            int size = queue.size();
            List<Integer> list = new ArrayList<>();
            for(int i=0; i<size; i++){
                // 出队
                TreeNode node = queue.poll();
                list.add(node.val);
                // 左不为空 左入队 右不为空 右入队
                if(node.left != null) queue.add(node.left);
                if(node.right != null) queue.add(node.right);
            }
            result.add(list);
        }
        return result;
    }

}


````









