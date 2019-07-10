package com.isbing.leetcode.coding;

import com.isbing.leetcode.bean.TreeNode;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.*;

/**
 * Created by song bing
 * Created time 2019/6/27 17:34
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class LeetCode102Test {

	public List<List<Integer>> levelOrder(TreeNode root) {
		List<List<Integer>> result = new ArrayList<>();
		if(root == null){
			return result;
		}
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);

		while (!queue.isEmpty()){
			int size = queue.size();
			List<Integer> temp = new ArrayList<>();
			for(int i=0; i<size; i++){
				TreeNode node = queue.poll();
				// 出队列的加入到集合
				temp.add(node.val);
				if(node.left != null){
					queue.add(node.left);
				}
				if(node.right != null){
					queue.add(node.right);
				}
			}
			result.add(temp);
		}
		return result;
	}
}
