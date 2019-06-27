package com.isbing.leetcode;

import com.isbing.leetcode.bean.ListNode;
import com.isbing.leetcode.bean.TreeNode;

import java.util.List;

/**
 * Created by song bing
 * Created time 2019/5/14 17:26
 */
public abstract class LeetCoding {
	public abstract boolean isPalindrome(String s);//125
	public abstract int[] twoSum(int[] nums, int target);//1
	public abstract int[] twoSumV2(int[] numbers, int target);//167

	public abstract boolean isSymmetric(TreeNode root);//101
	public abstract int singleNumber(int[] nums);//136  单身数字
	public abstract boolean searchMatrix(int[][] matrix, int target);//240 矩阵中找数
	public abstract boolean isSameTree(TreeNode p, TreeNode q);//100 相同二叉树
	public abstract ListNode reverseList(ListNode head);//206 反转链表
	public abstract List<List<Integer>> permute(int[] nums);//46 不相同数字全排列 代码中包含去重操作
	public abstract boolean isPalindrome(int x);//9 回文数
	public abstract boolean isPalindrome(ListNode head);//234 回文链表
	public abstract void merge(int[] nums1, int m, int[] nums2, int n);//88合并两个有序数组
	public abstract int maxSubArray(int[] nums);//53 最大连续子序和
	public abstract ListNode mergeTwoLists(ListNode l1, ListNode l2);//21 合并两个有序链表
	public abstract boolean hasCycle(ListNode head);//141 判断是否有环
	public abstract int maxDepth(TreeNode root);//104 二叉树的最大深度
	public abstract int majorityElement(int[] nums);//169 求众数 数组中出现次数大于 ⌊ n/2 ⌋ 的元素。
	public abstract List<List<Integer>> levelOrder(TreeNode root);//102 二叉树的层序遍历
	public abstract List<List<Integer>> levelOrderBottom(TreeNode root);//107 二叉树的逆层序遍历
	public abstract int minDepth(TreeNode root);//111 二叉树的最小深度
	public abstract List<Integer> inorderTraversal(TreeNode root);//94 二叉树的中序遍历
	public abstract boolean isBalanced(TreeNode root);//110 二叉树是否平衡
	public abstract boolean isUgly(int num);//263 丑数



}
