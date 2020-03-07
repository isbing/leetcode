package com.isbing.leetcode.coding;

import com.isbing.leetcode.bean.TreeNode;
import org.junit.Test;

import java.util.Stack;

/**
 * Created by songbing
 * Created time 2020/3/7 下午11:04
 */
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
