package com.isbing.leetcode.coding;

import com.isbing.leetcode.bean.ListNode;

/**
 * Created by song bing
 * Created time 2020/3/10 15:45
 */
public class LeetCode2 {

	// l1:2-4-3 l2:5-6-4  342+465=807 -> 7-0-8
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		// 由于题目的特殊性 直接将两个链表中的每个元素依次相加，注意进位
		int flag = 0;
		ListNode head = new ListNode(0);
		ListNode p = head;
		// 只要两个链表有长度，或者 有进位 都是要进入循环的
		while (l1 != null || l2 != null || flag != 0){
			int l1Val = 0, l2Val = 0;
			if(l1 != null){
				l1Val = l1.val;
				l1 = l1.next;
			}
			if(l2 != null){
				l2Val = l2.val;
				l2 = l2.next;
			}
			// 新链表中的元素
			int l3Val = l1Val + l2Val + flag;
			// 判断是否需要进位
			if(l3Val > 9){
				flag = 1;// 下次使用
				l3Val = l3Val % 10;// 新链表中的元素只能用你的余数了 因为你进位了
			}else{
				// 不用进位 需要将标识重置为0
				flag = 0;
			}
			// 这里典型的尾插法
			ListNode l3 = new ListNode(l3Val);
			p.next = l3;
			p = l3;
		}
		return head.next;
	}

}
