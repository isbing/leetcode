---
title: LeetCode107-二叉树的逆层序遍历
date: 2020-03-09
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
public class LeetCode107 {
    
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
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
        // 此时将result中的数据 前后对换一下 不就可以了么
        int length = result.size();
        for(int i=0; i<length/2; i++){
            List<Integer> temp = result.get(i);
            result.set(i,result.get(length-1-i));
            result.set(length-1-i,temp);
        }

        return result;
    }
}



````









