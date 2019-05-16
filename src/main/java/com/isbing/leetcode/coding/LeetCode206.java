package com.isbing.leetcode.coding;

import com.isbing.leetcode.LeetCoding;
import com.isbing.leetcode.bean.ListNode;


/**
 * Created by song bing
 * Created time 2019/5/16 13:25
 */
public abstract class LeetCode206 extends LeetCoding {

	// 单链表的反转 可以采用 当前节点 前驱节点
	// Time: O(n), Space: O(1)

	/**
	 * 反转一个单链表。
	 * 示例:
	 * 输入: 1->2->3->4->5->NULL
	 * 输出: 5->4->3->2->1->NULL
	 * 进阶:
	 * 你可以迭代或递归地反转链表。你能否用两种方法解决这道题？
	 */
	@Override
	public ListNode reverseList(ListNode head) {
		if(head == null) return null;
		ListNode current = head;
		ListNode pre = null;
		while (current != null){
			ListNode next = current.next;
			current.next = pre;
			pre = current;
			current = next;
		}
		// next还有最后一个null 舍弃
		return pre;
	}
}
