package com.isbing.leetcode.coding;

import com.isbing.leetcode.LeetCoding;
import com.isbing.leetcode.bean.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by song bing
 * Created time 2019/6/10 14:22
 */
public abstract class LeetCode107 extends LeetCoding {

	// 空间时间 都是O（N）

	/**
	 * 这个题目说的是，给你一棵二叉树，要求你从叶子节点到根节点一层一层地对其进行访问，
	 * 对于每一层的节点，则是从左向右进行访问。将访问的结果以二维数组返回。
	 * 这道题目和二叉树层序遍历的唯一区别是，它是从下向上一层一层去访问的。
	 * 比如说，给你的二叉树是：
	 *      1
	 *    /   \
	 *   2     4
	 *        / \
	 *       8  16
	 *
	 * 它的逆层序遍历结果是：
	 * [
	 *  [8, 16]，
	 *  [2, 4],
	 *  [1],
	 * ]
	 */
	@Override
	public List<List<Integer>> levelOrderBottom(TreeNode root) {
		// 思路：层序遍历这个二叉树，然后将得到的集合 前后两两对换。得到它逆序的排序
		List<List<Integer>> result = new ArrayList<>();
		if(root == null){
			return result;
		}

		Queue<TreeNode> queue = new LinkedList<>();
		// 根节点入队，前面已经判断了 根节点不会为空
		queue.add(root);
		// 队列不为空 判断当前有多少数据
		while (!queue.isEmpty()){
			int size = queue.size();
			List<Integer> temp = new ArrayList<>();
			for(int i=0; i<size; i++){
				TreeNode node = queue.poll();
				temp.add(node.val);
				// 左右不能为空
				if(node.left != null){
					queue.add(node.left);
				}
				if(node.right != null){
					queue.add(node.right);
				}
			}
			result.add(temp);
		}
		// 翻转集合
		// [  [1],[2,4],[8,6]   ]
		for(int i=0; i<result.size()/2; i++){
			List<Integer> first = result.get(i);
			List<Integer> last = result.get(result.size()-1-i);
			List<Integer> temp = first;
			result.set(i,last);
			result.set(result.size()-1-i,temp);
		}
		return result;
	}
}
