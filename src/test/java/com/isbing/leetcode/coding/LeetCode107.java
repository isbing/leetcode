package com.isbing.leetcode.coding;

import com.isbing.leetcode.bean.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by songbing
 * Created time 2020/3/10 上午12:02
 */
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
