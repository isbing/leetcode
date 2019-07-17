---
title: LeetCode203-单链表删除指定节点
date: 2019-07-13
categories: 算法小白的刷题之路
tags: LeetCode
---

## 题目
删除链表中等于给定值 val 的所有节点。

示例:

输入: 1->2->6->3->4->5->6, val = 6

输出: 1->2->3->4->5


## 分析

删除节点，肯定是出现 前后指针的。但是没有头结点，很不利于我们操作。

我们可以new一个头结点，将其指向单链表。这样用前后指针就OK了

Time: O(n), Space: O(1)

## 解答

````java
import org.junit.Test;
public class LeetCode203Test {

	public ListNode removeElements(ListNode head, int val) {
		// 定义一个头结点 不然没有头结点 很不好操作
		ListNode pre = new ListNode(-1);
		pre.next = head;
		ListNode p = pre;

		while (head != null){
			if(head.val == val){
				head = head.next;
				pre.next = head;
			}else{
				// 不等 两指针都向后移动一下
				head = head.next;
				pre = pre.next;
			}
		}
		return p.next;
	}

}


````









