package com.isbing.leetcode.coding;

import com.isbing.leetcode.LeetCoding;
import com.isbing.leetcode.bean.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by songbing
 * Created time 2019/5/19 上午10:00
 */
public abstract class LeetCode104 extends LeetCoding{

    // 思路一：递归 空节点 return 0，不是的话 返回左右字数的最大+1
    // Time: O(n), Space: O(n)


    // 思路二：采用迭代的方法。
    // Time: O(n), Space: O(n)
    // 初始化树的深度为0，根节点3入队。同时记录入队的个数为1.
    // 个数为1 就出队一个。将3 的不为空的左右子树入队。记录数字为2.同时树的深度变为1
    // 个数为2(队列的长度) 出队两次 9 10出队。然后将 8 10的非空子树再入队。。

    /**
     * 给定一个二叉树，找出其最大深度。
     二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
     说明: 叶子节点是指没有子节点的节点。
     示例：
     给定二叉树 [3,9,20,null,null,15,7]，
     3
     / \
     9  20
     /  \
     15   7
     返回它的最大深度 3 。
     */
    @Override
    public int maxDepth(TreeNode root) {
        return solution2(root);
    }

    // 迭代
    private int solution2(TreeNode root) {
        if(root == null) return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int depth = 0;
        while (!queue.isEmpty()){
            int size = queue.size();
            for(int i=0; i<size; i++){
                TreeNode node = queue.poll();
                if(node.left != null)
                    queue.add(node.left);
                if(node.right != null)
                    queue.add(node.right);
            }
            // 进一次循环 就++
            depth++;
        }

        return depth;
    }

    // 递归
    private int solution1(TreeNode root) {
        if(root == null)
            return 0;
        return Math.max(solution1(root.left),solution1(root.right))+1;
    }
}
