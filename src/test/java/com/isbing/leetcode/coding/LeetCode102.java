package com.isbing.leetcode.coding;

import com.isbing.leetcode.bean.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by songbing
 * Created time 2020/3/9 下午11:52
 */
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
