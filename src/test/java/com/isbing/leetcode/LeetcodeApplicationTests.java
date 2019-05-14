package com.isbing.leetcode;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LeetcodeApplicationTests {

	@Test
	public void contextLoads() {





	}

	/**
	 *  合并两个有序链表
	 *  将两个有序链表合并为一个新的有序链表并返回。
	 *  新链表是通过拼接给定的两个链表的所有节点组成的。
	 *
	 *  输入：1->2->4, 1->3->4
	 * 输出：1->1->2->3->4->4
	 *
	 */
	public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		ListNode head = new ListNode(0);
		ListNode node = head;
		while (l1 != null && l2 != null){
			if(l1.val <= l2.val){ // 谁小 就移动谁
				node.next = new ListNode(l1.val);
				l1 = l1.next;
			}else{
				node.next = new ListNode(l2.val);
				l2 = l2.next;
			}
		}
		if (l1 != null){
			node.next = l1;
		}
		if(l2 != null){
			node.next = l2;
		}
		return head.next;
	}


	public static class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
	}

}
