---
title: LeetCode19-删除单链表倒数第K个节点
date: 2019-07-26
categories: 算法小白的刷题之路
tags: LeetCode
---

## 题目

给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。

示例：

给定一个链表: 1->2->3->4->5, 和 n = 2.

当删除了倒数第二个节点后，链表变为 1->2->3->5.

## 分析

对于链表的题目，其实我们都可以定义一个头节点。。

拥有头节点的链表 方便操作，才是拥有灵魂的！

目前就是  head -> 1 -> 2 -> 3 -> 4 -> 5  n=2

1. 定义初始指针p,q指向 head节点
2. 先让q移动n步，此时q指向2 p指向head
3. 现在只要q.next!=null p,q指针就一起移动，当q.next为null时，q指向5 p指向3
4. p.next = p.next.next 删除这个节点
5. 返回head.next即可

Time: O(k), Space: O(1)
## 解答

````java
import org.junit.Test;
public class LeetCode19Test {

	public ListNode removeNthFromEnd(ListNode head, int n) {
		ListNode temp = new ListNode(0);
		temp.next = head;

		// 定义两个指针 指向头节点
		ListNode p = temp;
		ListNode q = temp;
		// q 先走n步
		for(int i=1; i<=n; i++){
			q = q.next;
		}
		// 只要q.next != null 就一起走
		while (q.next != null){
			p = p.next;
			q = q.next;
		}
		// 移除指针
		p.next = p.next.next;
		return temp.next;
	}
}


````









