package com.isbing.leetcode.coding;

import com.isbing.leetcode.LeetCoding;
import com.isbing.leetcode.bean.TreeNode;

/**
 * Created by song bing
 * Created time 2019/5/14 19:05
 */
public abstract class LeetCode101 extends LeetCoding {

	/**
	 * 给定一个二叉树，检查它是否是镜像对称的。
	 * 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
	 *     1
	 *    / \
	 *   2   2
	 *  / \ / \
	 * 3  4 4  3
	 * 但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:
	 *     1
	 *    / \
	 *   2   2
	 *    \   \
	 *    3    3
	 */
	@Override
	public boolean isSymmetric(TreeNode root) {


		return false;
	}
}
