package com.isbing.leetcode.coding;

import com.isbing.leetcode.LeetCoding;
import com.isbing.leetcode.bean.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by song bing
 * Created time 2019/6/10 14:49
 */
public abstract class LeetCode111 extends LeetCoding {

	// 思路一  递归
	// 当前节点为空，返回深度0.当前节点非空，根据当前节点左右子树是否非空，共有4种组合
	//  left right
	//  null null  说明当前节点是叶子节点。返回1
	//  null  val  说明当前只有右孩子  f(right)+1
	//  val  null  说明当前只有左孩子  f(left)+1
	//  val  val   说明左右孩子都有，min(f(left),f(right))+1
	//  时间空间都是O(N)


	// 思路二：迭代
	// 只要找到了 离根节点最近的那个叶子节点，就找到了最小深度。想到了层序遍历。
	// 层序遍历 访问到的 第一个叶子节点。就是离根节点最近的那个叶子节点。
	// 初始化最小深度为1，根节点入队。只有一个根节点，就出队。
	// 然后左右子树不为空的 入队。只要有入队的 就相当于深度+1。假设左右子树为空 就说明是叶子节点。返回深度
	// 时间空间 O(N)


	/**
	 * 给定一个二叉树，找出其最小深度。
	 * 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
	 * 说明: 叶子节点是指没有子节点的节点。
	 * 示例:
	 * 给定二叉树 [3,9,20,null,null,15,7],
	 *     3
	 *    / \
	 *   9  20
	 *     /  \
	 *    15   7
	 * 返回它的最小深度  2
	 *
	 *  *     3
	 * 	 *     \
	 * 	 *     20
	 * 	 *      \
	 * 	 *       7   这个的最小深度是 3.7是唯一的一个叶子节点
	 */
	@Override
	public int minDepth(TreeNode root) {
		return solution1(root);
		//return solution2(root);
	}

	// 不用递归
	private int solution2(TreeNode root) {
		if(root == null){
			return 0;
		}
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		int depth = 1;
		while (!queue.isEmpty()){
			int size = queue.size();
			for(int i=0; i<size; i++){
				TreeNode node = queue.poll();
				if(node.left == null && node.right == null){
					// 同时为空 说明当前是第一个 叶子节点
					return depth;
				}
				if(node.left != null){
					queue.add(node.left);
				}
				if(node.right != null){
					queue.add(node.right);
				}
			}
			// 一层搞完了 深度+1
			depth++;
		}
		return 0;
	}

	// 递归
	private int solution1(TreeNode root) {
		if(root == null){
			return 0;
		}
		if(root.left == null && root.right == null){
			// 叶子节点
			return 1;
		} else if(root.left == null && root.right != null){
			return solution1(root.right)+1;
		} else if(root.left != null && root.right == null){
			return solution1(root.left)+1;
		} else if(root.left != null && root.right != null){
			return Math.min(solution1((root.left)),solution1(root.right))+1;
		}
		return -1;
	}
}
