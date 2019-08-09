---
title: LeetCode82-有序链表去重V2
date: 2019-07-30
categories: 算法小白的刷题之路
tags: LeetCode
---

## 题目

给定一个排序链表，删除所有含有重复数字的节点，只保留原始链表中 没有重复出现 的数字。

示例 1:

输入: 1->2->3->3->4->4->5

输出: 1->2->5

示例 2:

输入: 1->1->2->3

输出: 2->3


## 分析
老样子 对于链表的题目 加上一个头结点 便于处理

这个题目与普通有序删链表不同的在于 只要重复的数字 就都不留。。。

head -> 1 -> 1 -> 1 -> 2 -> 3

1. 首先定义两个指针 p=head,q=head.next
2. q只要不为null 就一直循环
3. while处理中 q.val == q.next.val  q = q.next 此时p在head上，q在第三个1处
4. 如果 p.next != q 就说明出现了重复的数字 需要删除 p.next = q.next;q=q.next;
5. 如果 相等，同时后移 p=q;q=q.next;

Time: O(n), Space: O(1)
## 解答

````java
import org.junit.Test;
public class LeetCode82Test {

	public ListNode deleteDuplicates(ListNode head) {
		ListNode temp = new ListNode(-1);
		temp.next = head;

		// 定义两个前后指针
		ListNode p = temp;
		ListNode q = p.next;
		while (q != null){
			// 首先循环查找是否有相同的元素
			while (q.next != null && q.val == q.next.val) q = q.next;
			// 只要不相等，就说明跑了。此时就不会相等
			if(p.next != q){
				// 需要删除
				p.next = q.next;
				q = q.next;
			}else{
				// 不用删除 两个一起移动
				p = q;
				q = q.next;
			}
		}
		return temp.next;
	}
}



````









