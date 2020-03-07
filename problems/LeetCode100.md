---
title: LeetCode100-相同二叉树
date: 2020-03-07
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

## 总结
1. 两个树是否相同，抛开递归终止条件，就是节点值要相等并且两个树的左子树相等并且两个树的右子树也相等
2. 如果用迭代的方式，使用一个栈，不过入栈的顺序为p左q左p右q右

## 解答

````java
import org.junit.Test;
public class LeetCode100 {

    // 递归 比较根节点，根节点相等还得比较左右子树
    public boolean isSameTree_1(TreeNode p, TreeNode q) {
        return isSameTree_1_di(p,q);
    }

    private boolean isSameTree_1_di(TreeNode p, TreeNode q) {
        if(p == null && q == null) return true;
        else if(p == null || q == null) return false;
        return p.val == q.val && isSameTree_1_di(p.left,q.left) && isSameTree_1_di(p.right,q.right);
    }

    // 用迭代的方式 使用栈
    public boolean isSameTree_2(TreeNode p, TreeNode q) {
        Stack<TreeNode> stack = new Stack<>();
        // 首先将两个树的根节点入栈
        stack.push(p);
        stack.push(q);
        while (!stack.isEmpty()){
            // 一次性弹出两个栈顶元素
            TreeNode node1 = stack.pop();
            TreeNode node2 = stack.pop();
            if(node1 == null && node2 == null) continue;
            if(node1 == null || node2 == null) return false;
            if(node1.val != node2.val) return false;
            stack.push(node1.left);
            stack.push(node2.left);
            stack.push(node1.right);
            stack.push(node2.right);
        }
        return true;
    }
}



````









