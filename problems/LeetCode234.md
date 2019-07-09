---
title: LeetCode234-回文链表
date: 2019-07-06
categories: 算法小白的刷题之路
tags: LeetCode
---

## 题目
请判断一个链表是否为回文链表。

示例 1:

输入: 1->2

输出: false

示例 2:

输入: 1->2->2->1

输出: true

进阶：

你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？

## 分析

### 解法1 
我们之前做过回文数的题目，那里提供的思路是 将数字转为字符串，或者从右向左读 构造一个新的数字

但是这里是链表，我们正常的思路 只能是将每一个链表的节点值压入栈中。最后出栈与链表中的值比较

时间0(N) 空间O(N)

### 解法2
因为上面用到了栈，空间复杂度提高了，可不可以不借助辅助栈呢？

链表遍历一次 得到长度，然后将前面一半的链表进行反转。

这样就出现了两个一半的链表，然后这两个链表同时遍历比较即可【注意奇数的情况】

时间0(N) 空间O(1)

## 解答

````java
import org.junit.Test;
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


````









