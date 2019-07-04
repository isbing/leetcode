---
title: LeetCode206-单链表反转
date: 2019-07-04
categories: 算法小白的刷题之路
tags: LeetCode
---

## 题目
反转一个单链表。

示例:

输入: 1->2->3->4->5->NULL

输出: 5->4->3->2->1->NULL

进阶:

你可以迭代或递归地反转链表。你能否用两种方法解决这道题？

## 分析
输入: 1->2->3->4->5->NULL

- 第一步： null <- 1  |||  2->3->4->5->null

- 第二步： null <- 1 <- 2 ||| 3->4->5->null

- ....

这样就完成了单链表的反转，主要是第一步要注意一下。。

 Time: O(n), Space: O(1)

## 解答

````java
import org.junit.Test;
public class LeetCode206Test {

	public ListNode reverseList(ListNode head) {
		// 输入: 1->2->3->4->5->NULL
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

````









