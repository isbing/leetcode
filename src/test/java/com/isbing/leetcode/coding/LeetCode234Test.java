package com.isbing.leetcode.coding;

import com.isbing.leetcode.bean.ListNode;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Created by song bing
 * Created time 2019/6/27 17:34
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class LeetCode234Test {

	// 时间0(N) 空间O(N)
	public boolean isPalindrome(ListNode head) {
		if(head == null) return true;

		Stack<ListNode> stack = new Stack<>();
		ListNode p = head;
		ListNode q = head;
		while (p != null){
			stack.push(p);
			p = p.next;
		}
		// 出栈
		while (!stack.isEmpty()){
			ListNode node = stack.pop();
			if(q.val != node.val){
				return false;
			}
			q = q.next;
		}
		return true;
	}

	// 时间0(N) 空间O(1)
	public boolean isPalindromeV2(ListNode head) {
		if(head == null) return true;
		int len = 0;
		ListNode p = head;
		while (p != null){
			len++;
			p = p.next;
		}
		ListNode pre = null;
		ListNode q = head;
		for(int i=0; i<len/2; i++){
			ListNode next = q.next;
			q.next = pre;
			pre = q;
			q = next;
		}
		// 如果是奇数的时候 q还需要向后移动一位
		if(len % 2 == 1){
			q = q.next;
		}
		// 此时 pre指向前半个链表 q指向后半个链表
		while (pre != null && q != null){
			if(pre.val != q.val){
				return false;
			}
			pre = pre.next;
			q = q.next;
		}
		return true;
	}
}
